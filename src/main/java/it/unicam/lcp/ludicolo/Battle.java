package it.unicam.lcp.ludicolo;

import java.util.Random;

public class Battle {

    private Player playerOne;
    private Player playerTwo;

    private boolean hasStarted;

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

    static int calculateDamage(int level, int power, int attack, int defense){
        return Math.round(((((((2*level)/5.0f)+2)*power)*(attack/defense))/50)+2);
    }

    static boolean probabilityCheck(int probability){
        int randomValue = new Random().nextInt(100);
        System.out.println(randomValue + "/" + probability);
        return randomValue < probability;
    }

}


