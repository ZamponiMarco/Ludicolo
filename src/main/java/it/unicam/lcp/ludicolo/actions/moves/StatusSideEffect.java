package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;

public class StatusSideEffect extends SideEffect{

    private PokemonStatus status;

    public StatusSideEffect(int chance, SideEffectTarget target, PokemonStatus status) {
        super(chance, target);
        this.status = status;
    }

    public PokemonStatus getStatus() {
        return status;
    }

    public void setStatus(PokemonStatus status) {
        this.status = status;
    }
}
