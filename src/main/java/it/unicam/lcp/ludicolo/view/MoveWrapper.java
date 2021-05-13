package it.unicam.lcp.ludicolo.view;

import it.unicam.lcp.ludicolo.actions.moves.Move;

public class MoveWrapper {
    private final Move move;
    private final Integer pp;

    public MoveWrapper(Move move, Integer pp) {
        this.move = move;
        this.pp = pp;
    }

    public Move getMove() {
        return move;
    }

    public Integer getPp() {
        return pp;
    }

    @Override
    public String toString() {
        return this.move.getDisplayName() + " (" + this.pp + "/" + this.move.getMaxPp() + ")\n" +
                "[ " + this.move.getType() + ", " + this.move.getMoveType() + " ]\n" + this.move.getDescription();
    }
}
