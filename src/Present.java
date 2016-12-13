/**
 * A present weapon
 */
public class Present extends Weapon {
    private Santa santa;
    private int numOfPresents;

    public Present(String name, Santa santa) {
        super(name, "a small box wrapped in green and red striped wrapping paper", 10);
        this.santa = santa;
        numOfPresents = 1;
    }

    public boolean useOn(Character target) {
        double explodeChance = Math.random();
        if (santa.getEnergy() < 10) {
            System.out.println(santa.getName() + "is too tired, so they fall asleep");
            System.out.println(santa.getName() + "woke up with 20 more energy");
            santa.setEnergy(santa.getEnergy() + 20);
            return false;
        }
        if (numOfPresents <= 0) {
            System.out.println(santa.getName() + "doesn't have any presents to throw!");
            return false;
        }
        if (target.health >= 100) {
            System.out.println(target.getName() + "already has full health! There were no effects");
        } else {
            if (explodeChance > .85) {
                System.out.println(santa.getName() + "threw a present at " + target.getName()
                        + ", and it exploded green healing goo! 30 health was added!");
                if (target.health > 70) {
                    target.health = 100;
                } else {
                    target.health += 30;
                }
            } else {
                System.out.println(santa.getName() + "threw a present at " + target.getName() + ", and it added 10 health!");
                if (target.health > 90) {
                    target.health = 100;
                } else {
                    target.health += 10;
                }
            }
        }
        santa.setEnergy(santa.getEnergy() - 10);
        numOfPresents -= 1;
        return true;
    }

    public int getNumOfPresents() {
        return numOfPresents;
    }

    public void setNumOfPresents(int numOfPresents) {
        this.numOfPresents = numOfPresents;
    }
}
