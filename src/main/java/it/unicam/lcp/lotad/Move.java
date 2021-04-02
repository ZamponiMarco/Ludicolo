package it.unicam.lcp.lotad;


public enum Move {

    POUND(MoveType.PHYSICAL, Type.NORMAL, 35, 40, 100, 0),
    RAZOR_WIND(MoveType.SPECIAL, Type.NORMAL, 10, 800, 100, 0),
    SWORDS_DANCE(MoveType.STATUS, Type.NORMAL, 20, -1, -1, 0),
    SUCKER_PUNCH(MoveType.PHYSICAL, Type.DARK, 5, 70, 100, 1);

    private Move(MoveType moveType, Type type, int pp, int power, int accuracy, int priority) {
        this.moveType = moveType;
        this.type = type;
        this.maxPp = pp;
        this.power = power;
        this.accuracy = accuracy;
        this.priority = priority;
    }

    private final MoveType moveType;
    private final Type type;
    private final int maxPp;
    private final int power;
    private final int accuracy;
    private final int priority;

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

    public int getPriority() {
        return priority;
    }
}
