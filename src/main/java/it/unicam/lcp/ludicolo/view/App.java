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
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class App extends Application {

    private static final ExecutorService inputExecutor = Executors.newCachedThreadPool();
    public static Battle battle;
    public static Scene scene;

    public static void main(String[] args) {
        launch(args);
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
            String newImage = Objects.requireNonNull(App.class.getResource("/assets/" + pokemon.getName().
                    toUpperCase() + "_" + imageSide + ".gif")).toExternalForm();
            ImageView imageView = ((ImageView) scene.lookup("#pokemon_" + number + "_img"));
            if (imageView.getImage() == null || !imageView.getImage().getUrl().equals(newImage)) {
                imageView.setImage(new Image(newImage));
            }
            ImageView statusImageView = ((ImageView) scene.lookup("#pokemon_" + number + "_status"));
            if (pokemon.getStatus() != null) {
                statusImageView.setImage(new Image(Objects.requireNonNull(App.class.
                        getResource("/assets/" + pokemon.getStatus().name() + ".png")).toExternalForm()));
            } else {
                statusImageView.setImage(null);
            }
        });
    }

    public static Future<Action> selectMoves(Player sourcePlayer, Player targetPlayer, Pokemon sourcePokemon) {
        Callable<Action> action = () -> {
            SimpleObjectProperty<Action> toReturn = new SimpleObjectProperty<>();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);

            Text selected = ((Text) scene.lookup("#selected_move"));

            ((Button) scene.lookup("#submit_move")).setOnAction(event -> atomicBoolean.set(true));

            toReturn.addListener((observableValue, oldValue, newValue) -> selected.setText(newValue.getName()));

            Platform.runLater(() -> {
                ((Text) scene.lookup("#current_player_text")).setText(sourcePlayer.getName() + " is choosing for " + sourcePokemon.getDisplayName());

                setUpMoves(sourcePlayer, targetPlayer, sourcePokemon, toReturn);

                setUpPokemons(sourcePlayer, sourcePokemon, toReturn);

                setUpItems(sourcePlayer, toReturn);
            });

            while (toReturn.get() == null || !atomicBoolean.get()) {

            }

            selected.setText(null);
            return toReturn.get();
        };
        return inputExecutor.submit(action);
    }

    private static void setUpItems(Player sourcePlayer, SimpleObjectProperty<Action> toReturn) {
        ComboBox<ItemWrapper> items = ((ComboBox<ItemWrapper>) scene.lookup("#items_list"));
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
                            String boxImage = Objects.requireNonNull(App.class.getResource("/assets/" +
                                    item.getItem().name() + ".png")).toExternalForm();
                            setGraphic(new ImageView(new Image(boxImage)));
                        }
                    }
                };
            }
        });

        items.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                toReturn.set(new ItemAction(sourcePlayer, newValue.getItem()));
            } catch (Exception e) {
                System.out.println("Exception from GUI: " + e.getMessage());
            }

        });
    }

    private static void setUpPokemons(Player sourcePlayer, Pokemon sourcePokemon, SimpleObjectProperty<Action> toReturn) {
        ComboBox<PokemonWrapper> pokemons = ((ComboBox<PokemonWrapper>) scene.lookup("#pokemons_list"));
        List<PokemonWrapper> pokemonList = sourcePlayer.getPokemonTeamNotFainted().stream().filter(pokemon ->
                pokemon != sourcePokemon).map(PokemonWrapper::new).collect(Collectors.toList());
        ObservableList<PokemonWrapper> pokemonObsList = FXCollections.observableArrayList(pokemonList);
        pokemons.setItems(pokemonObsList);

        pokemons.setCellFactory(new Callback<>() {
            @Override
            public ListCell<PokemonWrapper> call(ListView<PokemonWrapper> p) {
                return new ListCell<>() {

                    {
                        setContentDisplay(ContentDisplay.LEFT);
                    }

                    @Override
                    protected void updateItem(PokemonWrapper item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.toString());
                            String boxImage = Objects.requireNonNull(App.class.getResource("/assets/" +
                                    item.getPkmn().getName() + "_menu.png")).toExternalForm();
                            setGraphic(new ImageView(new Image(boxImage)));
                        }
                    }
                };
            }
        });

        pokemons.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                toReturn.set(new SwapAction(sourcePlayer, newValue.getPkmn()));
            } catch (Exception e) {
                System.out.println("Exception from GUI: " + e.getMessage());
            }
        });
    }

    private static void setUpMoves(Player sourcePlayer, Player targetPlayer, Pokemon sourcePokemon, SimpleObjectProperty<Action> toReturn) {
        ComboBox<MoveWrapper> moves = (ComboBox<MoveWrapper>) scene.lookup("#moves_list");
        List<MoveWrapper> movesList = sourcePokemon.getAvailableMoves().entrySet().stream().map(moveIntegerEntry -> new MoveWrapper(moveIntegerEntry.getKey(), moveIntegerEntry.getValue())).collect(Collectors.toList());
        ObservableList<MoveWrapper> movesObsList = FXCollections.observableArrayList(movesList);
        moves.setItems(movesObsList);

        moves.setCellFactory(new Callback<>() {
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
                            String boxImage = Objects.requireNonNull(App.class.getResource("/assets/" +
                                    item.getMove().getType().name() + ".png")).toExternalForm();
                            setGraphic(new ImageView(new Image(boxImage)));
                        }
                    }
                };
            }
        });

        moves.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                toReturn.set(new MoveAction(sourcePlayer, newValue.getMove(), targetPlayer));
            } catch (Exception e) {
                System.out.println("Exception from GUI: " + e.getMessage());
            }

        });
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

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Ludicolo");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        Parent root = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/gui.fxml")));
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        primaryStage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResource("/assets/icon.png")).
                toExternalForm()));

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
}