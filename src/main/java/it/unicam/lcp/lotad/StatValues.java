package it.unicam.lcp.lotad;

public class StatValues {


    private final int baseValue;
    private int battleValue;
    private int stage;

    public StatValues(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public int getBattleValue() {
        return battleValue;
    }

    public void setBattleValue(int battleValue) {
        this.battleValue = battleValue;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

}
