package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.pkmn.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> pokemonTeam;
    private List<Pokemon> faintedPokemon;
    private int currentPokemon;

    public Player(String name, List<Pokemon> pokemonTeam) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
        this.pokemonTeam.forEach(pkmn -> pkmn.setOwner(this));
        this.faintedPokemon = new ArrayList<>();
        this.currentPokemon = 0;
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

    public Pokemon getCurrentPokemon() {
        return pokemonTeam.get(currentPokemon);
    }

    public void setCurrentPokemon(int currentPokemon) {
        this.currentPokemon = currentPokemon;
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
                ", currentPokemon=" + currentPokemon +
                '}';
    }
}
