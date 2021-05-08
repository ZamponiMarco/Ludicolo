package it.unicam.lcp.ludicolo;

import org.drools.core.spi.KnowledgeHelper;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieSession;

import java.util.Random;

public class Utility {

    public static void createEventListener(KieSession kSession) {
        RuleRuntimeEventListener listener = new RuleRuntimeEventListener() {

            // Listen to the update event
            public void objectUpdated(ObjectUpdatedEvent arg0) {
                System.out.println("_______Object Updated__________________________________________________________\n"
                        + arg0.getObject().toString());
                System.out.println();
            }

            // Listen to the insert event
            public void objectInserted(ObjectInsertedEvent arg0) {
                System.out.println("_______Object Inserted__________________________________________________________\n"
                        + arg0.getObject().toString());
                System.out.println();
            }

            // Listen to the delete event
            public void objectDeleted(ObjectDeletedEvent arg0) {
                System.out.println("_______Object Retracted__________________________________________________________\n"
                        + arg0.getOldObject().toString());
                System.out.println();
            }
        };

        // Add the event listener to the session
        kSession.addEventListener(listener);

    }

    public static void help(final KnowledgeHelper drools, final String message) {
        System.out.println(message);
        System.out.println("_______Rule Triggered__________________________________________________________\n" + drools.getRule().getName() + "\n" + "[Agenda Group: "+drools.getRule().getAgendaGroup()+"]");
        System.out.println();
    }

    public static void helper(final KnowledgeHelper drools) {
        System.out.println("_______Rule Triggered__________________________________________________________\n" + drools.getRule().getName() + "\n" + "[Agenda Group: "+drools.getRule().getAgendaGroup()+"]");
        System.out.println();
    }

    public static int calculateBattleLife(int baseLife, int level) {
        return ((2 * baseLife * level) / 100) + level + 10;
    }

    public static int calculateBattleStat(int baseStat, int level) {
        return Math.round(((2 * baseStat * level) / 100.0f) + 10);
    }

    public static int calculateDamage(int level, int power, double attack, double defense, double modifier) {
        return (int) Math.round((((((((2 * level) / 5.0f) + 2) * power) * (attack / defense)) / 50) + 2) * modifier);
    }

    public static boolean probabilityCheck(int probability) {
        int randomValue = new Random().nextInt(100);
        System.out.println(randomValue + "/" + probability);
        return randomValue < probability;
    }

}
