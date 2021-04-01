package it.unicam.lcp.lotad;

import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> pokemonTeam;
    private int currentPokemon;

    public Player(String name, List<Pokemon> pokemonTeam) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokemonTeam=" + pokemonTeam +
                ", currentPokemon=" + currentPokemon +
                '}';
    }
}
