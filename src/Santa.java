import java.util.List;

/**
 * A Santa Character
 */
public class Santa extends Character {
    private String suitColor;
    private int numOfElves;
    private int energy;
    private Present myPresent;

    public Santa(String santaName, String suitColor) {
        super(santaName);
        this.suitColor = suitColor;
        numOfElves = 0;
        energy = 100;
        myPresent = new Present("Present 1", this);
    }

    public String getSuitColor() {
        return suitColor;
    }

    public int getNumOfElves() {
        return numOfElves;
    }

    public int getEnergy() {
        return energy;
    }

    public void describeSelf() {
        System.out.println("My name is " + getName() + ", their suit is " + getSuitColor() + ", they have "
                + myPresent.getNumOfPresents() + " presents, they are being followed by " + getNumOfElves()
                + "elves, and they have " + getEnergy() + "energy");
    }

    public void stalkChildren(Character stalkee) {
        System.out.println(getName() + "stalked " + stalkee.getName() + ", and found out that their health is "
                + stalkee.getHealth());
    }

    public void summonElves(int energyUsed) throws InterruptedException {
        if (energyUsed > energy) {
            System.out.println(getName() + "is too tired, so they fall asleep");
            if ((energy + 10) > 100) {
                System.out.println("It is impossible to summon that many elves");
            } else {
                energy += 20;
            }
            System.out.println("Try to summon the elves again");
        } else {
            if (numOfElves >= 10) {
                System.out.println(getName() + "has too many elves, no more can be added");
            } else {
                numOfElves += energyUsed;
                energy -= energyUsed;
            }
        }
    }

    public void buildPresents() {
        myPresent.setNumOfPresents(myPresent.getNumOfPresents() + numOfElves);
    }

    void setEnergy(int energy) {
        this.energy = energy;
    }
}
