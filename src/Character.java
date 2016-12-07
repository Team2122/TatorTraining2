public abstract class Character {
    private String name;
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0
    }

    /**
     * Attacks the other character, subtract health as appropriate and printing
     * out descriptory messages.
     */
    public abstract void attack(Character other);

    /**
     * Prints out a description of this character
     */
    public abstract void describeSelf();

    /**
     * Gets the name of the primary weapon of this Character
     */
    public abstract String getPrimaryWeapon();
}
