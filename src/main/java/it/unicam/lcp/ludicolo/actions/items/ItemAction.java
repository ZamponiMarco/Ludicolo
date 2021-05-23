package it.unicam.lcp.ludicolo.actions.items;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;

public class ItemAction extends Action {

    private final Item item;

    private boolean healItemDone;
    private boolean statusItemDone;
    private boolean restoreItemDone;

    public ItemAction(Player source, Item item) {
        super(source);
        this.item = item;

        this.healItemDone = false;
        this.statusItemDone = false;
        this.restoreItemDone = false;
    }

    public Item getItem() {
        return item;
    }


    public boolean isHealItemDone() {
        return healItemDone;
    }

    public void setHealItemDone(boolean healItemDone) {
        this.healItemDone = healItemDone;
    }

    public boolean isStatusItemDone() {
        return statusItemDone;
    }

    public void setStatusItemDone(boolean statusItemDone) {
        this.statusItemDone = statusItemDone;
    }

    public boolean isRestoreItemDone() {
        return restoreItemDone;
    }

    public void setRestoreItemDone(boolean restoreItemDone) {
        this.restoreItemDone = restoreItemDone;
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

    @Override
    public String getName() {
        return "Item " + item.getDisplayName();
    }
}
