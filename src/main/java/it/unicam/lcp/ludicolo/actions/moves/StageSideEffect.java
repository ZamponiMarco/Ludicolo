package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.pkmn.Stat;

public class StageSideEffect extends SideEffect {

    private final int numberOfStages;
    private final Stat targetStat;

    @Override
    public String toString() {
        return "StageSideEffect{" +
                "numberOfStages=" + numberOfStages +
                ", targetStat=" + targetStat +
                ", target=" + target +
                ", chance=" + chance +
                '}';
    }

    public StageSideEffect(int chance, SideEffectTarget target, int numberOfStages, Stat targetStat) {
        super(chance, target);
        this.numberOfStages = numberOfStages;
        this.targetStat = targetStat;
    }

    public Stat getTargetStat() {
        return targetStat;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }
}
