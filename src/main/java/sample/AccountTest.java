package sample;


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
    	    // load the drl files contained in the package specified inside kmodule.xml
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            
            // Step2 - add the event listener to the session
            createEventListener(kSession);
            
            // Step1 - go !
            //Account a = new Account();
            //kSession.insert(a);
            //kSession.fireAllRules();
            
            // Step3 - test all the events
            //testAllEvents(kSession);
            
            // Step4 - test the CashFlow class
            //testCashFlow(kSession);
            
            // Step 5 - test bindings
            testBindings(kSession);
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
	
	public static void testAllEvents(KieSession kSession) {
		Account a = new Account(); 
		// 1 - create an account instance with the accountNumber
		a.setAccountNumber(10);
        FactHandle handlea = kSession.insert(a);
        // 2  - update the balance value of the account instance
        a.setBalance(12.0);
        kSession.update(handlea, a);
        // 3 - delete the account instance
        kSession.delete(handlea);
        // Evaluate rules
        kSession.fireAllRules();
        System.out.println("\nClose...");
        
        /*
		  Account a = new Account();
		  kSession.insert(a);
		  kSession.fireAllRules();
		  kSession.fireAllRules();
	
		The rule is fired only once.
	
		  Account a = new Account();
		  kSession.insert(a);
		  kSession.fireAllRules();
		  a.setAccountNo(10);
		  kSession.fireAllRules();
		
		The rule is fired only once.
		
		  Account a = new Account();
		  a.setAccountNo(10);
		  FactHandle handlea = kSession.insert(a);
		  kSession.fireAllRules();
		  a.setBalance(12.0);
		  kSession.update(handlea, a); 
		  kSession.fireAllRules();
			
		The rule is fired twice.
         */
	}
	
	public static void testCashFlow(KieSession kSession) {
		 CashFlow a = new CashFlow();
         FactHandle handlea = kSession.insert(a);
         kSession.fireAllRules();
         System.out.println("\nClose...");
	}
	
	public static void testBindings(KieSession kSession) throws Exception {
		// 1 - create an account instance with some default values
		Account a = new Account();
        a.setAccountNumber(1);
        a.setBalance(0);
        kSession.insert(a);
        
        // 2 - create a cashFlow instance with some default values
        CashFlow cash1 = new CashFlow();
        cash1.setAccountNumber(1);
        cash1.setAmount(1000);
        cash1.setType(CashFlow.CREDIT);
        
        // 3 - create a second instance with the credit type
        CashFlow cash2 = new CashFlow();
        cash2.setAccountNumber(2);
        cash2.setAmount(500);
        cash2.setType(CashFlow.CREDIT);
       
        // 4 - create a cashflow instance with the debit type
        CashFlow cash3 = new CashFlow();
        cash3.setAccountNumber(1);
        cash3.setAmount(500);
        cash3.setType(CashFlow.DEBIT);
        
        // Step 6 - creates and test date bindings
        setDates(cash1, cash2, cash3, kSession);
        
        kSession.insert(cash1);
        kSession.insert(cash2);
        kSession.insert(cash3);
                    
        kSession.fireAllRules();
        System.out.println("Balance of account n. "
        + a.getAccountNumber() + ": " + a.getBalance()); //1000,0
        System.out.println("Close...");
		
	}
	
	public static void setDates(CashFlow cash1, CashFlow cash2, CashFlow cash3, KieSession kSession) throws Exception {
		cash1.setMvtDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-1"));
		cash2.setMvtDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-1"));
		cash3.setMvtDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-1"));
		
		AccountingPeriod period = new AccountingPeriod();
        period.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
        period.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-1"));
        kSession.insert(period);
	}
} 
