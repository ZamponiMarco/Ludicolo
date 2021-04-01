package it.unicam.lcp.lotad;


public enum Move {

    POUND(MoveType.PHYSICAL, Type.NORMAL, 35, 40, 100),
    RAZOR_WIND(MoveType.SPECIAL, Type.NORMAL, 10, 800, 100),
    SWORDS_DANCE(MoveType.STATUS, Type.NORMAL, 20, -1, -1);

    private Move(MoveType moveType, Type type, int pp, int power, int accuracy) {
        this.moveType = moveType;
        this.type = type;
        this.maxPp = pp;
        this.power = power;
        this.accuracy = accuracy;
    }

    private final MoveType moveType;
    private final Type type;
    private final int maxPp;
    private final int power;
    private final int accuracy;

    public MoveType getMoveType() {
        return moveType;
    }

    public Type getType() {
        return type;
    }

    public int getMaxPp() {
        return maxPp;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }
}
