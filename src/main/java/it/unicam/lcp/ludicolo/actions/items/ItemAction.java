package it.unicam.lcp.ludicolo.actions.items;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;

public class ItemAction extends Action {

    private final Item item;

    public ItemAction(Player source, Item item) {
        super(source);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "ItemAction{" +
                "item=" + item.name() +
                ", source=" + source.getName() +
                ", status=" + status +
                '}';
    }

    @Override
    protected int getActionPriority() {
        return 9;
    }
}
