package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.actions.Action;

public class SwapAction extends Action {

    private int newPokemonIndex;

    public SwapAction(Player source) {
        super(source);
    }

    @Override
    protected int getActionPriority() {
        return 10;
    }

    public int getNewPokemonIndex() {
        return newPokemonIndex;
    }

    public void setNewPokemonIndex(int newPokemonIndex) {
        this.newPokemonIndex = newPokemonIndex;
    }
}
