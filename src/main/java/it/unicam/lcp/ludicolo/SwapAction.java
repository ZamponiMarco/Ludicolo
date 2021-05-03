package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.actions.Action;

public class SwapAction extends Action {

    private final int newPokemonIndex;

    public SwapAction(Player source, int newPokemonIndex) {
        super(source);
        this.newPokemonIndex = newPokemonIndex;
    }

    @Override
    protected int getActionPriority() {
        return 10;
    }

    public int getNewPokemonIndex() {
        return newPokemonIndex;
    }
}
