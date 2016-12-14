import java.util.List;

/**
 * Created by Sophie on 12/6/2016.
 */
public class LumberJack extends Character{
    private String flannelColor;

    public LumberJack(String name, String flannelColor ){
        super(name);
        this.flannelColor = flannelColor;
    }

    public void attack(Character other) {
        double damage = other.getHealth()*Math.random();
        other.health -= damage;
    }

    public void describeSelf(){
        System.out.println("My name is" + this.getName());
        System.out.println ("What did the lumberjack say about the mathematician who couldn’t dance?\n-Man, that guy needs to get some logarithm.”");
    }

    public String getPrimaryWeapon() {
        return "axe";
    }

    public int pickTarget(List<Character> potentialTargets){
        int mostHealth = 0;
        int index= 0;


        for(int i=0; i< potentialTargets.size(); i++){
            if (potentialTargets.get(i).getHealth() >  mostHealth && this != potentialTargets.get(i)){
                mostHealth = potentialTargets.get(i).getHealth();
                index = i;
            }
        }
        return index;

    }


}
