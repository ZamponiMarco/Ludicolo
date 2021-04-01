package it.unicam.lcp.lotad;


import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pokemon {
    private final String name;
    private final Map<Move, Integer> learnedMoves;

    private final int level;

    private final Map<Stat, Integer> baseStats;

    private boolean battleStatsComputed;
    private Map<Stat, Integer> battleStats;

    public Pokemon(String name, List<Move> learnedMoves, int level, Map<Stat, Integer> baseStats) {
        this.name = name;
        this.learnedMoves = learnedMoves.stream().collect(Collectors.toMap(move -> move, Move::getMaxPp));
        this.level = level;
        this.battleStatsComputed = false;
        this.baseStats = baseStats;
        this.battleStats = new EnumMap<>(Stat.class);
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

    public Map<Stat, Integer> getBaseStats() {
        return baseStats;
    }

    public boolean isBattleStatsComputed() {
        return battleStatsComputed;
    }

    public void setBattleStatsComputed(boolean battleStatsComputed) {
        this.battleStatsComputed = battleStatsComputed;
    }

    public Map<Stat, Integer> getBattleStats() {
        return battleStats;
    }

    public void setBattleStats(Map<Stat, Integer> battleStats) {
        this.battleStats = battleStats;
    }

    @Override
    public String toString() {
        return String.format("\n%s ♥ %s/%d\n" +
                        "\tATTACK:  %d → %d\n" +
                        "\tDEFENSE: %d → %d\n" +
                        "\tSP. ATK: %d → %d\n" +
                        "\tSP. DEF: %d → %d\n" +
                        "\tSPEED:   %d → %d\n", name, battleStats.get(Stat.LIFE), baseStats.get(Stat.LIFE),
                baseStats.get(Stat.ATTACK), battleStats.get(Stat.ATTACK), baseStats.get(Stat.DEFENSE),
                battleStats.get(Stat.DEFENSE), baseStats.get(Stat.SPECIAL_ATTACK), battleStats.get(Stat.SPECIAL_ATTACK),
                baseStats.get(Stat.SPECIAL_DEFENSE), battleStats.get(Stat.SPECIAL_DEFENSE), baseStats.get(Stat.SPEED),
                battleStats.get(Stat.SPEED));
    }
}
