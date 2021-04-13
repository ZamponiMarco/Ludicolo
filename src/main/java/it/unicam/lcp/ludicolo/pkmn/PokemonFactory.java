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
        List<Move> moves = new ArrayList<Move>();
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
        List<Move> moves = new ArrayList<Move>();
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

    public static Pokemon getButterfree(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "BUTTERFREE";
        List<Type> types = Lists.newArrayList(Type.BUG, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 60);
        stats.put(Stat.ATTACK, 45);
        stats.put(Stat.DEFENSE, 50);
        stats.put(Stat.SPECIAL_ATTACK, 80);
        stats.put(Stat.SPECIAL_DEFENSE, 80);
        stats.put(Stat.SPEED, 70);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getPidgeot(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "PIDGEOT";
        List<Type> types = Lists.newArrayList(Type.NORMAL, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 83);
        stats.put(Stat.ATTACK, 80);
        stats.put(Stat.DEFENSE, 75);
        stats.put(Stat.SPECIAL_ATTACK, 70);
        stats.put(Stat.SPECIAL_DEFENSE, 70);
        stats.put(Stat.SPEED, 101);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getSandslash(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "SANDSLASH";
        List<Type> types = Lists.newArrayList(Type.GROUND);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 75);
        stats.put(Stat.ATTACK, 100);
        stats.put(Stat.DEFENSE, 110);
        stats.put(Stat.SPECIAL_ATTACK, 45);
        stats.put(Stat.SPECIAL_DEFENSE, 55);
        stats.put(Stat.SPEED, 65);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getAlolanSandslash(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "ALOLAN SANDSLASH";
        List<Type> types = Lists.newArrayList(Type.ICE, Type.STEEL);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 75);
        stats.put(Stat.ATTACK, 100);
        stats.put(Stat.DEFENSE, 120);
        stats.put(Stat.SPECIAL_ATTACK, 25);
        stats.put(Stat.SPECIAL_DEFENSE, 65);
        stats.put(Stat.SPEED, 65);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getNidoking(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "NIDOKING";
        List<Type> types = Lists.newArrayList(Type.POISON, Type.GROUND);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 81);
        stats.put(Stat.ATTACK, 92);
        stats.put(Stat.DEFENSE, 77);
        stats.put(Stat.SPECIAL_ATTACK, 85);
        stats.put(Stat.SPECIAL_DEFENSE, 75);
        stats.put(Stat.SPEED, 85);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getAlakazam(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "ALAKAZAM";
        List<Type> types = Lists.newArrayList(Type.PSYCHIC);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 55);
        stats.put(Stat.ATTACK, 50);
        stats.put(Stat.DEFENSE, 45);
        stats.put(Stat.SPECIAL_ATTACK, 135);
        stats.put(Stat.SPECIAL_DEFENSE, 95);
        stats.put(Stat.SPEED, 120);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getGengar(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "GENGAR";
        List<Type> types = Lists.newArrayList(Type.GHOST, Type.POISON);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 60);
        stats.put(Stat.ATTACK, 65);
        stats.put(Stat.DEFENSE, 60);
        stats.put(Stat.SPECIAL_ATTACK, 130);
        stats.put(Stat.SPECIAL_DEFENSE, 75);
        stats.put(Stat.SPEED, 110);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getMachamp(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "MACHAMP";
        List<Type> types = Lists.newArrayList(Type.FIGHTING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 130);
        stats.put(Stat.DEFENSE, 80);
        stats.put(Stat.SPECIAL_ATTACK, 65);
        stats.put(Stat.SPECIAL_DEFENSE, 85);
        stats.put(Stat.SPEED, 55);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getWigglytuff(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "WIGGLYTUFF";
        List<Type> types = Lists.newArrayList(Type.NORMAL, Type.FAIRY);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 140);
        stats.put(Stat.ATTACK, 70);
        stats.put(Stat.DEFENSE, 45);
        stats.put(Stat.SPECIAL_ATTACK, 85);
        stats.put(Stat.SPECIAL_DEFENSE, 50);
        stats.put(Stat.SPEED, 45);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getDewgong(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "DEWGONG";
        List<Type> types = Lists.newArrayList(Type.WATER, Type.ICE);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 70);
        stats.put(Stat.DEFENSE, 80);
        stats.put(Stat.SPECIAL_ATTACK, 70);
        stats.put(Stat.SPECIAL_DEFENSE, 95);
        stats.put(Stat.SPEED, 70);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getMuk(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "MUK";
        List<Type> types = Lists.newArrayList(Type.POISON);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 105);
        stats.put(Stat.ATTACK, 105);
        stats.put(Stat.DEFENSE, 75);
        stats.put(Stat.SPECIAL_ATTACK, 65);
        stats.put(Stat.SPECIAL_DEFENSE, 100);
        stats.put(Stat.SPEED, 50);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getAlolanMuk(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "ALOLAN MUK";
        List<Type> types = Lists.newArrayList(Type.POISON, Type.DARK);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 105);
        stats.put(Stat.ATTACK, 105);
        stats.put(Stat.DEFENSE, 75);
        stats.put(Stat.SPECIAL_ATTACK, 65);
        stats.put(Stat.SPECIAL_DEFENSE, 100);
        stats.put(Stat.SPEED, 50);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getExeggutor(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "EXEGGUTOR";
        List<Type> types = Lists.newArrayList(Type.GRASS, Type.PSYCHIC);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 95);
        stats.put(Stat.ATTACK, 95);
        stats.put(Stat.DEFENSE, 85);
        stats.put(Stat.SPECIAL_ATTACK, 125);
        stats.put(Stat.SPECIAL_DEFENSE, 75);
        stats.put(Stat.SPEED, 55);
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

    public static Pokemon getMoltres(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "MOLTRES";
        List<Type> types = Lists.newArrayList(Type.FIRE, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 100);
        stats.put(Stat.DEFENSE, 90);
        stats.put(Stat.SPECIAL_ATTACK, 125);
        stats.put(Stat.SPECIAL_DEFENSE, 85);
        stats.put(Stat.SPEED, 90);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getGalarianMoltres(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "GALARIAN MOLTRES";
        List<Type> types = Lists.newArrayList(Type.DARK, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 85);
        stats.put(Stat.DEFENSE, 90);
        stats.put(Stat.SPECIAL_ATTACK, 100);
        stats.put(Stat.SPECIAL_DEFENSE, 125);
        stats.put(Stat.SPEED, 90);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getZapdos(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "ZAPDOS";
        List<Type> types = Lists.newArrayList(Type.ELECTRIC, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 90);
        stats.put(Stat.DEFENSE, 85);
        stats.put(Stat.SPECIAL_ATTACK, 125);
        stats.put(Stat.SPECIAL_DEFENSE, 90);
        stats.put(Stat.SPEED, 100);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getGalarianZapdos(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "GALARIAN ZAPDOS";
        List<Type> types = Lists.newArrayList(Type.FIGHTING, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 125);
        stats.put(Stat.DEFENSE, 90);
        stats.put(Stat.SPECIAL_ATTACK, 85);
        stats.put(Stat.SPECIAL_DEFENSE, 90);
        stats.put(Stat.SPEED, 100);
        return new Pokemon(name,types, moves, level, stats);
    }


    public static Pokemon getArticuno(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "ARTICUNO";
        List<Type> types = Lists.newArrayList(Type.ICE, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 85);
        stats.put(Stat.DEFENSE, 100);
        stats.put(Stat.SPECIAL_ATTACK, 95);
        stats.put(Stat.SPECIAL_DEFENSE, 125);
        stats.put(Stat.SPEED, 85);
        return new Pokemon(name,types, moves, level, stats);
    }

    public static Pokemon getGalarianArticuno(){
        Map<Stat, Integer> stats = Maps.newEnumMap(Stat.class);
        String name = "GALARIAN ARTICUNO";
        List<Type> types = Lists.newArrayList(Type.PSYCHIC, Type.FLYING);
        List<Move> moves = new ArrayList<Move>();
        int level = 100;
        stats.put(Stat.LIFE, 90);
        stats.put(Stat.ATTACK, 85);
        stats.put(Stat.DEFENSE, 85);
        stats.put(Stat.SPECIAL_ATTACK, 125);
        stats.put(Stat.SPECIAL_DEFENSE, 100);
        stats.put(Stat.SPEED, 95);
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
