package it.unicam.lcp.ludicolo.pkmn;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unicam.lcp.ludicolo.Type;
import it.unicam.lcp.ludicolo.actions.moves.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PokemonFactory {
    public static Pokemon getCharizard(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "CHARIZARD";
        String displayName = "Charizard";

        List<Type> types = Lists.newArrayList(Type.FIRE, Type.FLYING);
        List<Move> moves = Lists.newArrayList(Move.PROTECT, Move.EMBER, Move.FIRE_PUNCH, Move.QUICK_ATTACK);
        int level = 100;
        stats.put(Stat.LIFE, 78);
        stats.put(Stat.ATTACK, 84);
        stats.put(Stat.DEFENSE, 78);
        stats.put(Stat.SPECIAL_ATTACK, 109);
        stats.put(Stat.SPECIAL_DEFENSE, 85);
        stats.put(Stat.SPEED, 100);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

    public static Pokemon getVenusaur(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "VENUSAUR";
        String displayName = "Venusaur";
        List<Type> types = Lists.newArrayList(Type.GRASS, Type.POISON);
        List<Move> moves = Lists.newArrayList(Move.CONFUSE_RAY, Move.BUG_BUZZ, Move.MAGICAL_LEAF, Move.SLEEP_POWDER);
        int level = 100;
        stats.put(Stat.LIFE, 80);
        stats.put(Stat.ATTACK, 82);
        stats.put(Stat.DEFENSE, 83);
        stats.put(Stat.SPECIAL_ATTACK, 100);
        stats.put(Stat.SPECIAL_DEFENSE, 100);
        stats.put(Stat.SPEED, 80);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

    public static Pokemon getBlastoise(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "BLASTOISE";
        String displayName = "Blastoise";

        List<Type> types = Lists.newArrayList(Type.WATER);
        List<Move> moves = Lists.newArrayList(Move.SURF, Move.WATER_GUN, Move.ICE_PUNCH, Move.POUND);
        int level = 100;
        stats.put(Stat.LIFE, 79);
        stats.put(Stat.ATTACK, 83);
        stats.put(Stat.DEFENSE, 100);
        stats.put(Stat.SPECIAL_ATTACK, 85);
        stats.put(Stat.SPECIAL_DEFENSE, 105);
        stats.put(Stat.SPEED, 78);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

    public static Pokemon getPikachu(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "PIKACHU";
        String displayName = "Pikachu";

        List<Type> types = Lists.newArrayList(Type.ELECTRIC);
        List<Move> moves = Lists.newArrayList(Move.QUICK_ATTACK, Move.SURF, Move.THUNDER_PUNCH, Move.THUNDER_WAVE);
        int level = 100;
        stats.put(Stat.LIFE, 35);
        stats.put(Stat.ATTACK, 55);
        stats.put(Stat.DEFENSE, 30);
        stats.put(Stat.SPECIAL_ATTACK, 50);
        stats.put(Stat.SPECIAL_DEFENSE, 40);
        stats.put(Stat.SPEED, 90);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

    public static Pokemon getEevee(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "EEVEE";
        String displayName = "Eevee";

        List<Type> types = Lists.newArrayList(Type.NORMAL);
        List<Move> moves = Lists.newArrayList(Move.TRI_ATTACK, Move.WATER_GUN, Move.EMBER, Move.THUNDER_WAVE);
        int level = 100;
        stats.put(Stat.LIFE, 55);
        stats.put(Stat.ATTACK, 55);
        stats.put(Stat.DEFENSE, 50);
        stats.put(Stat.SPECIAL_ATTACK, 45);
        stats.put(Stat.SPECIAL_DEFENSE, 65);
        stats.put(Stat.SPEED, 55);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

    public static Pokemon getMewtwo(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "MEWTWO";
        String displayName = "Mewtwo";

        List<Type> types = Lists.newArrayList(Type.PSYCHIC);
        List<Move> moves = Lists.newArrayList(Move.PROTECT, Move.PSYCHIC, Move.HYPNOSIS, Move.QUICK_ATTACK);
        int level = 100;
        stats.put(Stat.LIFE, 106);
        stats.put(Stat.ATTACK, 110);
        stats.put(Stat.DEFENSE, 90);
        stats.put(Stat.SPECIAL_ATTACK, 154);
        stats.put(Stat.SPECIAL_DEFENSE, 90);
        stats.put(Stat.SPEED, 130);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

    public static Pokemon getLudicolo(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "LUDICOLO";
        String displayName = "Ludicolo";

        List<Type> types = Lists.newArrayList(Type.WATER, Type.GRASS);
        List<Move> moves = Lists.newArrayList(Move.PROTECT, Move.QUICK_ATTACK, Move.SURF, Move.MAGICAL_LEAF);
        int level = 100;
        stats.put(Stat.LIFE, 80);
        stats.put(Stat.ATTACK, 70);
        stats.put(Stat.DEFENSE, 70);
        stats.put(Stat.SPECIAL_ATTACK, 90);
        stats.put(Stat.SPECIAL_DEFENSE, 100);
        stats.put(Stat.SPEED, 70);
        return new Pokemon(name,displayName,types, moves, level, stats);
    }

}
