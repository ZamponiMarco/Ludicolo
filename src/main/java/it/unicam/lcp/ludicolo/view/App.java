package it.unicam.lcp.ludicolo.view;

import it.unicam.lcp.ludicolo.Battle;
import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.PlayerFactory;
import it.unicam.lcp.ludicolo.Utility;
import it.unicam.lcp.ludicolo.actions.Action;
import it.unicam.lcp.ludicolo.actions.SwapAction;
import it.unicam.lcp.ludicolo.actions.items.Item;
import it.unicam.lcp.ludicolo.actions.items.ItemAction;
import it.unicam.lcp.ludicolo.actions.moves.Move;
import it.unicam.lcp.ludicolo.actions.moves.MoveAction;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

//TODO Francesco: getAvailableMoves, ComboBox, toString delle varie cose, presentazione
//TODO Marco: icone status, pokemon dentro swapaction, togliere pokemon in campo dal dropdown menu, statistiche a lato del pokemon, bottone submit per la mossa scelta, selezione pokemon dopo fainted
public class App extends Application {

    public static Battle battle;
    public static Scene scene;

    private static String usedImageOne = "";
    private static String usedImageTwo = "";
    private static ExecutorService inputExecutor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Ludicolo");
        Parent root = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/gui.fxml")));
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        primaryStage.getIcons().add(new Image(App.class.getResource("/assets/icon.png").toExternalForm()));

        new Thread(() -> {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            battle = new Battle(PlayerFactory.getLudicoloFan("RED"), PlayerFactory.getRandomPlayer("BLUE"));

            kSession.insert(battle);
            kSession.getAgenda().getAgendaGroup("battle setup").setFocus();
            Utility.createEventListener(kSession);
            kSession.fireAllRules();
        }).start();
    }

    public static void refresh(Pokemon pokemonA, Pokemon pokemonB) {
        Platform.runLater(() -> {
            Pokemon pokemonOne = pokemonA.getOwner().equals(battle.getPlayerOne()) ? pokemonA : pokemonB;
            ((Text) scene.lookup("#pokemon_one_name")).setText(pokemonOne.getName() + "\nLv. " + pokemonOne.getLevel());
            int pokemonOneCurrentHealth = pokemonOne.getStageValue(Stat.LIFE);
            int pokemonOneMaxHealth = pokemonOne.getBattleStatValue(Stat.LIFE);
            ((ProgressBar) scene.lookup("#pokemon_one_bar")).setProgress((double) pokemonOneCurrentHealth / pokemonOneMaxHealth);
            ((Text) scene.lookup("#pokemon_one_life")).setText(pokemonOneCurrentHealth + "/" + pokemonOneMaxHealth);
            String newImageOne = App.class.getResource("/assets/" + pokemonOne.getName().toUpperCase() + "_back.gif").toExternalForm();
            if (!newImageOne.equals(usedImageOne)) {
                ((ImageView) scene.lookup("#pokemon_one_img")).setImage(new Image(newImageOne));
                usedImageOne = newImageOne;
            }

            Pokemon pokemonTwo = pokemonB.getOwner().equals(battle.getPlayerTwo()) ? pokemonB : pokemonA;
            ((Text) scene.lookup("#pokemon_two_name")).setText(pokemonTwo.getName() + "\nLv. " + pokemonTwo.getLevel());
            int pokemonTwoCurrentHealth = pokemonTwo.getStageValue(Stat.LIFE);
            int pokemonTwoMaxHealth = pokemonTwo.getBattleStatValue(Stat.LIFE);
            ((ProgressBar) scene.lookup("#pokemon_two_bar")).setProgress((double) pokemonTwoCurrentHealth / pokemonTwoMaxHealth);
            ((Text) scene.lookup("#pokemon_two_life")).setText(pokemonTwoCurrentHealth + "/" + pokemonTwoMaxHealth);
            String newImageTwo = App.class.getResource("/assets/" + pokemonTwo.getName().toUpperCase() + "_front.gif").toExternalForm();
            if (!newImageTwo.equals(usedImageTwo)) {
                ((ImageView) scene.lookup("#pokemon_two_img")).setImage(new Image(newImageTwo));
                usedImageTwo = newImageTwo;
            }
        });
    }

    public static Future<Action> selectMoves(Player sourcePlayer, Player targetPlayer, Pokemon sourcePokemon) {
        Callable<Action> action = () -> {
            AtomicReference<Action> toReturn = new AtomicReference<>();

            Platform.runLater(() -> {
                ((Text) scene.lookup("#current_player_text")).setText(sourcePlayer.getName() + " is choosing for " + sourcePokemon.getName());

                ChoiceBox moves = ((ChoiceBox) scene.lookup("#moves_list"));
                ObservableList list = FXCollections.observableArrayList(sourcePokemon.getLearnedMoves().keySet());
                moves.setItems(list);
                moves.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    toReturn.set(new MoveAction(sourcePlayer, (Move) newValue, targetPlayer));
                });

                ChoiceBox pokemons = ((ChoiceBox) scene.lookup("#pokemons_list"));
                ObservableList pokemons_list = FXCollections.observableArrayList(sourcePlayer.getPokemonTeamNotFainted());
                pokemons.setItems(pokemons_list);
                pokemons.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    toReturn.set(new SwapAction(sourcePlayer, sourcePlayer.getPokemonTeamNotFainted().indexOf(newValue)));
                });


                ChoiceBox items = ((ChoiceBox) scene.lookup("#items_list"));
                ObservableList items_list = FXCollections.observableArrayList(sourcePlayer.getBackpack().keySet());
                items.setItems(items_list);
                items.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    toReturn.set(new ItemAction(sourcePlayer, (Item) newValue));
                });
            });

            while (toReturn.get() == null) {

            }

            return toReturn.get();
        };
        return inputExecutor.submit(action);
    }

    public static void log(String s) {
        Platform.runLater(() -> ((TextArea) scene.lookup("#log_pane")).appendText(System.lineSeparator() + "> " + s));
        System.out.println(s);
    }
}