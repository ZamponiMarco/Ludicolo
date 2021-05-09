package it.unicam.lcp.ludicolo.actions.moves;

public class MoveActionModifiers {
    final double critical;
    final double random;
    final double stab;
    final double type;
    final double burn;
    final double finalValue;

    public MoveActionModifiers(double critical, double random, double stab, double type, double burn) {
        this.critical = critical;
        this.random = random;
        this.stab = stab;
        this.type = type;
        this.burn = burn;
        this.finalValue = critical * random * stab * type * burn;
    }

    public double getCritical() {
        return critical;
    }

    public double getRandom() {
        return random;
    }

    public double getStab() {
        return stab;
    }

    public double getType() {
        return type;
    }

    public double getBurn() {
        return burn;
    }

    public double getFinalValue() {
        return finalValue;
    }
}
