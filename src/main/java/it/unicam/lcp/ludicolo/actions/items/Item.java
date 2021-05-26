package it.unicam.lcp.ludicolo.actions.items;

import com.google.common.collect.Lists;
import it.unicam.lcp.ludicolo.pkmn.PokemonStatus;

import java.util.List;
import java.util.stream.Collectors;

public enum Item {

    POTION("Restores 20 HP.",
            "Potion", new HealItemEffect(20, false)),

    SUPER_POTION("Restores 60 HP.",
            "Super Potion", new HealItemEffect(60, false)),

    HYPER_POTION("Restores 120 HP.",
            "Hyper Potion", new HealItemEffect(120, false)),

    MAX_POTION("Fully restores HP.",
            "Max Potion", new HealItemEffect(100, true)),

    FULL_HEAL("A spray-type medicine. It heals all the status problems of a single Pokémon.",
            "Full Heal", new StatusItemEffect(PokemonStatus.CONFUSED),
            new StatusItemEffect(PokemonStatus.ASLEEP),
            new StatusItemEffect(PokemonStatus.BURNED),
            new StatusItemEffect(PokemonStatus.FROZEN),
            new StatusItemEffect(PokemonStatus.PARALYZED),
            new StatusItemEffect(PokemonStatus.POISONED)),

    FULL_RESTORE("A medicine that fully restores the HP and heals any status problems of a single Pokémon.",
            "Full Restore", new StatusItemEffect(PokemonStatus.CONFUSED),
            new StatusItemEffect(PokemonStatus.ASLEEP),
            new StatusItemEffect(PokemonStatus.BURNED),
            new StatusItemEffect(PokemonStatus.FROZEN),
            new StatusItemEffect(PokemonStatus.PARALYZED),
            new StatusItemEffect(PokemonStatus.POISONED),
            new HealItemEffect(100, true)),

    AWAKENING("A spray-type medicine. It awakens a Pokémon from the clutches of sleep.",
            "Awakening", new StatusItemEffect(PokemonStatus.ASLEEP)),

    BURN_HEAL("A spray-type medicine. It heals a single Pokémon that is suffering from a burn.",
            "Burn Heal", new StatusItemEffect(PokemonStatus.BURNED)),

    ICE_HEAL("A spray-type medicine. It defrosts a Pokémon that has been frozen solid.",
            "Ice Heal", new StatusItemEffect(PokemonStatus.FROZEN)),

    PARALYZE_HEAL("A spray-type medicine. It eliminates paralysis from a single Pokémon.",
            "Paralyze Heal", new StatusItemEffect(PokemonStatus.PARALYZED)),

    ANTIDOTE("A spray-type medicine. It lifts the effect of poison from one Pokémon.",
            "Antidote", new StatusItemEffect(PokemonStatus.POISONED)),

    MAX_ELIXIR("It fully restores the PP of all the moves learned by the targeted Pokémon.",
            "Max Elixir", new RestoreItemEffect(100, true)),

    ELIXIR("It restores the PP of all the moves learned by the targeted Pokémon by 10 points each.",
            "Elixir", new RestoreItemEffect(10, false));

    private final String description;
    private final List<ItemEffect> itemEffectList;
    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }

    Item(String description, String displayName, ItemEffect... itemEffects) {
        this.description = description;
        this.displayName = displayName;
        this.itemEffectList = Lists.newArrayList(itemEffects);
    }

    public String getDescription() {
        return description;
    }

    public boolean containsHealItemEffect() {
        return this.itemEffectList.stream().anyMatch(itemEffect -> itemEffect instanceof HealItemEffect);
    }

    public boolean containsStatusItemEffect() {
        return this.itemEffectList.stream().anyMatch(itemEffect -> itemEffect instanceof StatusItemEffect);
    }

    public boolean containsRestoreItemEffect() {
        return this.itemEffectList.stream().anyMatch(itemEffect -> itemEffect instanceof RestoreItemEffect);
    }

    public List<HealItemEffect> getHealItemEffects() {
        return this.itemEffectList.stream().filter(itemEffect -> itemEffect instanceof HealItemEffect).
                map(itemEffect -> (HealItemEffect) itemEffect).collect(Collectors.toList());
    }

    public List<StatusItemEffect> getStatusItemEffects() {
        return this.itemEffectList.stream().filter(itemEffect -> itemEffect instanceof StatusItemEffect).
                map(itemEffect -> (StatusItemEffect) itemEffect).collect(Collectors.toList());
    }

    public List<RestoreItemEffect> getRestoreItemEffects() {
        return this.itemEffectList.stream().filter(itemEffect -> itemEffect instanceof RestoreItemEffect).
                map(itemEffect -> (RestoreItemEffect) itemEffect).collect(Collectors.toList());
    }

}
