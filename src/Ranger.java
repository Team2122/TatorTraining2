
public class Ranger extends Character {
    private double hitChance;
    private int numBullets = 15;
    private boolean isGunClean = true;

    Ranger(String name, double hitChance) {
        super(name);
        this.hitChance = hitChance; //ratio of hits to misses
    }

    @Override
    public void attack(Character other) {
        if (isGunClean) {
            if (numBullets != 0) {
                other.health -= (int) (Math.random() * 5 * (hitChance * 3));
                numBullets--;
                System.out.println("bang!");
                if (Math.random() > .99) {
                    isGunClean = false;
                }
                clean();
            } else {
                System.out.println("*click*"); //clip is empty, reload
                reload();
            }
        } else {
            this.health -= 10;
            System.out.println("boom!");
            //gun explodes if barrel is obstructed
        }
    }

    @Override
    public void describeSelf() {
        System.out.println("Hello, my name is " + getName() + ". I'm a Ranger.");
    }

    @Override
    public String getPrimaryWeapon() {
        return "Rifle";
    }

    public void reload() {
        numBullets = 15;
    }

    public void clean() {
        isGunClean = true;
    }
}