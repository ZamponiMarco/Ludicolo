package it.unicam.lcp.ludicolo.view;

import it.unicam.lcp.ludicolo.actions.items.Item;

public class ItemViewWrapper {
    private final Item item;
    private final Integer qty;

    public ItemViewWrapper(Item item, Integer qty) {
        this.item = item;
        this.qty = qty;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return this.item.getDisplayName() + " (" + this.qty + ")\n" + this.item.getDescription();
    }
}
