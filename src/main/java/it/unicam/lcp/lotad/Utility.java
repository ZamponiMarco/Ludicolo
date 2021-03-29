package it.unicam.lcp.lotad;

import org.drools.core.spi.KnowledgeHelper;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieSession;

public class Utility {

    public static void createEventListener(KieSession kSession) {
        RuleRuntimeEventListener listener = new RuleRuntimeEventListener() {

            // Listen to the update event
            public void objectUpdated(ObjectUpdatedEvent arg0) {
                System.out.println("*****Object Updated*****\n"
                        +arg0.getObject().toString());
                System.out.println();
            }

            // Listen to the insert event
            public void objectInserted(ObjectInsertedEvent arg0) {
                System.out.println("*****Object inserted***** \n"
                        + arg0.getObject().toString());
                System.out.println();
            }

            // Listen to the delete event
            public void objectDeleted(ObjectDeletedEvent arg0) {
                System.out.println("*****Object Retracted*****\n"
                        + arg0.getOldObject().toString());
                System.out.println();
            }
        };

        // Add the event listener to the session
        kSession.addEventListener(listener);

    }

    public static void help(final KnowledgeHelper drools, final String message){
        System.out.println(message);
        System.out.println("*****Rule triggered*****\n" + drools.getRule().getName());
        System.out.println();
    }
    public static void helper(final KnowledgeHelper drools){
        System.out.println("*****Rule triggered*****\n" + drools.getRule().getName());
        System.out.println();
    }

}
