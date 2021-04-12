package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;

public class StatusSideEffect extends SideEffect {

    private final PokemonStatus status;
    private final int duration;
    private final boolean random;

    public StatusSideEffect(int chance, SideEffectTarget target, PokemonStatus status, int duration, boolean random) {
        super(chance, target);
        this.status = status;
        this.duration = duration;
        this.random = random;
    }

    public StatusSideEffect(int chance, SideEffectTarget target, PokemonStatus status) {
        super(chance, target);
        this.status = status;
        this.duration = status.getDuration();
        this.random = status.isRandom();
    }

    public PokemonStatus getStatus() {
        return status;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "StatusSideEffect{" +
                "status=" + status +
                ", duration=" + duration +
                ", random=" + random +
                ", target=" + target +
                ", chance=" + chance +
                '}';
    }

}
