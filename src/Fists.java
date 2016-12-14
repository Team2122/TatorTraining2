/**
 * Default weapon for when you are unarmed
 */
public class Fists extends Weapon {
    public Fists() {
        super("fists", "your hands", 3);
    }


    @Override
    public boolean useOn(Character target) {
        target.health -= getBaseDamage();
        System.out.println("Slapped for " + getBaseDamage() + " damage.");
        return true;
    }
}
