import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * much character
 *
 * @author Colin "Eric" Reeder :>
 */
public class Doge extends Character {

    private int riches;

    public Doge(String name, int riches, int strength, boolean hasTipBot) {
        super(name);
        this.riches = riches;
        addWeapon(new Paws(strength));
        if (hasTipBot) {
            addWeapon(new TipBot(2));
            setEquippedWeapon(1);
        }
    }

    @Override
    public void describeSelf() {
        System.out.println("such doge.  much " + getName() + ".  so " + getWealthDescription() + ", very Đ" + riches);
    }

    private String getWealthDescription() {
        if (riches < 1000000) {
            return "poor";
        }
        if (riches > 100000000) {
            return "rich";
        }
        return "middle-class";
    }

    public void receiveTip(int value) {
        riches += value;
    }


    private class Paws extends Weapon {
        Paws(int strength) {
            super("paws", "Somewhat sharp claws, somewhat effective at attacking", strength);
        }

        @Override
        public boolean useOn(Character target) {
            double damage = ((double) ((int) (Math.random() * getBaseDamage() * 10))) / 10;
            target.health -= damage;
            System.out.println("*scratch*");
            System.out.println(target.getName() + " clawed for " + damage + " damage");
            return true;
        }
    }

    private class TipBot extends Weapon {
        public TipBot(int baseDamage) {
            super("/u/dogetipbot", "Only the best of tip bots", baseDamage);
        }

        @Override
        public boolean useOn(Character target) {
            TipAmount[] amounts = {new TipAmount(4, 240, "megaroll"),
                    new TipAmount(98, "dogecar"),
                    new TipAmount(4),
                    new TipAmount(100),
                    new TipAmount(1337, "netcodepool"),
                    new TipAmount(1000, "silentshibe"),
                    new TipAmount(365, "cake"),
                    new TipAmount(98),
                    new TipAmount(98),
                    new TipAmount(new Random().nextInt(600))};
            TipAmount chosenAmount = amounts[new Random().nextInt(amounts.length)];
            boolean verify = Math.random() > 0.3;
            System.out.println(Doge.this.getName() + ": +/u/dogetipbot " + target.getName() + " " + chosenAmount.name + (verify ? " verify" : ""));
            int amount = chosenAmount.getValue();
            verify = verify || amount >= 1000;
            boolean success = amount <= riches;
            if (success) {
                riches -= amount;
            }
            if (verify && success) {
                System.out.println("dogetipbot: [wow so verify]: " + Doge.this.getName() + " -> " + target.getName() + " Đ" + amount + " Dogecoins");
            }
            if (target instanceof Doge && Math.random() < 0.95) {
                if (!success) {
                    if (Math.random() < 0.9) {
                        System.out.println(target.getName() + ": I guess it didn't go through...");
                    }
                } else {
                    ((Doge) target).receiveTip(amount);
                    if (Math.random() < 0.6) {
                        System.out.println(target.getName() + ": Thanks!");
                    }
                }
            } else if (success) {
                double damage = amount * getBaseDamage() / 50;
                System.out.println(target.getName() + " did not collect the tip, and was bitten by the community.  -" + damage + " health!");
                target.health -= damage;
            }
            return success;
        }

        private class TipAmount {
            private int min;
            private int max;
            private String name;

            public TipAmount(int min, int max, String name) {
                this.min = min;
                this.max = max;
                this.name = name;
            }

            public TipAmount(int value, String name) {
                this(value, value, name);
            }

            public TipAmount(int value) {
                this(value, value + " doge");
            }

            public int getValue() {
                if (min == max) {
                    return min;
                } else {
                    return min + new Random().nextInt((max - min) / 4) * 4;
                }
            }
        }
    }

    @Override
    public int pickTarget(List<Character> potentialTargets) {
        potentialTargets = potentialTargets.stream().filter(character -> character != this).collect(Collectors.toList());
        int target = super.pickTarget(potentialTargets);
        if (target >= 0) {
            return target;
        } else {
            return 0;
        }
    }
}
