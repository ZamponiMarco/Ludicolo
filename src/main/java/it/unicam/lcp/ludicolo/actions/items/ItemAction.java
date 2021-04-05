package it.unicam.lcp.ludicolo.actions.items;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;

public class ItemAction extends Action {
    public ItemAction(Player source) {
        super(source);
    }

    @Override
    protected int getActionPriority() {
        return 10;
    }
}
