
public class Ranger extends Character {
    private double hitAcc;

    Ranger(String name, double hitAcc) {
        super(name);
        this.hitAcc = hitAcc; //how well of a marksman this Ranger is
        this.addWeapon(new Rifle(this, "Mosin Nagant", "A five-shot, bolt-action, internal magazine–fed, military rifle", 20, 5));
        this.addWeapon(new Rifle(this, "M16A1", "A famous Vietnam-era rifle, standard issue", 10, 30));
    }

    public double getAccuracy() {
        return hitAcc;
    }

    @Override
    public void describeSelf() {
        System.out.println("Hello, my name is " + getName() + ". I'm a Ranger.");
    }
}