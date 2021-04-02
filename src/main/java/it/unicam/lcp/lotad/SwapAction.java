package it.unicam.lcp.lotad;

public class SwapAction extends Action{
    public SwapAction(Player source) {
        super(source);
    }

    @Override
    protected ActionPriority getActionPriority() {
        return ActionPriority.HIGH;
    }
}
