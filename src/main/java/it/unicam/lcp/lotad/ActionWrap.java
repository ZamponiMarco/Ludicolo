package it.unicam.lcp.lotad;

public class ActionWrap {
    private final Action firstAction;
    private final Action secondAction;

    public ActionWrap(Action firstAction, Action secondAction) {
        this.firstAction = firstAction;
        this.secondAction = secondAction;
    }

    public Action getFirstAction() {
        return firstAction;
    }

    public Action getSecondAction() {
        return secondAction;
    }

}
