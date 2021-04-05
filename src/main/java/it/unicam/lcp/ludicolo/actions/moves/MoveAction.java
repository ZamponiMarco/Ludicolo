package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;

public class MoveAction extends Action {

    private Move move;
    private Player target;

    public MoveAction(Player player, Move move, Player target) {
        super(player);
        this.move = move;
        this.target = target;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "MoveAction{" +
                "move=" + move +
                ", target=" + target +
                ", status=" + status +
                ", source=" + source +
                '}';
    }

    @Override
    protected int getActionPriority() {
        return move.getPriority();
    }
}
