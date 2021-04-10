package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;

public class StatusSideEffect extends SideEffect{

    private PokemonStatus status;
    private int duration;
    private boolean random;

    public StatusSideEffect(int chance, SideEffectTarget target, PokemonStatus status, int duration, boolean random) {
        super(chance, target);
        this.status = status;
        this.duration = duration;
        this.random = random;
    }

    public StatusSideEffect(int chance, SideEffectTarget target, PokemonStatus status) {
        super(chance, target);
        this.status = status;
        switch(this.status){
            case PARALYZED:
            case BURNED:
            case FROZEN:
            case POISONED:
                this.duration = Integer.MAX_VALUE;
                this.random = false;
                break;
            case ASLEEP:
                this.duration = 3;
                this.random = true;
                break;
            case CONFUSED:
                this.duration = 4;
                this.random = true;
                break;
            case PROTECTED:
                this.duration = 1;
                this.random = false;
                break;
        }
        this.duration = duration;
        this.random = false;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isRandom() {
        return random;
    }

    public PokemonStatus getStatus() {
        return status;
    }

    public void setStatus(PokemonStatus status) {
        this.status = status;
    }
}
