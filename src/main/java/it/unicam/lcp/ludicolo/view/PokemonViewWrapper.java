package it.unicam.lcp.ludicolo.view;

import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.Stat;

public class PokemonViewWrapper {
    private final Pokemon pkmn;

    public PokemonViewWrapper(Pokemon pkmn) {
        this.pkmn = pkmn;
    }

    public Pokemon getPkmn() {
        return pkmn;
    }



    public String toString() {
        String statusString = this.pkmn.getStatus() == null ? "" : "\n[" + this.pkmn.getStatus().name() + "]";

        return String.format(
                "%s\n" +
                        "Lv.: %d ♥ %d/%d %s" , this.pkmn.getDisplayName(), this.pkmn.getLevel(), this.pkmn.getStageValue(Stat.LIFE), this.pkmn.getBattleStatValue(Stat.LIFE), statusString);
    }
}
