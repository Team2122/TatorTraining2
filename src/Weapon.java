/**
 * Representation of a Weapon usable by a Character
 */
public abstract class Weapon {
    /**
     * Name of the weapon
     */
    private String name;

    /**
     * Brief description of the weapon
     */
    private String description;

    /**
     * Basic damage of the weapon -- meant to be modified by whatever you can dream up
     */
    private int baseDamage;

    public Weapon(String name, String description, int baseDamage) {
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
    }

    /**
     * Uses the weapon once on the given target. Returns false if the weapon cannot be used.
     * (Hint: some weapons use ammunition or break. Some don't.)
     *
     * @return true if weapon was used, false if it cannot be
     */
    public abstract boolean useOn(Character target);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}
