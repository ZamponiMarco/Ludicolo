package it.unicam.lcp.lotad;

public abstract class Action implements Comparable<Action> {

    protected final Player source;
    protected ActionStatus status;

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

    protected abstract ActionPriority getActionPriority();

    @Override
    public int compareTo(Action action) {
        return getActionPriority().compareTo(action.getActionPriority());
    }


}
