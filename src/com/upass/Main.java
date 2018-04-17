package com.upass;

import java.util.ArrayList;

public class Main {
    private static Pokedex pokedex = new Pokedex(getStarterPokemon());

    public static void main(String [] args) {
        char option;

        while ((option = readOption()) != 'x') {

            switch (option) {
                case 'i': selectById();
                    break;
                case 't': selectByType();
                    break;
                case 'f': pokedex.displayFoundPokemon();
                    break;
            }
        }
    }

    private static void selectById() {
        int input;

        while ((input = readPokemonId()) != -1) {

            Pokemon pokemon = pokedex.getPokemonById(input);

            if (pokemon != null) {
                pokedex.displayPokemon(pokemon);
            }
            else {
                System.out.println("Pokemon not found");
            }
        }
    }

    private static void selectByType() {
        String input;

        while (!(input = readPokemonType()).equalsIgnoreCase("quit")) {

            ArrayList<Pokemon> pokemon = pokedex.getPokemonByType(input);

            if (pokemon != null) {
                pokedex.displayAllPokemon(pokemon);
            }
            else {
                System.out.println("No pokemon not found");
            }
        }
    }

    private static char readOption() {
        System.out.println("----Options----");
        System.out.println("  i, t, f, x   ");
        System.out.println("---------------");
        System.out.print("What would you like to do? ");
        return In.nextChar();
    }

    private static int readPokemonId() {
        System.out.println("(Type \"-1\" to go back)");
        System.out.print("What Pokemon would you like to view (by ID)? ");
        return In.nextInt();
    }

    private static String readPokemonType() {
        System.out.println("(Type \"quit\" to go back)");
        System.out.print("What Pokemon type are you looking for? ");
        return In.nextLine();
    }

    private static ArrayList<Pokemon> getStarterPokemon() {
        ArrayList<Pokemon> list = new ArrayList<>();
        list.add(new Pokemon(1, "Bulbasaur", "Water"));
        list.add(new Pokemon(4, "Charmander", "Fire"));
        list.add(new Pokemon(7, "Squirtle", "Water"));
        return list;
    }
}
