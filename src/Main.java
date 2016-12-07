import java.util.ArrayList;

/**
 * Created by avery on 12/6/16.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList();
        characters.add(new Ranger("Ranger 1", 0.65));
        characters.add(new Ranger("Ranger 2", .75));
        characters.add(new Ranger("Ranger 3", .50));

        for(Character character : characters){
            character.describeSelf();
        }
        for (int i = 0; characters.size() != 1; i++) {
            if (i >= characters.size()) {
                i = 0;
            }
            if (!characters.get(i).isAlive()) {
                System.out.println("Removed the body of " + characters.get(i).getName());
                characters.remove(i);
                i--;
                continue;
            }
            int targetIndex = characters.get(i).pickTarget(characters);
            if (targetIndex != i) {
                System.out.println(characters.get(i).getName() + " attacked " +
                        characters.get(targetIndex).getName() +
                        " with their " + characters.get(i).getEquippedWeapon().getName());
            }
            characters.get(i).getEquippedWeapon().useOn(characters.get(targetIndex));

        }
        System.out.println(characters.get(0).getName() + " won!");
    }
}
