package it.unicam.lcp.ludicolo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unicam.lcp.ludicolo.actions.Action;
import it.unicam.lcp.ludicolo.actions.items.ItemAction;
import it.unicam.lcp.ludicolo.actions.moves.Move;
import it.unicam.lcp.ludicolo.actions.moves.MoveAction;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Utility.createEventListener(kSession);

            List<Move> moves = Lists.newArrayList(Move.POUND, Move.RAZOR_WIND, Move.SWORDS_DANCE, Move.SUCKER_PUNCH);

            Map<Stat, Integer> pokeOneStats = Maps.newEnumMap(Stat.class);
            pokeOneStats.put(Stat.LIFE, 100);
            pokeOneStats.put(Stat.ATTACK, 10);
            pokeOneStats.put(Stat.DEFENSE, 10);
            pokeOneStats.put(Stat.SPECIAL_ATTACK, 10);
            pokeOneStats.put(Stat.SPECIAL_DEFENSE, 10);
            pokeOneStats.put(Stat.SPEED, 10);
            Pokemon pokeOne = new Pokemon("Nidorino", moves, 5, pokeOneStats);

            Map<Stat, Integer> pokeTwoStats = Maps.newEnumMap(Stat.class);
            pokeTwoStats.put(Stat.LIFE, 100);
            pokeTwoStats.put(Stat.ATTACK, 12);
            pokeTwoStats.put(Stat.DEFENSE, 8);
            pokeTwoStats.put(Stat.SPECIAL_ATTACK, 12);
            pokeTwoStats.put(Stat.SPECIAL_DEFENSE, 8);
            pokeTwoStats.put(Stat.SPEED, 200);
            Pokemon pokeTwo = new Pokemon("Gengar", moves, 5, pokeTwoStats);

            Player playerOne = new Player("Red", Lists.newArrayList(pokeOne));
            Player playerTwo = new Player("Blue", Lists.newArrayList(pokeTwo));

            kSession.insert(playerOne);
            kSession.insert(playerTwo);

            kSession.insert(pokeOne);
            kSession.insert(pokeTwo);

            Action moveAction = new MoveAction(playerOne, Move.SNARL, playerTwo);
            Action moveActionTwo = new MoveAction(playerTwo, Move.CONFUSE_RAY, playerOne);

            kSession.insert(moveAction);
            kSession.insert(moveActionTwo);


            Battle battle = new Battle();
            battle.setPlayerOne(playerOne);
            battle.setPlayerTwo(playerTwo);

            kSession.insert(battle);

            kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
