package it.unicam.lcp.ludicolo;

import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.actions.items.Item;
import it.unicam.lcp.ludicolo.actions.items.ItemAction;
import it.unicam.lcp.ludicolo.actions.moves.Move;
import it.unicam.lcp.ludicolo.actions.moves.MoveAction;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.PokemonFactory;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO Marco: Implement simple view javafx vuole java 11
// TODO Marco: Implement moves



public class Main {
    public static void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Utility.createEventListener(kSession);
            
            Map<Item, Integer> playerOneBackpack = new HashMap<>();
            Map<Item, Integer> playerTwoBackpack = new HashMap<>();
            for (Item singleItem: Item.values()) {
                playerOneBackpack.put(singleItem, 5);
                playerTwoBackpack.put(singleItem, 5);
            }
            
            kSession.insert(new Battle(
                    new Player("Red", Lists.newArrayList(PokemonFactory.getCharizard(), PokemonFactory.getPikachu()), playerOneBackpack),
                    new Player("Blue", Lists.newArrayList(PokemonFactory.getVenusaur(), PokemonFactory.getBlastoise()), playerTwoBackpack)
            ));
            kSession.getAgenda().getAgendaGroup("battle setup").setFocus();
            kSession.fireAllRules();
            

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
