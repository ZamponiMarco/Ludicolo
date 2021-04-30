package it.unicam.lcp.ludicolo.pkmn;


import com.google.common.collect.Maps;
import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.Type;
import it.unicam.lcp.ludicolo.Utility;
import it.unicam.lcp.ludicolo.actions.moves.Move;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pokemon {

    private final List<Type> type;
    private final String name;
    private final Map<Move, Integer> learnedMoves;
    private final int level;
    private final StatValues life;
    private final Map<Stat, StatValues> stats;
    private Player owner;
    private boolean battleStatsComputed;
    private boolean statusReductionDone;

    private boolean protectedFromAttacks;

    private PokemonStatus status;
    private int statusDuration;

    public Pokemon(String name, List<Type> type, List<Move> learnedMoves, int level, Map<Stat, Integer> baseStats) {
        this.type = type;
        this.name = name;
        this.learnedMoves = learnedMoves.stream().collect(Collectors.toMap(move -> move, Move::getMaxPp));
        this.level = level;
        this.battleStatsComputed = false;
        this.life = new StatValues(baseStats.get(Stat.LIFE));
        this.stats = Maps.newEnumMap(Stat.class);
        for (Map.Entry<Stat, Integer> entry : baseStats.entrySet()) {
            if (entry.getKey() != Stat.LIFE) {
                this.stats.put(entry.getKey(), new StatValues(entry.getValue()));
            }
        }
        Map<Stat, Integer> lifeStats = new HashMap<>();
        lifeStats.put(Stat.LIFE, Utility.calculateBattleLife(this.getBaseStatValue(Stat.LIFE), this.getLevel()));
        this.setBattleStat(lifeStats);
        this.setStage(lifeStats);
        this.statusReductionDone = false;
    }

    public PokemonStatus getStatus() {
        return status;
    }

    public void setStatus(PokemonStatus status) {
        this.status = status;
    }

    public int getStatusDuration() {
        return statusDuration;
    }

    public void setStatusDuration(int statusDuration) {
        this.statusDuration = statusDuration;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public Map<Move, Integer> getLearnedMoves() {
        return learnedMoves;
    }

    public void reducePP(Move move) {
        this.learnedMoves.put(move, Math.max(this.learnedMoves.get(move) - 1, 0));
    }

    public int getPP(Move move){
        return this.learnedMoves.get(move);
    }

    public void setPP(Move move, int value){
        this.learnedMoves.put(move, value);
    }

    public int getLevel() {
        return level;
    }


    public List<Type> getType() {
        return type;
    }

    public int getBaseStatValue(Stat stat) {
        return stat == Stat.LIFE ? this.life.getBaseValue() : this.stats.get(stat).getBaseValue();
    }

    public int getBattleStatValueWithStage(Stat stat) {
        int stage = getStageValue(stat);
        float multiplier = stage > 0 ? (2.0f + stage) / 2.0f : 2.0f / (2.0f + Math.abs(stage));
        return Math.round(getBattleStatValue(stat) * multiplier);
    }

    public int getBattleStatValue(Stat stat) {
        return stat == Stat.LIFE ? this.life.getBattleValue() : this.stats.get(stat).getBattleValue();
    }

    public int getStageValue(Stat stat) {
        return stat == Stat.LIFE ? this.life.getStage() : this.stats.get(stat).getStage();
    }

    public boolean isBattleStatsComputed() {
        return battleStatsComputed;
    }

    public void setBattleStatsComputed(boolean battleStatsComputed) {
        this.battleStatsComputed = battleStatsComputed;
    }

    public boolean isProtectedFromAttacks() {
        return protectedFromAttacks;
    }

    public void setProtectedFromAttacks(boolean protectedFromAttacks) {
        this.protectedFromAttacks = protectedFromAttacks;
    }

    public void setBattleStat(Map<Stat, Integer> battleStats) {
        for (Map.Entry<Stat, Integer> entry : battleStats.entrySet()) {
            if (entry.getKey() == Stat.LIFE) {
                this.life.setBattleValue(entry.getValue());
            } else {
                this.stats.get(entry.getKey()).setBattleValue(entry.getValue());
            }
        }
    }

    public void setStage(Map<Stat, Integer> stageMultipliers) {
        for (Map.Entry<Stat, Integer> entry : stageMultipliers.entrySet()) {
            if (entry.getKey() == Stat.LIFE) {
                this.life.setStage(entry.getValue());
            } else {
                this.stats.get(entry.getKey()).setStage(entry.getValue());
            }
        }
    }

    public boolean isStatusReductionDone() {
        return statusReductionDone;
    }

    public void setStatusReductionDone(boolean statusReductionDone) {
        this.statusReductionDone = statusReductionDone;
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
                        "\tSPEED:   %d → %d [%d]\n" +
                        "\tSTATUS:  %s [%d]\n" +
                        "\tOWNER: %s\n" +
                        "\tMOVES: %s - [%s]\n" +
                        "\tPROTECTED: %b" +
                        "\tSTATUS REDUCTION DONE: %b", name, this.level, life.getStage(), life.getBattleValue(), life.getBaseValue(), life.getBattleValue(),
                stats.get(Stat.ATTACK).getBaseValue(), stats.get(Stat.ATTACK).getBattleValue(), stats.get(Stat.ATTACK).getStage(), stats.get(Stat.DEFENSE).getBaseValue(),
                stats.get(Stat.DEFENSE).getBattleValue(), stats.get(Stat.DEFENSE).getStage(), stats.get(Stat.SPECIAL_ATTACK).getBaseValue(), stats.get(Stat.SPECIAL_ATTACK).getBattleValue(), stats.get(Stat.SPECIAL_ATTACK).getStage(),
                stats.get(Stat.SPECIAL_DEFENSE).getBaseValue(), stats.get(Stat.SPECIAL_DEFENSE).getBattleValue(), stats.get(Stat.SPECIAL_DEFENSE).getStage(), stats.get(Stat.SPEED).getBaseValue(),
                stats.get(Stat.SPEED).getBattleValue(), stats.get(Stat.SPEED).getStage(), this.status, this.statusDuration, this.owner.getName(), this.learnedMoves.keySet(), this.learnedMoves.values(), this.protectedFromAttacks, this.statusReductionDone);
    }
}
