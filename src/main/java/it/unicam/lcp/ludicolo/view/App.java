package it.unicam.lcp.ludicolo.view;

import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.Battle;
import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.PlayerFactory;
import it.unicam.lcp.ludicolo.Utility;
import it.unicam.lcp.ludicolo.actions.items.Item;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.PokemonFactory;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App extends Application {

    public static Battle battle;
    public static Scene scene;

    private static String usedImageOne = "";
    private static String usedImageTwo = "";

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
        new Thread(() -> {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            battle = new Battle(PlayerFactory.getRandomPlayer("RED"), PlayerFactory.getRandomPlayer("BLUE"));

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

    public static void log(String s) {
        Platform.runLater(() -> ((TextArea) scene.lookup("#log_pane")).appendText(System.lineSeparator() + "> " + s));
        System.out.println(s);
    }
}