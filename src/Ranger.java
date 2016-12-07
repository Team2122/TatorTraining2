
public class Ranger extends Character {
    private double hitMult;
    private int numBullets = 15;
    private boolean isGunClean = true;

    Ranger(String name, double hitMult) {
        super(name);
        this.hitMult = hitMult; //how well of a marksman this Ranger is
    }

    @Override
    public void attack(Character other) {
        if(other==this){
            return; //morale is too high
        };
        if (isGunClean) {
            if (numBullets != 0) {
                other.health -= (int) (Math.random() * 5 * (hitMult * 3));
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