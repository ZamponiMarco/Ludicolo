package it.unicam.lcp.ludicolo.actions.moves;

public class SideEffect {
    protected final SideEffectType type;
    protected final SideEffectTarget target;
    protected final int chance;

    public SideEffect(SideEffectType type, int chance, SideEffectTarget target) {
        this.type = type;
        this.chance = chance;
        this.target = target;
    }

    public SideEffectType getType() {
        return type;
    }

    public SideEffectTarget getTarget() {
        return target;
    }

    public int getChance() {
        return chance;
    }

}
