package it.unicam.lcp.ludicolo.actions.items;

import it.unicam.lcp.ludicolo.actions.moves.Move;

public class RestoreItemEffect extends ItemEffect{

    private final int value;
    private final boolean percentage;

    public RestoreItemEffect( int value, boolean percentage) {
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
