package com.pierreparel.pokemoncardsjavafx;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PokemonCards {

    ArrayList<Pokemon> pokemons = new ArrayList<>();
    public PokemonCards(){
        loadStats();
    }
    private void loadStats(){
        System.out.println("LOADING STATS");
// Example function call: loadStats("assets/Pokemon.txt");
        try {
            // Scanner Object reads the line from the file
            FileReader fileReader = new FileReader("src/main/resources/com/pierreparel/pokemoncardsjavafx/assets/Pokemon.txt");


            // System.in reads from console while this reads from file
            Scanner text = new Scanner(fileReader);
            String[] pokemonStats;
            // Read and display the lines
            while (text.hasNext()) {
                String line = text.nextLine();
                System.out.println(line); // working!

                // Splits this string around matches of the given regular expression.
                pokemonStats = line.split(",");
                // Doc: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
//                System.out.println(Arrays.toString(pokemonStats));
                // Access of parameters:
                System.out.println(Arrays.toString(pokemonStats));
//                System.out.println(pokemonStats[0]); // Names
//                System.out.println(pokemonStats[1]); // Weights
//                System.out.println(pokemonStats[2]); // Heights
//                System.out.println(Double.parseDouble(pokemonStats[3]));//Attack
//                System.out.println(Double.parseDouble(pokemonStats[4]));// Defense
//                System.out.println(Double.parseDouble(pokemonStats[5]));// Stamina
//                System.out.println(pokemonStats[6]); // Types
                if(pokemonStats[6].equals("Water")){
                    WaterPokemon waterPokemon = new WaterPokemon();
                    waterPokemon.setName(pokemonStats[0]);
                    waterPokemon.setWeight(pokemonStats[1]);
                    waterPokemon.setHeight(pokemonStats[2]);
                    waterPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    waterPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    waterPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    waterPokemon.setType(pokemonStats[6]);
                    waterPokemon.setMulticlass(false);
                    pokemons.add(waterPokemon);
                }
                else if(pokemonStats[6].equals("Fire")){
                    FirePokemon firePokemon = new FirePokemon();
                    firePokemon.setName(pokemonStats[0]);
                    firePokemon.setWeight(pokemonStats[1]);
                    firePokemon.setHeight(pokemonStats[2]);
                    firePokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    firePokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    firePokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    firePokemon.setType(pokemonStats[6]);
                    firePokemon.setMulticlass(false);
                    pokemons.add(firePokemon);
                }
                else if(pokemonStats[6].equals("Normal")){
                    NormalPokemon normalPokemon = new NormalPokemon();
                    normalPokemon.setName(pokemonStats[0]);
                    normalPokemon.setWeight(pokemonStats[1]);
                    normalPokemon.setHeight(pokemonStats[2]);
                    normalPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    normalPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    normalPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    normalPokemon.setType(pokemonStats[6]);
                    normalPokemon.setMulticlass(false);
                    pokemons.add(normalPokemon);
                }
                else if(pokemonStats[6].equals("Electric")){
                    ElectricPokemon electricPokemon = new ElectricPokemon();
                    electricPokemon.setName(pokemonStats[0]);
                    electricPokemon.setWeight(pokemonStats[1]);
                    electricPokemon.setHeight(pokemonStats[2]);
                    electricPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    electricPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    electricPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    electricPokemon.setType(pokemonStats[6]);
                    electricPokemon.setMulticlass(false);
                    pokemons.add(electricPokemon);
                }
                else if(pokemonStats[6].equals("Rock/Water")){
                    RockWaterPokemon rockWaterPokemon = new RockWaterPokemon();
                    rockWaterPokemon.setName(pokemonStats[0]);
                    rockWaterPokemon.setWeight(pokemonStats[1]);
                    rockWaterPokemon.setHeight(pokemonStats[2]);
                    rockWaterPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    rockWaterPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    rockWaterPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    rockWaterPokemon.setType(pokemonStats[6]);
                    rockWaterPokemon.setMulticlass(true);
                    pokemons.add(rockWaterPokemon);
                }
                else if(pokemonStats[6].equals("Rock/Flying")){
                    RockFlyingPokemon rockFlyingPokemon = new RockFlyingPokemon();
                    rockFlyingPokemon.setName(pokemonStats[0]);
                    rockFlyingPokemon.setWeight(pokemonStats[1]);
                    rockFlyingPokemon.setHeight(pokemonStats[2]);
                    rockFlyingPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    rockFlyingPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    rockFlyingPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    rockFlyingPokemon.setType(pokemonStats[6]);
                    rockFlyingPokemon.setMulticlass(true);
                    pokemons.add(rockFlyingPokemon);
                }
                else if(pokemonStats[6].equals("Electric/Flying")){
                    ElectricFlyingPokemon electricFlyingPokemon = new ElectricFlyingPokemon();
                    electricFlyingPokemon.setName(pokemonStats[0]);
                    electricFlyingPokemon.setWeight(pokemonStats[1]);
                    electricFlyingPokemon.setHeight(pokemonStats[2]);
                    electricFlyingPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    electricFlyingPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    electricFlyingPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    electricFlyingPokemon.setType(pokemonStats[6]);
                    electricFlyingPokemon.setMulticlass(true);
                    pokemons.add(electricFlyingPokemon);
                }
                else if(pokemonStats[6].equals("Fire/Flying")){
                    FireFlyingPokemon fireFlyingPokemon = new FireFlyingPokemon();
                    fireFlyingPokemon.setName(pokemonStats[0]);
                    fireFlyingPokemon.setWeight(pokemonStats[1]);
                    fireFlyingPokemon.setHeight(pokemonStats[2]);
                    fireFlyingPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    fireFlyingPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    fireFlyingPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    fireFlyingPokemon.setType(pokemonStats[6]);
                    fireFlyingPokemon.setMulticlass(true);
                    pokemons.add(fireFlyingPokemon);
                }
                else if(pokemonStats[6].equals("Ice/Flying")){
                    IceFlyingPokemon iceFlyingPokemon = new IceFlyingPokemon();
                    iceFlyingPokemon.setName(pokemonStats[0]);
                    iceFlyingPokemon.setWeight(pokemonStats[1]);
                    iceFlyingPokemon.setHeight(pokemonStats[2]);
                    iceFlyingPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    iceFlyingPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    iceFlyingPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    iceFlyingPokemon.setType(pokemonStats[6]);
                    iceFlyingPokemon.setMulticlass(true);
                    pokemons.add(iceFlyingPokemon);
                }
                else if(pokemonStats[6].equals("Dragon/Flying")){
                    DragonFlyingPokemon dragonFlyingPokemon = new DragonFlyingPokemon();
                    dragonFlyingPokemon.setName(pokemonStats[0]);
                    dragonFlyingPokemon.setWeight(pokemonStats[1]);
                    dragonFlyingPokemon.setHeight(pokemonStats[2]);
                    dragonFlyingPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    dragonFlyingPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    dragonFlyingPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    dragonFlyingPokemon.setType(pokemonStats[6]);
                    dragonFlyingPokemon.setMulticlass(true);
                    pokemons.add(dragonFlyingPokemon);
                }
                else if(pokemonStats[6].equals("Psychic")){
                    PsychicPokemon psychicPokemon = new PsychicPokemon();
                    psychicPokemon.setName(pokemonStats[0]);
                    psychicPokemon.setWeight(pokemonStats[1]);
                    psychicPokemon.setHeight(pokemonStats[2]);
                    psychicPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    psychicPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    psychicPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    psychicPokemon.setType(pokemonStats[6]);
                    psychicPokemon.setMulticlass(false);
                    pokemons.add(psychicPokemon);
                }
                else if(pokemonStats[6].equals("Dragon")){
                    DragonPokemon dragonPokemon = new DragonPokemon();
                    dragonPokemon.setName(pokemonStats[0]);
                    dragonPokemon.setWeight(pokemonStats[1]);
                    dragonPokemon.setHeight(pokemonStats[2]);
                    dragonPokemon.setAttack(Double.parseDouble(pokemonStats[3]));
                    dragonPokemon.setDefense(Double.parseDouble(pokemonStats[4]));
                    dragonPokemon.setSpeed(Double.parseDouble(pokemonStats[5]));
                    dragonPokemon.setType(pokemonStats[6]);
                    dragonPokemon.setMulticlass(false);
                    pokemons.add(dragonPokemon);
                }

            }
            System.out.println(pokemons);
        } catch (FileNotFoundException e) {
            System.out.println("File does not Exist");
        }
    }
    public int getSize(){
        return pokemons.size();
    }

    public Pokemon getPokemon(int x){
        return pokemons.get(x);
    }

    public void remove(int x){
        pokemons.remove(x);
    }

    public int searchPokemon(String name){
        for(Pokemon p  : pokemons){
            if(p.getName() != null && p.getName().equals(name)){
                System.out.println("Index of " + p.getName() + ": " + pokemons.indexOf(p));
                return pokemons.indexOf(p);
            }
        }
        return -1;
    }


}
