
/**
 * Creates a Sword and can attack with it instead of an attack method.
 */
public class Sword extends Weapon {
    private boolean isBroken = false;

    public Sword(String name, String description) {
        super(name, description, 15);
    }

    @Override
    public boolean useOn(Character other) {
        int breakChance = (int) (Math.random() * 100);
        if (isBroken) {
            System.out.println("Your weapon is broken you can't use it");
            isBroken = false;
            System.out.println("Your weapon has been fixed");
            return false;
        } else if (breakChance >= 99) {
            System.out.println("Your weapon broke! You need to fix it before it can be used again.");
            isBroken = true;
            return false;
        }
        /**
         * Multiple Hit Capability
         */
        int hitNumber = (int) (Math.random() * 3);
        other.health -= 10 * hitNumber;
        if (hitNumber == 0) {
            System.out.println("You missed!");
        } else if (hitNumber > 1) {
            System.out.println("You hit " + hitNumber + " times!");
        }
        else {
            System.out.println("You hit once.");
        }
        return false;
    }

    public void fixWeapon() {
        isBroken = false;
        System.out.println("You fixed your weapon");
    }
}

