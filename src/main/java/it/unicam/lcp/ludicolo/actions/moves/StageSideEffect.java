package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.pkmn.Stat;

public class StageSideEffect extends SideEffect {

    private final int numberOfStages;
    private final Stat targetStat;

    public Stat getTargetStat() {
        return targetStat;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public StageSideEffect(SideEffectType type, int chance, int numberOfStages, Stat targetStat) {
        super(type, chance);
        this.numberOfStages = numberOfStages;
        this.targetStat = targetStat;
    }
}
