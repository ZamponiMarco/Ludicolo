package it.unicam.lcp.ludicolo.actions.moves;

public class SideEffect {
    protected final SideEffectType type;

    public SideEffectType getType() {
        return type;
    }

    public int getChance() {
        return chance;
    }

    protected final int chance;

    public SideEffect(SideEffectType type, int chance) {
        this.type = type;
        this.chance = chance;
    }

}
