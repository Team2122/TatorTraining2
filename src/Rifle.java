public class Rifle extends Weapon {
    private Ranger owner;
    private int maxBullets = 0;
    private int bullets = 0;

    Rifle(Ranger weaponOwner, String name, String description, int baseDamage, int maxBullets) {
        super(name, description, baseDamage);
        bullets = maxBullets;
        owner = weaponOwner;
    }

    public void load() {
        bullets = maxBullets;
    }

    @Override
    public boolean useOn(Character target) {
        if (target == null) {
            return false;
        }
        if (target == owner) {
            return false;
        }
        if (bullets == 0) {
            load();
            System.out.println("*click*");
            return false;
        }
        System.out.println("bang!");
        if (owner.getAccuracy() > Math.random()) {
            target.health -= getBaseDamage();
            System.out.println("Hit!");
            return true;
        } else {
            System.out.println("Miss!");
            return false;
        }
    }
}
