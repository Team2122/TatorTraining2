/**
 * A small, sharp dagger
 *
 * @author Tony Brar
 */
public class Dagger extends Weapon {
    public Dagger(String name, String description, int baseDamage) {
        super(name, description, baseDamage);
    }

    @Override
    public boolean useOn(Character target) {
        double outcome = Math.random();
        int damage = 15;
        if (outcome > 0.9) {
            System.out.println("CRITICAL HIT ZOMG");
            damage *= 2;
        } else if (outcome < 0.1) {
            System.out.println("You missed, practice more.");
            damage = 0;
        }
        target.health -= damage;
        // dagger never breaks
        return true;
    }
}
