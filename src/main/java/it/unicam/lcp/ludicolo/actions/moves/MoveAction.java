package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;

public class MoveAction extends Action {

    private final Move move;
    private final Player target;

    private double modifier;

    private boolean stageEffectDone;
    private boolean statusEffectDone;

    public MoveAction(Player player, Move move, Player target) {
        super(player);
        this.move = move;
        this.target = target;
        this.stageEffectDone = false;
        this.statusEffectDone = false;
        this.modifier = 1;
    }

    @Override
    protected int getActionPriority() {
        return move.getPriority();
    }

    public Move getMove() {
        return move;
    }

    public Player getTarget() {
        return target;
    }

    public double getModifier() {
        return modifier;
    }

    public void setModifier(double modifier) {
        this.modifier = modifier;
    }

    public boolean isStageEffectDone() {
        return stageEffectDone;
    }

    public void setStageEffectDone(boolean stageEffectDone) {
        this.stageEffectDone = stageEffectDone;
    }

    public boolean isStatusEffectDone() {
        return statusEffectDone;
    }

    public void setStatusEffectDone(boolean statusEffectDone) {
        this.statusEffectDone = statusEffectDone;
    }

    @Override
    public String toString() {
        return "MoveAction{" +
                "move=" + move +
                ", target=" + target.getName() +
                ", status=" + status +
                ", source=" + source.getName() +
                '}';
    }

}
