package it.unicam.lcp.lotad;

public abstract class Action {

    public void setReadyToFire(boolean readyToFire) {
        this.readyToFire = readyToFire;
    }

    public boolean isReadyToFire() {
        return readyToFire;
    }

    protected boolean readyToFire;

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    protected boolean fired;

    public Player getSource() {
        return source;
    }

    protected Player source;

    public Action(Player source) {
        this.source = source;
        this.readyToFire = false;
        this.fired = false;
    }
}
