package it.unicam.lcp.ludicolo;

import org.kie.api.KieServices;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.text.SimpleDateFormat;

public class AccountTest {

	public static void main(String[] args) {
		try {
            // load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
            
            createEventListener(kSession);
            Account a = new Account();
            kSession.insert(a);
			kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }

	}
	
	
	public static void createEventListener(KieSession kSession) {
		RuleRuntimeEventListener listener = new RuleRuntimeEventListener() {
			
			// Listen to the update event
			public void objectUpdated(ObjectUpdatedEvent arg0) {
				System.out.println("*****Object Updated*****\n"
						+arg0.getObject().toString());
				
			}
			
			// Listen to the insert event
			public void objectInserted(ObjectInsertedEvent arg0) {
				System.out.println("*****Object inserted***** \n"
						+ arg0.getObject().toString());
				
			}
			
			// Listen to the delete event
			public void objectDeleted(ObjectDeletedEvent arg0) {
				System.out.println("*****Object Retracted*****\n"
						+ arg0.getOldObject().toString());
				
			}
		};
		
		// Add the event listener to the session
		kSession.addEventListener(listener);
		
	}

}
