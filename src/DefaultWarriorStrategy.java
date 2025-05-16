import java.util.*;
import java.lang.String;

public class DefaultWarriorStrategy implements WarriorAttackStrategy 
{
    boolean firstAttack = true;
    
    @Override
    public void attack(AlienArmy army, Satellite sat, Telescope tel) {
        List<Alien> fromSat = sat.getObservedAliens();
        List<Alien> fromTel = tel.getObservedAliens();
        
        HashSet<Alien> target = new HashSet<>();
        target.addAll(fromSat);
        target.addAll(fromTel);
        
        int kills = 0;
        
        for(Alien a : target) {
            if(a.isAlive()==true) {
                a.destroy();
                kills++;
            }
        }
        
        String txt = "Ο πολεμιστής κατέστρεψε ";
        txt = txt.concat(Integer.toString(kills));
        txt = txt.concat(" εχθρούς!");
        System.out.println(txt);
        
        if(firstAttack) firstAttack=false;
    }
}