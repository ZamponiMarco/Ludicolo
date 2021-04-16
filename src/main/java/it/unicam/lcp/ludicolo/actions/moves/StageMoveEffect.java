package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.pkmn.Stat;

public class StageMoveEffect extends MoveEffect {

    private final int numberOfStages;
    private final Stat targetStat;

    public StageMoveEffect(int chance, MoveEffectTarget target, int numberOfStages, Stat targetStat) {
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

    @Override
    public String toString() {
        return "StageMoveEffect{" +
                "numberOfStages=" + numberOfStages +
                ", targetStat=" + targetStat +
                ", target=" + target +
                ", chance=" + chance +
                '}';
    }
}
