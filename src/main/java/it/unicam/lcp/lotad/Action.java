package it.unicam.lcp.lotad;

public abstract class Action implements Comparable<Action> {

    protected boolean readyToFire;

    protected boolean fired;

    protected final Player source;

    public Action(Player source) {
        this.source = source;
        this.readyToFire = false;
        this.fired = false;
    }

    public boolean isReadyToFire() {
        return readyToFire;
    }

    public void setReadyToFire(boolean readyToFire) {
        this.readyToFire = readyToFire;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public Player getSource() {
        return source;
    }

    @Override
    public int compareTo(Action action) {
        return 0;
    }


}
