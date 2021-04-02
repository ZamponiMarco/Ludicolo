package it.unicam.lcp.ludicolo.pkmn;


import com.google.common.collect.Maps;
import it.unicam.lcp.ludicolo.actions.moves.Move;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pokemon {
    private final String name;
    private final Map<Move, Integer> learnedMoves;

    private final int level;

    private final Map<Stat, StatValues> life;

    private final Map<Stat, StatValues> stats;

    private boolean battleStatsComputed;

    public Pokemon(String name, List<Move> learnedMoves, int level, Map<Stat, Integer> baseStats) {
        this.name = name;
        this.learnedMoves = learnedMoves.stream().collect(Collectors.toMap(move -> move, Move::getMaxPp));
        this.level = level;
        this.battleStatsComputed = false;
        this.life = Maps.newEnumMap(Stat.class);
        this.stats = Maps.newEnumMap(Stat.class);
        for (Map.Entry<Stat, Integer> entry : baseStats.entrySet()) {
            if (entry.getKey() == Stat.LIFE) {
                this.life.put(entry.getKey(), new StatValues(entry.getValue()));
            } else {
                this.stats.put(entry.getKey(), new StatValues(entry.getValue()));
            }
        }
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

    public int getBaseStatValue(Stat stat) {
        return stat == Stat.LIFE ? this.life.get(stat).getBaseValue() : this.stats.get(stat).getBaseValue();
    }

    public int getBattleStatValue(Stat stat) {
        return stat == Stat.LIFE ? this.life.get(stat).getBattleValue() : this.stats.get(stat).getBattleValue();
    }

    public int getStageValue(Stat stat) {
        return stat == Stat.LIFE ? this.life.get(stat).getStage() : this.stats.get(stat).getStage();
    }

    public boolean isBattleStatsComputed() {
        return battleStatsComputed;
    }

    public void setBattleStatsComputed(boolean battleStatsComputed) {
        this.battleStatsComputed = battleStatsComputed;
    }

    public void setBattleStat(Map<Stat, Integer> battleStats) {
        for (Map.Entry<Stat, Integer> entry : battleStats.entrySet()) {
            if (entry.getKey() == Stat.LIFE) {
                this.life.get(entry.getKey()).setBattleValue(entry.getValue());
            } else {
                this.stats.get(entry.getKey()).setBattleValue(entry.getValue());
            }
        }
    }

    public void setStage(Map<Stat, Integer> stageMultipliers) {
        for (Map.Entry<Stat, Integer> entry : stageMultipliers.entrySet()) {
            if (entry.getKey() == Stat.LIFE) {
                this.life.get(entry.getKey()).setStage(entry.getValue());
            } else {
                this.stats.get(entry.getKey()).setStage(entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return String.format(
                        "\n%s\n" +
                        "[Lv.: %d ♥ %d/%d] \n" +
                        "\tLIFE:  %d → %d\n" +
                        "\tATTACK:  %d → %d [%d]\n" +
                        "\tDEFENSE: %d → %d [%d]\n" +
                        "\tSP. ATK: %d → %d [%d]\n" +
                        "\tSP. DEF: %d → %d [%d]\n" +
                        "\tSPEED:   %d → %d [%d]\n", name,this.level, life.get(Stat.LIFE).getStage(), life.get(Stat.LIFE).getBattleValue(),  life.get(Stat.LIFE).getBaseValue(), life.get(Stat.LIFE).getBattleValue(),
                stats.get(Stat.ATTACK).getBaseValue(), stats.get(Stat.ATTACK).getBattleValue(), stats.get(Stat.ATTACK).getStage(), stats.get(Stat.DEFENSE).getBaseValue(),
                stats.get(Stat.DEFENSE).getBattleValue(), stats.get(Stat.DEFENSE).getStage(), stats.get(Stat.SPECIAL_ATTACK).getBaseValue(), stats.get(Stat.SPECIAL_ATTACK).getBattleValue(), stats.get(Stat.SPECIAL_ATTACK).getStage(),
                stats.get(Stat.SPECIAL_DEFENSE).getBaseValue(), stats.get(Stat.SPECIAL_DEFENSE).getBattleValue(), stats.get(Stat.SPECIAL_DEFENSE).getStage(),stats.get(Stat.SPEED).getBaseValue(),
                stats.get(Stat.SPEED).getBattleValue(), stats.get(Stat.SPEED).getStage());
    }
}
