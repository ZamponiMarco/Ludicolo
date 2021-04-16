package it.unicam.lcp.ludicolo.actions.items;

public class HealItemEffect extends ItemEffect{

    private final int value;
    private final boolean percentage;

    public HealItemEffect(int value, boolean percentage) {
        this.value = value;
        this.percentage = percentage;
    }

    public int getValue() {
        return value;
    }

    public boolean isPercentage() {
        return percentage;
    }

}
