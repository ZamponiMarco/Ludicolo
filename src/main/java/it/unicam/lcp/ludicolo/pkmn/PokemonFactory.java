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
        List<Type> types = Lists.newArrayList(Type.FIRE, Type.FLYING);
        List<Move> moves = Lists.newArrayList(Move.SUCKER_PUNCH, Move.POUND);
        int level = 100;
        stats.put(Stat.LIFE, 78);
        stats.put(Stat.ATTACK, 84);
        stats.put(Stat.DEFENSE, 78);
        stats.put(Stat.SPECIAL_ATTACK, 109);
        stats.put(Stat.SPECIAL_DEFENSE, 85);
        stats.put(Stat.SPEED, 100);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getVenusaur(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "VENUSAUR";
        List<Type> types = Lists.newArrayList(Type.GRASS, Type.POISON);
        List<Move> moves = Lists.newArrayList(Move.CONFUSE_RAY);
        int level = 100;
        stats.put(Stat.LIFE, 80);
        stats.put(Stat.ATTACK, 82);
        stats.put(Stat.DEFENSE, 83);
        stats.put(Stat.SPECIAL_ATTACK, 100);
        stats.put(Stat.SPECIAL_DEFENSE, 100);
        stats.put(Stat.SPEED, 80);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getBlastoise(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "BLASTOISE";
        List<Type> types = Lists.newArrayList(Type.WATER);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 79);
        stats.put(Stat.ATTACK, 83);
        stats.put(Stat.DEFENSE, 100);
        stats.put(Stat.SPECIAL_ATTACK, 85);
        stats.put(Stat.SPECIAL_DEFENSE, 105);
        stats.put(Stat.SPEED, 78);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getPikachu(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "PIKACHU";
        List<Type> types = Lists.newArrayList(Type.ELECTRIC);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 35);
        stats.put(Stat.ATTACK, 55);
        stats.put(Stat.DEFENSE, 30);
        stats.put(Stat.SPECIAL_ATTACK, 50);
        stats.put(Stat.SPECIAL_DEFENSE, 40);
        stats.put(Stat.SPEED, 90);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getAlolanExeggutor(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "ALOLAN EXEGGUTOR";
        List<Type> types = Lists.newArrayList(Type.GRASS, Type.DRAGON);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 95);
        stats.put(Stat.ATTACK, 105);
        stats.put(Stat.DEFENSE, 85);
        stats.put(Stat.SPECIAL_ATTACK, 125);
        stats.put(Stat.SPECIAL_DEFENSE, 75);
        stats.put(Stat.SPEED, 45);
        return new Pokemon(name,types, moves, level, stats);
    }


    public static Pokemon getMewtwo(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "MEWTWO";
        List<Type> types = Lists.newArrayList(Type.PSYCHIC);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 106);
        stats.put(Stat.ATTACK, 110);
        stats.put(Stat.DEFENSE, 90);
        stats.put(Stat.SPECIAL_ATTACK, 154);
        stats.put(Stat.SPECIAL_DEFENSE, 90);
        stats.put(Stat.SPEED, 130);
        return new Pokemon(name,types, moves, level, stats);
    }

}
