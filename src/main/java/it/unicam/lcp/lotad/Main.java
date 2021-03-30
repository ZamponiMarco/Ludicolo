package it.unicam.lcp.lotad;

import com.google.common.collect.Lists;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Utility.createEventListener(kSession);

            List<Move> moves = Lists.newArrayList(Move.POUND, Move.RAZOR_WIND, Move.SWORDS_DANCE);


            Pokemon pokeOne = new Pokemon("One", moves, 5, 10, 10, 10, 10, 10, 10);
            Pokemon pokeTwo = new Pokemon("Two", moves, 5, 10, 10, 10, 10, 10, 100);

            Player playerOne = new Player("PlayerOne", Lists.newArrayList(pokeOne));
            Player playerTwo = new Player("PlayerTwo", Lists.newArrayList(pokeTwo));

            kSession.insert(pokeOne);
            kSession.insert(pokeTwo);

            Action moveAction = new MoveAction(playerOne, Move.POUND, pokeTwo);
            Action moveActionTwo = new MoveAction(playerTwo, Move.RAZOR_WIND, pokeOne);

            kSession.insert(moveActionTwo);
            kSession.insert(moveAction);


            Battle battle = new Battle();
            battle.setPlayerOne(playerOne);
            battle.setPlayerTwo(playerTwo);
            battle.setActionsFired(false);

            kSession.insert(battle);

            kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
