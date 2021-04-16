package it.unicam.lcp.ludicolo.actions.items;

import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;

public class StatusItemEffect extends ItemEffect{

    private final PokemonStatus status;


    public StatusItemEffect(PokemonStatus status) {
        this.status = status;
    }

    public PokemonStatus getStatus() {
        return status;
    }
}
