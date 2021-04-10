package it.unicam.lcp.ludicolo.actions.moves;

public abstract class SideEffect {
    protected final SideEffectTarget target;
    protected final int chance;

    public SideEffect(int chance, SideEffectTarget target) {
        this.chance = chance;
        this.target = target;
    }

    @Override
    public String toString() {
        return "SideEffect{" +
                "target=" + target +
                ", chance=" + chance +
                '}';
    }

    public SideEffectTarget getTarget() {
        return target;
    }

    public int getChance() {
        return chance;
    }

}
