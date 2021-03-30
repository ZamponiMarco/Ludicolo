package it.unicam.lcp.lotad;

public abstract class Action {

    public void setReadyToFire(boolean readyToFire) {
        this.readyToFire = readyToFire;
    }

    public boolean isReadyToFire() {
        return readyToFire;
    }

    protected boolean readyToFire;

    public Player getSource() {
        return source;
    }

    private Player source;

    public Action(Player source) {
        this.source = source;
        this.readyToFire = false;
    }
}
