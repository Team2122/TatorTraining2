
public class Ranger extends Character {
    private double hitChance;
    private int numBullets=15;
    Ranger(String name, double hitChance){
        super(name);
        this.hitChance=hitChance; //ratio of hits to misses
    }
    @Override
    public void attack(Character other) {
        other.health=(int)(Math.random() * 5 * (hitChance*3));
        numBullets--;
    }
    @Override
    public void describeSelf() {

    }

    @Override
    public String getPrimaryWeapon() {
        return null;
    }
}