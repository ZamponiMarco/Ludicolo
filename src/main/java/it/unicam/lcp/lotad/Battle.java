package it.unicam.lcp.lotad;

public class Battle {

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }


    private Player playerOne;
    private Player playerTwo;

    private boolean hasStarted;

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                ", hasStarted=" + hasStarted +
                '}';
    }
}


