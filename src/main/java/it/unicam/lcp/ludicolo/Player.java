package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private List<Pokemon> pokemonTeam;

    public Player(String name, List<Pokemon> pokemonTeam) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
        this.pokemonTeam.forEach(pkmn -> pkmn.setOwner(this));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }

    public List<Pokemon> getPokemonTeamNotFainted() {
        return pokemonTeam.stream().filter(pokemon -> pokemon.getStageValue(Stat.LIFE) > 0).collect(Collectors.toList());
    }

    public void setPokemonTeam(List<Pokemon> pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }

    public boolean areAllFainted(){
        int fainted = (int) this.pokemonTeam.stream().filter(pokemon -> pokemon.getStageValue(Stat.LIFE) == 0).count();
        return fainted == this.pokemonTeam.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokemonTeam=" + pokemonTeam + ", all fainted=" + this.areAllFainted()+
                '}';
    }
}
