package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.actions.Action;

public class SwapAction extends Action {
    public SwapAction(Player source) {
        super(source);
    }

    @Override
    protected int getActionPriority() {
        return 9;
    }
}
