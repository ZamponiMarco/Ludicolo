package it.unicam.lcp.lotad;

public class MoveAction extends Action {

    private Move move;
    private Pokemon target;

    public MoveAction(Player player, Move move, Pokemon target) {
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

    public Pokemon getTarget() {
        return target;
    }

    public void setTarget(Pokemon target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "MoveAction{" +
                "move=" + move +
                ", target=" + target +
                ", readyToFire=" + readyToFire +
                ", fired=" + fired +
                ", source=" + source +
                '}';
    }

}
