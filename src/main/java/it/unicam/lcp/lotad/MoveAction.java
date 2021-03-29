package it.unicam.lcp.lotad;

public class MoveAction extends Action {
    private Move move;
    private Pokemon attacker;
    private Pokemon defender;

    public MoveAction(Move move, Pokemon attacker, Pokemon defender) {
        this.move = move;
        this.attacker = attacker;
        this.defender = defender;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Pokemon getAttacker() {
        return attacker;
    }

    public void setAttacker(Pokemon attacker) {
        this.attacker = attacker;
    }

    public Pokemon getDefender() {
        return defender;
    }

    public void setDefender(Pokemon defender) {
        this.defender = defender;
    }

    @Override
    public String toString() {
        return "MoveAction{" +
                "move=" + move +
                ", attacker=" + attacker +
                ", defender=" + defender +
                '}';
    }
}
