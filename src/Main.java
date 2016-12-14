import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Weapon defaultWeapon = new Fists();
        ArrayList<Character> characters = new ArrayList<>();
        /*
        Adding Your Character to the Arena, by Avery
        (this line left intentionally blank, tony)
        Below this comment, add a few of your type of character, i.e.
        characters.add(new BlahBlah(your constructor here)
        This works because we loop through every character, rather than hardcoding their indexes
        Please add your character to main on a separate branch, like added-averys-char-to-main
         */
        characters.add(new Ranger("Alex", .01));
        characters.add(new Ranger("Jimmy", .75));
        characters.add(new Ranger("Jake", .50));
        characters.add(new Rogue("Tony", "green"));
        characters.add(new Rogue("Colin", "elitist blue"));
        characters.add(new Warrior("Bob", 240, 5, "green", "brown"));
        characters.add(new Warrior("Andrew", 210, 6, "blue", "black"));
        characters.add(new Warrior("Sam", 250, 5, "Hazel", "blond"));
        Collections.shuffle(characters, new Random());
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
            if (targetIndex == -1) {
                System.out.println(curr.getName() + "'s attack failed because" +
                        " it couldn't find a good target.");
                continue;
            }
            Character target = characters.get(targetIndex);
            Weapon weapon = curr.getEquippedWeapon();
            if (weapon == null) {
                weapon = defaultWeapon;
            }
            System.out.println(curr.getName() + " attacks " +
                    target.getName() +
                    " with their " + weapon.getName());
            weapon.useOn(target);
        }
        if (characters.size() == 1) {
            System.out.println(characters.get(0).getName() + " won!");
        } else {
            System.out.println("Mutually assured destruction");
        }
    }
}
