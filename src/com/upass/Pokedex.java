package com.upass;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> pokemonList;

    Pokedex(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public void displayPokemon(Pokemon pokemon) {
        System.out.println("#" + pokemon.getId()
                + " " + pokemon.getName()
                + " " + pokemon.getType());
    }

    public void displayAllPokemon(ArrayList<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            displayPokemon(pokemon);
        }
    }

    public Pokemon getPokemonById(int id) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    public ArrayList<Pokemon> getPokemonByType(String type) {
        ArrayList<Pokemon> pokemonOfType = new ArrayList<>();
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getType().equalsIgnoreCase(type)) {
                pokemonOfType.add(pokemon);
            }
        }
        return pokemonOfType;
    }

    public void displayFoundPokemon() {
        ArrayList<Pokemon> pokemons = getFoundPokemon();
        for (Pokemon pokemon : pokemons) {
            displayPokemon(pokemon);
        }
        if (pokemons.size() < 1) {
            System.out.println("No found pokemon to display");
        }
    }

    private ArrayList<Pokemon> getFoundPokemon() {
        ArrayList<Pokemon> foundPokemon = new ArrayList<>();
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getIsFound()) {
                foundPokemon.add(pokemon);
            }
        }
        return foundPokemon;
    }
}