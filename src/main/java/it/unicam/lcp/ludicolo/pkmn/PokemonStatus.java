package it.unicam.lcp.ludicolo.pkmn;

public enum PokemonStatus {
    ASLEEP(3, true),
    BURNED(Integer.MAX_VALUE, false),
    CONFUSED(4, true),
    FROZEN(Integer.MAX_VALUE, false),
    PARALYZED(Integer.MAX_VALUE, false),
    POISONED(Integer.MAX_VALUE, false),
    PROTECTED(1, false);

    private final int duration;
    private final boolean random;

    PokemonStatus(int duration, boolean random) {
        this.duration = duration;
        this.random = random;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isRandom() {
        return random;
    }
}
