package it.unicam.lcp.ludicolo.actions;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;

public class SwapAction extends Action {

    private final Pokemon newPokemon;

    public SwapAction(Player source, Pokemon newPokemon) {
        super(source);
        this.newPokemon = newPokemon;
    }

    @Override
    protected int getActionPriority() {
        return 10;
    }

    @Override
    public String getName() {
        return "Swap " + newPokemon.getDisplayName();
    }

    public Pokemon getNewPokemon() {
        return newPokemon;
    }

    @Override
    public String toString() {
        return "SwapAction{" +
                "source=" + this.getSource().getName() +
                "newPokemon=" + newPokemon +
                '}';
    }
}
