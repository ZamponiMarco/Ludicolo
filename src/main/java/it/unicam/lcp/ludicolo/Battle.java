package it.unicam.lcp.ludicolo;

public class Battle {

    private final Player playerOne;
    private final Player playerTwo;


    private boolean newTurnStart;

    public Player getPlayerOne() {
        return playerOne;
    }

    public Battle(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.newTurnStart = true;
    }


    public Player getPlayerTwo() {
        return playerTwo;
    }

    public boolean isNewTurnStart() {
        return newTurnStart;
    }

    public void setNewTurnStart(boolean newTurnStart) {
        this.newTurnStart = newTurnStart;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                '}';
    }

}


