package it.unicam.lcp.lotad;

public abstract class Action implements Comparable<Action> {

    protected ActionStatus status;

    protected final Player source;

    public Action(Player source) {
        this.source = source;
        this.status = ActionStatus.DEFINED;
    }

    public ActionStatus getStatus() {
        return status;
    }

    public void setStatus(ActionStatus status) {
        this.status = status;
    }

    public Player getSource() {
        return source;
    }

    @Override
    public int compareTo(Action action) {
        return 0;
    }


}
