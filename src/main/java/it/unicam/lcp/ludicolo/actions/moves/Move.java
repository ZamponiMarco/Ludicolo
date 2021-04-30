package it.unicam.lcp.ludicolo.actions.moves;


import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import it.unicam.lcp.ludicolo.Type;

import java.util.List;
import java.util.stream.Collectors;

public enum Move {

    BUG_BUZZ(MoveType.SPECIAL, Type.BUG, 10, 90, 100, 0),
    STRUGGLE_BUG(MoveType.SPECIAL, Type.BUG, 20, 50, 100, 0, new StageMoveEffect(100, MoveEffectTarget.TARGET, -1, Stat.SPECIAL_ATTACK)),
    QUIVER_DANCE(MoveType.STATUS, Type.BUG, 20, 0, 100, 0, new StageMoveEffect(100, MoveEffectTarget.SOURCE, 1, Stat.SPECIAL_ATTACK), new StageMoveEffect(100, MoveEffectTarget.SOURCE, 1, Stat.SPECIAL_DEFENSE), new StageMoveEffect(100, MoveEffectTarget.SOURCE, 1, Stat.SPEED)),

    POUND(MoveType.PHYSICAL, Type.NORMAL, 35, 40, 100, 0),
    RAZOR_WIND(MoveType.SPECIAL, Type.NORMAL, 10, 80, 100, 0),
    PROTECT(MoveType.STATUS, Type.NORMAL, 10, 0, 100, 4, new StatusMoveEffect(100, MoveEffectTarget.SOURCE, PokemonStatus.PROTECTED)),

    SUCKER_PUNCH(MoveType.PHYSICAL, Type.DARK, 5, 70, 100, 1),
    SNARL(MoveType.SPECIAL, Type.DARK, 20, 55, 95, 0, new StageMoveEffect(100, MoveEffectTarget.TARGET, -1, Stat.SPECIAL_ATTACK)),
    DARK_VOID(MoveType.STATUS, Type.DARK, 10, 0, 50, 0, new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.ASLEEP)),

    CONFUSE_RAY(MoveType.STATUS, Type.GHOST, 10, 0, 100, 0, new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.CONFUSED));

    private final MoveType moveType;
    private final Type type;
    private final int maxPp;
    private final int power;
    private final int accuracy;
    private final int priority;
    private final List<MoveEffect> moveEffectList;

    Move(MoveType moveType, Type type, int pp, int power, int accuracy, int priority, MoveEffect... moveEffects) {
        this.moveType = moveType;
        this.type = type;
        this.maxPp = pp;
        this.power = power;
        this.accuracy = accuracy;
        this.priority = priority;
        this.moveEffectList = Lists.newArrayList(moveEffects);
    }

    public List<MoveEffect> getSideEffectList() {
        return moveEffectList;
    }

    public boolean containsStageMoveEffect(){
        return this.moveEffectList.stream().anyMatch(moveEffect -> moveEffect instanceof StageMoveEffect);
    }
    public boolean containsStatusMoveEffect(){
        return this.moveEffectList.stream().anyMatch(moveEffect -> moveEffect instanceof StatusMoveEffect);
    }

    public List<StageMoveEffect> getStageMoveEffects() {
        return this.moveEffectList.stream().filter(moveEffect -> moveEffect instanceof StageMoveEffect).
                map(moveEffect -> (StageMoveEffect) moveEffect).collect(Collectors.toList());
    }

    public List<StatusMoveEffect> getStatusMoveEffects() {
        return this.moveEffectList.stream().filter(moveEffect -> moveEffect instanceof StatusMoveEffect).
                map(moveEffect -> (StatusMoveEffect) moveEffect).collect(Collectors.toList());
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
        return String.format("%s [%s - %s - PP %d - PWR %d - ACR %d - PR %d]\n", this.name(), this.moveType.name(), this.type.name(), this.maxPp, this.power, this.accuracy, this.priority);
    }
}
