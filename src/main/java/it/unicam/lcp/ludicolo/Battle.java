package it.unicam.lcp.ludicolo;

public class Battle {

    private final Player playerOne;
    private final Player playerTwo;

    public Player getPlayerOne() {
        return playerOne;
    }

    public Battle(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public Player getPlayerTwo() {
        return playerTwo;
    }



    @Override
    public String toString() {
        return "Battle{" +
                "playerOne=" + playerOne +
                ", playerTwo=" + playerTwo+
                '}';
    }

}


