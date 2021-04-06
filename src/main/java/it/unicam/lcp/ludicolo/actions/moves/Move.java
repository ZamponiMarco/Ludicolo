package it.unicam.lcp.ludicolo.actions.moves;


import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import it.unicam.lcp.ludicolo.Type;

import java.util.List;

public enum Move {

    POUND(MoveType.PHYSICAL, Type.NORMAL, 35, 40, 100, 0),
    RAZOR_WIND(MoveType.SPECIAL, Type.NORMAL, 10, 80, 5, 0),
    SWORDS_DANCE(MoveType.STATUS, Type.NORMAL, 20, 0, 100, 0, new StageSideEffect(SideEffectType.STAGE_INCREASE, 100, SideEffectTarget.SOURCE,2, Stat.ATTACK)),

    SUCKER_PUNCH(MoveType.PHYSICAL, Type.DARK, 5, 70, 100, 1),
    SNARL(MoveType.SPECIAL, Type.DARK, 20, 55, 95, 0, new StageSideEffect(SideEffectType.STAGE_DECREASE, 100, SideEffectTarget.TARGET, 1, Stat.SPECIAL_ATTACK)),
    DARK_VOID(MoveType.STATUS, Type.DARK, 10, 0, 50, 0, new SideEffect(SideEffectType.SLEEP, 100, SideEffectTarget.TARGET));

    private final MoveType moveType;
    private final Type type;
    private final int maxPp;
    private final int power;
    private final int accuracy;
    private final int priority;
    private final List<SideEffect> sideEffectList;

    Move(MoveType moveType, Type type, int pp, int power, int accuracy, int priority, SideEffect... sideEffects) {
        this.moveType = moveType;
        this.type = type;
        this.maxPp = pp;
        this.power = power;
        this.accuracy = accuracy;
        this.priority = priority;
        this.sideEffectList = Lists.newArrayList(sideEffects);
    }

    public List<SideEffect> getSideEffectList() {
        return sideEffectList;
    }

    public boolean containsSideEffect(SideEffectType type){
        for(SideEffect effect: this.sideEffectList){
            if(effect.getType() == type){
                return true;
            }
        }
        return false;
    }

    public SideEffect getSideEffectByType(SideEffectType type){
        for(SideEffect effect: this.sideEffectList){
            if(effect.getType() == type){
                return effect;
            }
        }
        return null;
    }

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

    @Override
    public String toString() {
        return "Move{" +
                "moveType=" + moveType +
                ", type=" + type +
                ", maxPp=" + maxPp +
                ", power=" + power +
                ", accuracy=" + accuracy +
                ", priority=" + priority +
                ", sideEffectList=" + sideEffectList +
                '}';
    }
}
