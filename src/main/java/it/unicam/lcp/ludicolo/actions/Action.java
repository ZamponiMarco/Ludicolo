package it.unicam.lcp.ludicolo.actions;

import it.unicam.lcp.ludicolo.Player;

import java.util.Comparator;

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

    protected abstract int getActionPriority();

    @Override
    public int compareTo(Action action) {
        return getActionPriority() - action.getActionPriority();
    }


}
