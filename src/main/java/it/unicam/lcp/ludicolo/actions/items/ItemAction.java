package it.unicam.lcp.ludicolo.actions.items;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;
import it.unicam.lcp.ludicolo.actions.ActionPriority;

public class ItemAction extends Action {
    public ItemAction(Player source) {
        super(source);
    }

    @Override
    protected ActionPriority getActionPriority() {
        return ActionPriority.HIGH;
    }
}
