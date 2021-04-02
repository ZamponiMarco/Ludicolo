package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.actions.Action;
import it.unicam.lcp.ludicolo.actions.ActionPriority;

public class SwapAction extends Action {
    public SwapAction(Player source) {
        super(source);
    }

    @Override
    protected ActionPriority getActionPriority() {
        return ActionPriority.HIGH;
    }
}
