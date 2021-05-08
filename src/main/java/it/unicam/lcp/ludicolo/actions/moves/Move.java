package it.unicam.lcp.ludicolo.actions.moves;


import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.actions.items.HealItemEffect;
import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;
import it.unicam.lcp.ludicolo.pkmn.Stat;
import it.unicam.lcp.ludicolo.Type;

import java.util.List;
import java.util.stream.Collectors;

public enum Move {

    BUG_BUZZ("The user generates a damaging sound wave by vibration. This may also lower the target's Sp. Def stat.",
            MoveType.SPECIAL, Type.BUG, 10, 90, 100, 0),

    STRUGGLE_BUG("While resisting, the user attacks opposing Pokémon. This lowers the Sp. Atk stats of those hit.",
            MoveType.SPECIAL, Type.BUG, 20, 50, 100, 0,
            new StageMoveEffect(100, MoveEffectTarget.TARGET, -1, Stat.SPECIAL_ATTACK)),

    QUIVER_DANCE("The user lightly performs a beautiful, mystic dance. This boosts the user's Sp. Atk, Sp. Def, and Speed stats.",
            MoveType.STATUS, Type.BUG, 20, 0, 100, 0,
            new StageMoveEffect(100, MoveEffectTarget.SOURCE, 1, Stat.SPECIAL_ATTACK),
            new StageMoveEffect(100, MoveEffectTarget.SOURCE, 1, Stat.SPECIAL_DEFENSE),
            new StageMoveEffect(100, MoveEffectTarget.SOURCE, 1, Stat.SPEED)),

    POUND("The target is physically pounded with a long tail, a foreleg, or the like.",
            MoveType.PHYSICAL, Type.NORMAL, 35, 40, 100, 0),

    PROTECT("This move enables the user to protect itself from all attacks.",
            MoveType.STATUS, Type.NORMAL, 10, 0, 100, 4,
            new StatusMoveEffect(100, MoveEffectTarget.SOURCE, PokemonStatus.PROTECTED)),

    SUCKER_PUNCH("This move enables the user to attack first. This move fails if the target is not readying an attack.",
            MoveType.PHYSICAL, Type.DARK, 5, 70, 100, 1),

    SNARL("\tThe user yells as if it's ranting about something, which lowers the Sp. Atk stats of opposing Pokémon.",
            MoveType.SPECIAL, Type.DARK, 20, 55, 95, 0,
            new StageMoveEffect(100, MoveEffectTarget.TARGET, -1, Stat.SPECIAL_ATTACK)),

    DARK_VOID("Opposing Pokémon are dragged into a world of total darkness that makes them sleep.",
            MoveType.STATUS, Type.DARK, 10, 0, 50, 0,
            new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.ASLEEP)),

    CONFUSE_RAY("The target is exposed to a sinister ray that triggers confusion.",
            MoveType.STATUS, Type.GHOST, 10, 0, 100, 0,
            new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.CONFUSED)),

    FIRE_PUNCH("The target is punched with a fiery fist. This may also leave the target with a burn.",
            MoveType.PHYSICAL, Type.FIRE, 15, 75, 100, 0,
            new StatusMoveEffect(10, MoveEffectTarget.TARGET, PokemonStatus.BURNED)),

    EMBER("The target is attacked with small flames. This may also leave the target with a burn.",
            MoveType.SPECIAL, Type.FIRE, 25, 40, 100, 0,
            new StatusMoveEffect(10, MoveEffectTarget.TARGET, PokemonStatus.BURNED)),

    ICE_BEAM("The target is struck with an icy-cold beam of energy. This may also leave the target frozen.",
            MoveType.SPECIAL, Type.ICE, 10, 90, 100, 0,
            new StatusMoveEffect(10, MoveEffectTarget.TARGET, PokemonStatus.FROZEN)),

    ICE_PUNCH("The target is punched with an icy fist. This may also leave the target frozen.",
            MoveType.PHYSICAL, Type.ICE, 15, 75, 100, 0,
            new StatusMoveEffect(10, MoveEffectTarget.TARGET, PokemonStatus.FROZEN)),

    QUICK_ATTACK("The user lunges at the target at a speed that makes it almost invisible. This move always goes first.",
            MoveType.PHYSICAL, Type.NORMAL, 30, 40, 100, 1),

    THUNDER_PUNCH("The target is punched with an electrified fist. This may also leave the target with paralysis.",
            MoveType.PHYSICAL, Type.ELECTRIC, 15, 75, 100, 0,
            new StatusMoveEffect(10, MoveEffectTarget.TARGET, PokemonStatus.PARALYZED)),

    THUNDER_WAVE("The user launches a weak jolt of electricity that paralyzes the target.",
            MoveType.STATUS, Type.ELECTRIC, 20, 0, 90, 0,
            new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.PARALYZED)),

    WATER_GUN("The target is blasted with a forceful shot of water.",
            MoveType.SPECIAL, Type.WATER, 25, 40, 100, 0),

    SURF("The user attacks everything around it by swamping its surroundings with a giant wave.",
            MoveType.SPECIAL, Type.WATER, 15, 90, 100, 0),

    SLEEP_POWDER("The user scatters a big cloud of sleep-inducing dust around the target.",
            MoveType.STATUS, Type.GRASS, 15, 0, 75, 0,
            new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.ASLEEP)),

    COTTON_SPORE("The user releases cotton-like spores that cling to opposing Pokémon, which harshly lowers their Speed stats.",
            MoveType.STATUS, Type.GRASS, 40, 0, 100, 0,
            new StageMoveEffect(85, MoveEffectTarget.TARGET, -2, Stat.SPEED)),

    MAGICAL_LEAF("The user scatters curious leaves that chase the target. This attack never misses.",
            MoveType.SPECIAL, Type.GRASS, 20, 60, 100, 0),

    PSYCHIC("The target is hit by a strong telekinetic force. This may also lower the target's Sp. Def stat.",
            MoveType.SPECIAL, Type.PSYCHIC, 10, 90, 100, 0,
            new StageMoveEffect(10, MoveEffectTarget.TARGET, -1, Stat.SPECIAL_DEFENSE)),

    HYPNOSIS("The user employs hypnotic suggestion to make the target fall into a deep sleep.",
            MoveType.STATUS, Type.PSYCHIC, 20, 0, 60, 0,
            new StatusMoveEffect(100, MoveEffectTarget.TARGET, PokemonStatus.ASLEEP)),

    AMNESIA("The user temporarily empties its mind to forget its concerns. This sharply raises the user's Sp. Def stat.",
            MoveType.STATUS, Type.PSYCHIC, 20, 0, 100, 0,
            new StageMoveEffect(100, MoveEffectTarget.SOURCE, +2, Stat.SPECIAL_DEFENSE)),

    TRI_ATTACK("The user strikes with a simultaneous three-beam attack. This may also burn, freeze, or paralyze the target.",
            MoveType.SPECIAL, Type.NORMAL, 10, 80, 100, 0,
            new StatusMoveEffect(20, MoveEffectTarget.TARGET, PokemonStatus.BURNED),
            new StatusMoveEffect(20, MoveEffectTarget.TARGET, PokemonStatus.PARALYZED),
            new StatusMoveEffect(20, MoveEffectTarget.TARGET, PokemonStatus.FROZEN));

    private final String description;
    private final MoveType moveType;
    private final Type type;
    private final int maxPp;
    private final int power;
    private final int accuracy;
    private final int priority;
    private final List<MoveEffect> moveEffectList;

    Move(String description, MoveType moveType, Type type, int pp, int power, int accuracy, int priority, MoveEffect... moveEffects) {
        this.description = description;
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

    public String getDescription() {
        return description;
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
