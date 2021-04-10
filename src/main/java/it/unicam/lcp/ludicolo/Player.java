package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.pkmn.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> pokemonTeam;
    private List<Pokemon> faintedPokemon;

    public Player(String name, List<Pokemon> pokemonTeam) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
        this.pokemonTeam.forEach(pkmn -> pkmn.setOwner(this));
        this.faintedPokemon = new ArrayList<>();
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

    public void setPokemonTeam(List<Pokemon> pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }


    public void addFainted(Pokemon fainted){
        this.faintedPokemon.add(fainted);
    }

    public boolean areAllFainted(){
        return this.faintedPokemon.containsAll(this.pokemonTeam);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokemonTeam=" + pokemonTeam +
                '}';
    }
}
