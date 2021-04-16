package it.unicam.lcp.ludicolo.actions.moves;

public abstract class MoveEffect {
    protected final MoveEffectTarget target;
    protected final int chance;

    public MoveEffect(int chance, MoveEffectTarget target) {
        this.chance = chance;
        this.target = target;
    }

    @Override
    public String toString() {
        return "MoveEffect{" +
                "target=" + target +
                ", chance=" + chance +
                '}';
    }

    public MoveEffectTarget getTarget() {
        return target;
    }

    public int getChance() {
        return chance;
    }

}
