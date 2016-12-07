import java.util.List;

/**
 * An awesome edgy character with blades
 */
public class Rogue extends Character {
    private String cloakColor;

    public Rogue(String rogueName, String cloakColor) {
        super(rogueName);
        this.cloakColor = cloakColor;
    }

    public void attack(Character target) {
        double outcome = Math.random();
        if (outcome > 0.9) {
            System.out.println("CRITICAL HIT ZOMG");
            target.health -= 30;
        } else {
            target.health -= 15;
        }
    }

    public void describeSelf() {
        System.out.println("I am a rogue with " + health + " health and a "
                + cloakColor + " cloak.");
    }

    public String getPrimaryWeapon() {
        return "Poison dagger";
    }

    @Override
    public int pickTarget(List<Character> victims) {
        int minHealth = 1000000000;
        int bestTarget = -1;
        int numVictims = victims.size();
        for (int i = 0; i < numVictims; i++) {
            Character currentVictim = victims.get(i);
            if (currentVictim.getHealth() < minHealth) {
                minHealth = currentVictim.getHealth();
                bestTarget = i;
            }
        }
        return bestTarget;
    }
}
