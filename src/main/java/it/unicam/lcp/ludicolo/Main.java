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
import java.util.List;

// TODO Francesco: Implement agenda-groups ("setup-battle", "turn", "before-actions", "execute-actions", "after-actions", "check-status")
// TODO Marco: Implement pokemon swap (retract old and add new)
// TODO Marco: Implement simple view
// TODO Marco: Implement moves


/*Agenda groups:
battle setup -> turn setup <-> turn management <->
*/
public class Main {
    public static void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Utility.createEventListener(kSession);

            Pokemon pokeOne = PokemonFactory.getCharizard();
            Pokemon pokeTwo = PokemonFactory.getVenusaur();

            Player playerOne = new Player("Red", Lists.newArrayList(pokeOne));
            Player playerTwo = new Player("Blue", Lists.newArrayList(pokeTwo));

            kSession.insert(playerOne);
            kSession.insert(playerTwo);

            kSession.insert(pokeOne);
            kSession.insert(pokeTwo);

            Battle battle = new Battle();
            battle.setPlayerOne(playerOne);
            battle.setPlayerTwo(playerTwo);

            kSession.insert(battle);
            kSession.getAgenda().getAgendaGroup("battle setup").setFocus();
            kSession.fireAllRules();
            

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
