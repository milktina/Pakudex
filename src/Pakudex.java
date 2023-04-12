import java.util.ArrayList;
import java.util.Arrays;

public class Pakudex {

    private Pakuri[] pakuris;

    private int capacity; // the maximum Pakuri we store in the Pakuris array
    private int size = 0; // the number of concrete Pakuri in the Pakuris array

    // default constructor; if called, the default size for the Pakudex should be 20
    public Pakudex() {
        pakuris = new Pakuri[20];
        capacity = 20;
    }

    // initializes this object to contain exactly capacity objects when completely full
    public Pakudex(int capacity) {
        pakuris = new Pakuri[capacity];
        this.capacity = capacity;
    }

    // returns the number of critters currently being stored in the Pakudex
    public int getSize() {
        return this.size;
    }

    // returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity() {
        return this.capacity;
    }

    // returns a String array containing the species of the critters as ordered in the Pakudex;
    // if there are no species add yet, this method should return null
    public String[] getSpeciesArray() {
        if (size != 0) {
            String[] critters = new String[size];

            for (int i = 0; i < size; i++) {
                //iterate through pakudex get species and add to critters
                critters[i] = pakuris[i].getSpecies();
            }
            return critters;
        }
        return null;
    }

    // returns an int array containing the attack, defense, and speed statistics of species at indices
    // 0, 1, and 2 respectively; if species is not in the Pakudex, returns null
    public int[] getStats(String species) {
        int[] pakuriStats = new int[3];
        for (int i = 0; i < getSize(); i++) {
                //iterate through pakudex get species and add to critters
                if (pakuris[i].getSpecies().equals(species)) {
                    pakuriStats[0] = pakuris[i].getAttack();
                    pakuriStats[1] = pakuris[i].getDefense();
                    pakuriStats[2] = pakuris[i].getSpeed();
                    return pakuriStats;
                }
            }
        return null;
    }

    //sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species
    public void sortPakuri() {
            for (int i = 0; i < getSize() - 1; ++i) {
                for (int j = i + 1; j < getSize(); ++j) {
                    if (pakuris[i].getSpecies().compareTo(pakuris[j].getSpecies()) > 0) {
                        String temp1 = pakuris[i].getSpecies();
                        pakuris[i] = pakuris[j];
                        Pakuri temp2 = new Pakuri(temp1);
                        pakuris[j] = temp2;

                    }
                }

            }
        }

    // adds species to the Pakudex; if successful, return true, and false otherwise
    public boolean addPakuri(String species) {
        Pakuri speciesAdded = new Pakuri(species);
        if (size != 0) {
            for (int i = 0; i < getSpeciesArray().length; i++) {
                if (getSpeciesArray()[i].equals(species)) {
                    System.out.println("Error: Pakudex already contains this species!");
                    return false;
                }
            }
        }
        // checks if pakuris array is full
        if (size >= capacity) {
            System.out.println("Error: Pakudex is full!");
            return false;
        }
        pakuris[size] = speciesAdded;
        System.out.println("Pakuri species " + species + " successfully added!");
        size++;

        return true;
    }
    //1. when a duplicate pakuri is added (iterate through pakuri's array and find whether there is already pakuri with the name p.getSpecies(), return false
    //2. when array is full, return false: compare size and capacity: if size >= capacity then array is full

    // return true -> add pakuri successful
    // p.addPakuri(p)
    // add new Pakuri(species) into pakuris array using size(index)
    // pakuris[size].getSpecies() to get the name of a species at a specific index


    // attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
    public boolean evolveSpecies(String species) {
        for (int i = 0; i < getSize(); i++) {
            if (pakuris[i].getSpecies().equals(species)) {
                pakuris[i].evolve();

                return true;
            }
        }
        System.out.println("Error: No such Pakuri!");
        return false;
    }
}
