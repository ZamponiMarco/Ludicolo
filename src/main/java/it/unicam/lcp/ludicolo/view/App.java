package it.unicam.lcp.ludicolo.view;

import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.Battle;
import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.Utility;
import it.unicam.lcp.ludicolo.actions.items.Item;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.PokemonFactory;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class App extends Application {

    public static StackPane pokemonOnePane;
    public static StackPane pokemonTwoPane;
    public static TextArea log;
    public static Battle battle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        primaryStage.setTitle("Ludicolo");
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        pokemonOnePane = new StackPane();
        pokemonOnePane.setAlignment(Pos.BOTTOM_CENTER);
        pokemonTwoPane = new StackPane();
        pokemonTwoPane.setAlignment(Pos.TOP_CENTER);
        StackPane logPane = new StackPane();
        logPane.setAlignment(Pos.CENTER);
        log = new TextArea();
        log.setText("This is the start of the log");
        log.setEditable(false);
        log.setMaxWidth(400);
        log.setMaxHeight(200);
        logPane.getChildren().add(log);

        root.getChildren().addAll(logPane, pokemonOnePane, pokemonTwoPane);

        new Thread(() -> {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Map<Item, Integer> playerOneBackpack = new HashMap<>();
            Map<Item, Integer> playerTwoBackpack = new HashMap<>();
            for (Item singleItem: Item.values()) {
                playerOneBackpack.put(singleItem, 5);
                playerTwoBackpack.put(singleItem, 5);
            }

            battle = new Battle(
                    new Player("Red", Lists.newArrayList(PokemonFactory.getCharizard(), PokemonFactory.getVenusaur(), PokemonFactory.getEevee()), playerOneBackpack),
                    new Player("Blue", Lists.newArrayList(PokemonFactory.getPikachu(), PokemonFactory.getBlastoise(), PokemonFactory.getMewtwo()), playerTwoBackpack)
            );

            kSession.insert(battle);
            kSession.getAgenda().getAgendaGroup("battle setup").setFocus();
            Utility.createEventListener(kSession);
            kSession.fireAllRules();
        }).start();
    }

    public static void refresh(Pokemon pokemonA, Pokemon pokemonB) {
        Platform.runLater(() -> {
            Pokemon pokemonOne = pokemonA.getOwner().equals(battle.getPlayerOne()) ? pokemonA : pokemonB;
            Pokemon pokemonTwo = pokemonB.getOwner().equals(battle.getPlayerTwo()) ? pokemonB : pokemonA;

            if (pokemonOnePane.getChildren().size() == 0) {
                pokemonOnePane.getChildren().add(0, new Text(pokemonOne.getName() + ": " + pokemonOne.getStageValue(Stat.LIFE)));
            } else {
                pokemonOnePane.getChildren().set(0, new Text(pokemonOne.getName() + ": " + pokemonOne.getStageValue(Stat.LIFE)));
            }
            if (pokemonTwoPane.getChildren().size() == 0) {
                pokemonTwoPane.getChildren().add(0, new Text(pokemonTwo.getName() + ": " + pokemonTwo.getStageValue(Stat.LIFE)));
            } else {
                pokemonTwoPane.getChildren().set(0, new Text(pokemonTwo.getName() + ": " + pokemonTwo.getStageValue(Stat.LIFE)));
            }
        });
    }

    public static void log(String s) {
        Platform.runLater(() -> log.appendText(System.lineSeparator() + s));
        System.out.println(s);
    }
}