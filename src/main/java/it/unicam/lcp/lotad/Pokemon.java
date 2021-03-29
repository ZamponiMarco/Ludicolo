package it.unicam.lcp.lotad;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pokemon {
    private final String name;
    private final Map<Move, Integer> learnedMoves;

    private final int level;
    private final int baseLife;
    private final int baseAttack;
    private final int baseDefense;
    private final int baseSpecialAttack;
    private final int baseSpecialDefense;
    private final int baseSpeed;

    private boolean battleStats;
    private int battleLife;
    private int battleAttack;
    private int battleDefense;
    private int battleSpecialAttack;
    private int battleSpecialDefense;
    private int battleSpeed;

    public Pokemon(String name, List<Move> learnedMoves, int level, int baseLife, int baseAttack, int baseDefense, int baseSpecialAttack, int baseSpecialDefense, int baseSpeed) {
        this.name = name;
        this.learnedMoves = learnedMoves.stream().collect(Collectors.toMap(move -> move, Move::getMaxPp));
        this.level = level;
        this.baseLife = baseLife;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpecialAttack = baseSpecialAttack;
        this.baseSpecialDefense = baseSpecialDefense;
        this.baseSpeed = baseSpeed;
        this.battleStats = false;
    }

    public String getName() {
        return name;
    }

    public Map<Move, Integer> getLearnedMoves() {
        return learnedMoves;
    }


    public int getLevel() {
        return level;
    }

    public int getBaseLife() {
        return baseLife;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getBaseSpecialAttack() {
        return baseSpecialAttack;
    }

    public int getBaseSpecialDefense() {
        return baseSpecialDefense;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public boolean isBattleStats() {
        return battleStats;
    }

    public void setBattleStats(boolean battleStats) {
        this.battleStats = battleStats;
    }

    public int getBattleLife() {
        return battleLife;
    }

    public void setBattleLife(int battleLife) {
        this.battleLife = battleLife;
    }

    public int getBattleAttack() {
        return battleAttack;
    }

    public void setBattleAttack(int battleAttack) {
        this.battleAttack = battleAttack;
    }

    public int getBattleDefense() {
        return battleDefense;
    }

    public void setBattleDefense(int battleDefense) {
        this.battleDefense = battleDefense;
    }

    public int getBattleSpecialAttack() {
        return battleSpecialAttack;
    }

    public void setBattleSpecialAttack(int battleSpecialAttack) {
        this.battleSpecialAttack = battleSpecialAttack;
    }

    public int getBattleSpecialDefense() {
        return battleSpecialDefense;
    }

    public void setBattleSpecialDefense(int battleSpecialDefense) {
        this.battleSpecialDefense = battleSpecialDefense;
    }

    public int getBattleSpeed() {
        return battleSpeed;
    }

    public void setBattleSpeed(int battleSpeed) {
        this.battleSpeed = battleSpeed;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", learnedMoves=" + learnedMoves +
                ", level=" + level +
                ", baseLife=" + baseLife +
                ", baseAttack=" + baseAttack +
                ", baseDefense=" + baseDefense +
                ", baseSpecialAttack=" + baseSpecialAttack +
                ", baseSpecialDefense=" + baseSpecialDefense +
                ", baseSpeed=" + baseSpeed +
                ", battleStats=" + battleStats +
                ", battleLife=" + battleLife +
                ", battleAttack=" + battleAttack +
                ", battleDefense=" + battleDefense +
                ", battleSpecialAttack=" + battleSpecialAttack +
                ", battleSpecialDefense=" + battleSpecialDefense +
                ", battleSpeed=" + battleSpeed +
                '}';
    }
}
