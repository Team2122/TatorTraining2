import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private String name;
    protected int health;
    /**
     * List of all weapons this character possesses.
     */
    List<Weapon> weapons;

    private int equippedWeapon;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        // empty arsenal
        weapons = new ArrayList<>();
        // no weapon to equip yet
        equippedWeapon = -1;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Prints out a description of this character
     */
    public abstract void describeSelf();

    /**
     * Adds a weapon to the Character's arsenal
     */
    public void addWeapon(Weapon newWeapon) {
        weapons.add(newWeapon);
        if (weapons.size() == 1) {
            setEquippedWeapon(0);
        }
    }

    /**
     * Gets the equipped weapon of this Character
     */
    public Weapon getEquippedWeapon() {
        return weapons.get(equippedWeapon);
    }

    /**
     * Set the equipped weapon of this Character
     */
    protected void setEquippedWeapon(int equippedIndex) {
        equippedWeapon = equippedIndex;
    }

    /**
     * Finds a target for the Character to attack
     */
    public int pickTarget(List<Character> potentialTargets) {
        return (int) (Math.random() * potentialTargets.size());
    }
}
