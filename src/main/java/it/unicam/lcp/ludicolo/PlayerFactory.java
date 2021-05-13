package it.unicam.lcp.ludicolo;

import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.actions.items.Item;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.PokemonFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerFactory {

    public static Player getRandomPlayer(String name){
        Map<Item, Integer> backpack = new HashMap<>();
        for (Item singleItem : Item.values()) {
            backpack.put(singleItem, 5);
        }
        List<Pokemon> pkmns = Lists.newArrayList(PokemonFactory.getCharizard(), PokemonFactory.getVenusaur(), PokemonFactory.getBlastoise(), PokemonFactory.getPikachu(), PokemonFactory.getEevee(), PokemonFactory.getMewtwo());
        Collections.shuffle(pkmns);
        return new Player(name, pkmns, backpack);
    }

    public static Player getLudicoloFan(String name){
        Map<Item, Integer> backpack = new HashMap<>();
        for (Item singleItem : Item.values()) {
            backpack.put(singleItem, 5);
        }
        List<Pokemon> pkmns = Lists.newArrayList(PokemonFactory.getLudicolo(),PokemonFactory.getLudicolo(),PokemonFactory.getLudicolo(),PokemonFactory.getLudicolo(),PokemonFactory.getLudicolo(),PokemonFactory.getLudicolo());
        return new Player(name, pkmns, backpack);
    }
}
