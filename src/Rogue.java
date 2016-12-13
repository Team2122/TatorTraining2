import java.util.List;

/**
 * An awesome edgy character with blades
 */
public class Rogue extends Character {
    private String cloakColor;

    public Rogue(String rogueName, String cloakColor) {
        super(rogueName);
        this.cloakColor = cloakColor;
        weapons.add(new Dagger("poison dagger", "shiny obsidian dagger with a weird smell", 15));
    }

    public void describeSelf() {
        System.out.println("I am a rogue with " + health + " health and a "
                + cloakColor + " cloak.");
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
