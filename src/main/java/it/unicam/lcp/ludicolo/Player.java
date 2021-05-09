package it.unicam.lcp.ludicolo;

import it.unicam.lcp.ludicolo.actions.items.Item;
import it.unicam.lcp.ludicolo.pkmn.Pokemon;
import it.unicam.lcp.ludicolo.pkmn.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private List<Pokemon> pokemonTeam;
    private Map<Item, Integer> backpack;

    public Player(String name, List<Pokemon> pokemonTeam, Map<Item, Integer> backpack) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
        this.pokemonTeam.forEach(pkmn -> pkmn.setOwner(this));
        this.backpack = backpack;
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

    public Map<Item, Integer> getBackpack() {
        return backpack;
    }

    public void consumeItem(Item item){
        this.backpack.put(item, this.backpack.get(item) - 1);
        if(this.backpack.get(item) == 0){
            this.backpack.remove(item);
        }
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
