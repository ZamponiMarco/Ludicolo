package it.unicam.lcp.ludicolo.actions.moves;

import it.unicam.lcp.ludicolo.Player;
import it.unicam.lcp.ludicolo.actions.Action;

public class MoveAction extends Action {

    private final Move move;
    private final Player target;

    public MoveAction(Player player, Move move, Player target) {
        super(player);
        this.move = move;
        this.target = target;
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
