package it.unicam.lcp.ludicolo.view;

import it.unicam.lcp.ludicolo.Battle;
import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.PlayerFactory;
import it.unicam.lcp.ludicolo.Utility;
import it.unicam.lcp.ludicolo.actions.Action;
import it.unicam.lcp.ludicolo.actions.SwapAction;
import it.unicam.lcp.ludicolo.actions.items.ItemAction;
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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

//TODO Francesco: presentazione
//TODO Marco: bottone submit per la mossa scelta, selezione pokemon dopo fainted
public class App extends Application {

    public static Battle battle;
    public static Scene scene;

    private static final ExecutorService inputExecutor = Executors.newCachedThreadPool();

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

            battle = new Battle(PlayerFactory.getRandomPlayer("Red"), PlayerFactory.getRandomPlayer("Blue"));

            kSession.insert(battle);
            kSession.getAgenda().getAgendaGroup("battle setup").setFocus();
            Utility.createEventListener(kSession);
            kSession.fireAllRules();
        }).start();
    }

    public static void refresh(Pokemon pokemon) {
        boolean isPokemonOne = pokemon.getOwner().equals(battle.getPlayerOne());
        String number = isPokemonOne ? "one" : "two";
        String imageSide = isPokemonOne ? "back" : "front";
        Platform.runLater(() -> {
            ((Text) scene.lookup("#pokemon_" + number + "_name")).setText(pokemon.getDisplayName() + " Lv. " + pokemon.getLevel());
            int currentHealth = pokemon.getStageValue(Stat.LIFE);
            int maxHealth = pokemon.getBattleStatValue(Stat.LIFE);
            ((ProgressBar) scene.lookup("#pokemon_" + number + "_bar")).setProgress((double) currentHealth / maxHealth);
            ((Text) scene.lookup("#pokemon_" + number + "_life")).setText(currentHealth + "/" + maxHealth);
            String newImage = App.class.getResource("/assets/" + pokemon.getName().toUpperCase() + "_" + imageSide + ".gif").
                    toExternalForm();
            ImageView imageView = ((ImageView) scene.lookup("#pokemon_" + number + "_img"));
            if (imageView.getImage() == null || !imageView.getImage().getUrl().equals(newImage)) {
                imageView.setImage(new Image(newImage));
            }
            ImageView statusImageView = ((ImageView) scene.lookup("#pokemon_" + number + "_status"));
            if (pokemon.getStatus() != null) {
                statusImageView.setImage(new Image(App.class.
                        getResource("/assets/" + pokemon.getStatus().name() + ".png").toExternalForm()));
            } else {
                statusImageView.setImage(null);
            }
        });
    }

    //public static void refresh(Pokemon pokemonA, Pokemon pokemonB) {
    //    Platform.runLater(() -> {
    //        Pokemon pokemonOne = pokemonA.getOwner().equals(battle.getPlayerOne()) ? pokemonA : pokemonB;
    //        ((Text) scene.lookup("#pokemon_one_name")).setText(pokemonOne.getDisplayName() + " Lv. " + pokemonOne.getLevel());
    //        int pokemonOneCurrentHealth = pokemonOne.getStageValue(Stat.LIFE);
    //        int pokemonOneMaxHealth = pokemonOne.getBattleStatValue(Stat.LIFE);
    //        ((ProgressBar) scene.lookup("#pokemon_one_bar")).setProgress((double) pokemonOneCurrentHealth / pokemonOneMaxHealth);
    //        ((Text) scene.lookup("#pokemon_one_life")).setText(pokemonOneCurrentHealth + "/" + pokemonOneMaxHealth);
    //        String newImageOne = App.class.getResource("/assets/" + pokemonOne.getName().toUpperCase() + "_back.gif").toExternalForm();
    //        if (!newImageOne.equals(usedImageOne)) {
    //            ((ImageView) scene.lookup("#pokemon_one_img")).setImage(new Image(newImageOne));
    //            usedImageOne = newImageOne;
    //        }
    //        if (pokemonOne.getStatus() != null) {
    //            ((ImageView) scene.lookup("#pokemon_one_status")).setImage(new Image(App.class.
    //                    getResource("/assets/" + pokemonOne.getStatus().name() + ".png").toExternalForm()));
    //        } else {
    //            ((ImageView) scene.lookup("#pokemon_one_status")).setImage(null);
    //        }
//
    //        Pokemon pokemonTwo = pokemonB.getOwner().equals(battle.getPlayerTwo()) ? pokemonB : pokemonA;
    //        ((Text) scene.lookup("#pokemon_two_name")).setText(pokemonTwo.getDisplayName() + " Lv. " + pokemonTwo.getLevel());
    //        int pokemonTwoCurrentHealth = pokemonTwo.getStageValue(Stat.LIFE);
    //        int pokemonTwoMaxHealth = pokemonTwo.getBattleStatValue(Stat.LIFE);
    //        ((ProgressBar) scene.lookup("#pokemon_two_bar")).setProgress((double) pokemonTwoCurrentHealth / pokemonTwoMaxHealth);
    //        ((Text) scene.lookup("#pokemon_two_life")).setText(pokemonTwoCurrentHealth + "/" + pokemonTwoMaxHealth);
    //        String newImageTwo = App.class.getResource("/assets/" + pokemonTwo.getName().toUpperCase() + "_front.gif").toExternalForm();
    //        if (!newImageTwo.equals(usedImageTwo)) {
    //            ((ImageView) scene.lookup("#pokemon_two_img")).setImage(new Image(newImageTwo));
    //            usedImageTwo = newImageTwo;
    //        }
    //        if (pokemonTwo.getStatus() != null) {
    //            ((ImageView) scene.lookup("#pokemon_two_status")).setImage(new Image(App.class.
    //                    getResource("/assets/" + pokemonTwo.getStatus().name() + ".png").toExternalForm()));
    //        } else {
    //            ((ImageView) scene.lookup("#pokemon_two_status")).setImage(null);
    //        }
    //    });
    //}

    public static Future<Action> selectMoves(Player sourcePlayer, Player targetPlayer, Pokemon sourcePokemon) {
        Callable<Action> action = () -> {
            AtomicReference<Action> toReturn = new AtomicReference<>();

            Platform.runLater(() -> {
                ((Text) scene.lookup("#current_player_text")).setText(sourcePlayer.getName() + " is choosing for " + sourcePokemon.getDisplayName());

                ComboBox moves = ((ComboBox) scene.lookup("#moves_list"));
                List<MoveWrapper> movesList = sourcePokemon.getAvailableMoves().entrySet().stream().map(moveIntegerEntry -> new MoveWrapper(moveIntegerEntry.getKey(), moveIntegerEntry.getValue())).collect(Collectors.toList());
                ObservableList movesObsList = FXCollections.observableArrayList(movesList);
                moves.setItems(movesObsList);

                moves.setCellFactory(new Callback<ListView<MoveWrapper>, ListCell<MoveWrapper>>() {
                    @Override
                    public ListCell<MoveWrapper> call(ListView<MoveWrapper> p) {
                        return new ListCell<>() {

                            {
                                setContentDisplay(ContentDisplay.LEFT);
                            }

                            @Override
                            protected void updateItem(MoveWrapper item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setGraphic(null);
                                } else {
                                    setText(item.toString());
                                    String boxImage = App.class.getResource("/assets/" + item.getMove().getType().name() + ".png").toExternalForm();
                                    setGraphic(new ImageView(new Image(boxImage)));

                                }
                            }
                        };
                    }
                });

                moves.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    try{
                        toReturn.set(new MoveAction(sourcePlayer, ((MoveWrapper) newValue).getMove(), targetPlayer));
                    } catch (Exception e){
                        System.out.println("Exception from GUI: " + e.getMessage());
                    }

                });

                ComboBox<PokemonWrapper> pokemons = ((ComboBox) scene.lookup("#pokemons_list"));
                List<PokemonWrapper> pokemonList = sourcePlayer.getPokemonTeamNotFainted().stream().filter(pokemon -> pokemon != sourcePokemon).map(pokemon -> new PokemonWrapper(pokemon)).collect(Collectors.toList());
                ObservableList<PokemonWrapper> pokemonObsList = FXCollections.observableArrayList(pokemonList);
                pokemons.setItems(pokemonObsList);

                pokemons.setCellFactory(new Callback<>() {
                    @Override
                    public ListCell<PokemonWrapper> call(ListView<PokemonWrapper> p) {
                        return new ListCell<>() {
                            private final Rectangle rectangle;

                            {
                                setContentDisplay(ContentDisplay.LEFT);
                                rectangle = new Rectangle(5, 5);
                            }

                            @Override
                            protected void updateItem(PokemonWrapper item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setGraphic(null);
                                } else {
                                    setText(item.toString());
                                    String boxImage = App.class.getResource("/assets/" + item.getPkmn().getName() + "_menu.png").toExternalForm();
                                    setGraphic(new ImageView(new Image(boxImage)));

                                }
                            }
                        };
                    }
                });

                pokemons.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    try{
                        toReturn.set(new SwapAction(sourcePlayer, newValue.getPkmn()));
                    } catch (Exception e){
                        System.out.println("Exception from GUI: " + e.getMessage());
                    }
                });


                ComboBox<ItemWrapper> items = ((ComboBox) scene.lookup("#items_list"));
                List<ItemWrapper> itemList = sourcePlayer.getBackpack().entrySet().stream().map(itemIntegerEntry -> new ItemWrapper(itemIntegerEntry.getKey(), itemIntegerEntry.getValue())).collect(Collectors.toList());
                ObservableList<ItemWrapper> itemObsList = FXCollections.observableArrayList(itemList);
                items.setItems(itemObsList);

                items.setCellFactory(new Callback<>() {
                    @Override
                    public ListCell<ItemWrapper> call(ListView<ItemWrapper> p) {
                        return new ListCell<>() {

                            {
                                setContentDisplay(ContentDisplay.LEFT);

                            }

                            @Override
                            protected void updateItem(ItemWrapper item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setGraphic(null);
                                } else {
                                    setText(item.toString());
                                    String boxImage = App.class.getResource("/assets/" + item.getItem().name() + ".png").toExternalForm();
                                    setGraphic(new ImageView(new Image(boxImage)));
                                }
                            }
                        };
                    }
                });

                items.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                    try{
                        toReturn.set(new ItemAction(sourcePlayer, newValue.getItem()));
                    } catch (Exception e){
                        System.out.println("Exception from GUI: " + e.getMessage());
                    }

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}