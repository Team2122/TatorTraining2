import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList();
        characters.add(new Ranger("Alex", .01));
        characters.add(new Ranger("Jimmy", .75));
        characters.add(new Ranger("Jake", .50));
        for (Character character : characters) {
            character.describeSelf();
        }
        for (int i = 0; characters.size() != 1; i++) {
            if (i >= characters.size()) {
                i = 0;
            }
            Character curr = characters.get(i);
            if (!curr.isAlive()) {
                System.out.println("Removed the body of " + curr.getName());
                characters.remove(i);
                i--;
                continue;
            }
            int targetIndex = curr.pickTarget(characters);
            if (targetIndex != i) {
                System.out.println(curr.getName() + " attacked " +
                        characters.get(targetIndex).getName() +
                        " with their " + curr.getEquippedWeapon().getName());
            }
            curr.getEquippedWeapon().useOn(characters.get(targetIndex));
        }
        System.out.println(characters.get(0).getName() + " won!");
    }
}
