package it.unicam.lcp.lotad;

public class ItemAction extends Action{
    public ItemAction(Player source) {
        super(source);
    }

    @Override
    protected ActionPriority getActionPriority() {
        return ActionPriority.HIGH;
    }
}
