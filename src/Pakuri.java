public class Pakuri implements Comparable<Pakuri>
{
    // attributes of the object
    private String species;
    private int attack;
    private int defense;
    private int speed;

    //the only constructor in this class
    public Pakuri(String species) {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    // returns the species of this critter
    public String getSpecies() {
    return species;
    }

    // returns the attack value for this critter
    public int getAttack() {
    return attack;
    }

    // returns the defense value for this critter
    public int getDefense() {
    return defense;
    }

    // returns the speed of this critter
    public int getSpeed() {
    return speed;
    }

    // changes the attack value for this critter to newAttack
    public void setAttack(int newAttack) {
    this.attack = newAttack;
    }

    // will evolve the critter as follows: a) double the attack b) quadruple the defense c) triple the speed
    public void evolve() {
    this.attack = attack*2;
    this.defense = defense*4;
    this.speed = speed*3;
    }

    // comparable method
    @Override
    public int compareTo(Pakuri target) {
        return target.getSpecies().compareTo(this.getSpecies());
    }
}