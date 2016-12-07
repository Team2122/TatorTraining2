
public class Ranger extends Character {
    private double hitChance;
    private int numBullets=15;
    Ranger(String name, double hitChance){
        super(name);
        this.hitChance=hitChance; //ratio of hits to misses
    }
    @Override
    public void attack(Character other) {
        if(numBullets!=0) {
            other.health = (int) (Math.random() * 5 * (hitChance * 3));
            numBullets--;
        }else{
            System.out.println("*click*");
        }
    }
    @Override
    public void describeSelf() {
        System.out.println("Hello, my name is "+getName()+". I'm a Ranger.");
    }

    @Override
    public String getPrimaryWeapon() {
        return "Rifle";
    }

    public void reload() {
        numBullets=15;
    }
}