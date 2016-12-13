import java.util.List;

/**
 * Creates a Warrior character with weight, height, eye color, hair color, and name
 */
public class Warrior extends Character {
    private int weight;
    private int height;
    private String eyeColor;
    private String hairColor;

    public Warrior(String name, int weight, int height, String eyeColor, String hairColor) {
        super(name);
        addWeapon(new Sword(name + "'s sword", "Plain Old Sword"));
        this.weight = weight;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }


    public void describeSelf() {
        System.out.println("I am " + height + "ft tall and " + weight + "lbs. I have " + eyeColor + "eyes and " + hairColor + "hair.");
    }

    /**
     * Picks a target. Targets the highest health first
     */
    public int pickTarget(List<Character> potentialTargets) {
        int highestHealth = 0;
        int characterIndex = -1;
        Character currentTarget;
        for (int i = 0; i < potentialTargets.size(); i++) {
            currentTarget = potentialTargets.get(i);
            if (currentTarget.getHealth() > highestHealth && !currentTarget.equals(this)) {
                highestHealth = currentTarget.getHealth();
                characterIndex = i;
            }
        }
        return characterIndex;
    }

}
