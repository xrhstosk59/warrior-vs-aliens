import java.util.*;
public class FullAttackStrategy implements AlienAttackStrategy {
    
    Scanner s;
    int x = 0;
    boolean showDebug = false;
    
    public FullAttackStrategy(Scanner scnr) { 
        s = scnr; 
    }
    
    public @Override List<Alien> attack(Warrior w, AlienArmy army) {
        ArrayList<Alien> attackers = new ArrayList<>();
        
        List<Alien> alive = army.getAliveAliens();
        
        int i = 0; 
        while (i < alive.size()) { 
            Alien tmp = alive.get(i);
            attackers.add(tmp);
            i++;
        }
        
        
        double hidden = w.getVisibility();
        double multi = hidden / 100;
        double anti = 1 - multi; 
        int bad = 0;
        
        if (attackers.size() > 0) { 
            bad = (int)(attackers.size() * anti);
        }
        
        if (bad == 0 && attackers.size() > 0) 
            bad = 1;
        
        
        
        w.decreasePower(bad);
        
        w.decreaseVisibility(10);
        
        String out = "Η στρατιά εξωγήινων πραγματοποίησε ΠΛΗΡΗ επίθεση με " + 
                attackers.size() + " εξωγήινους!";
        System.out.println(out);
        out = "Ο πολεμιστής έχασε " + bad + " πόντους ισχύος.";
        System.out.println(out);
        
        
        
        if (showDebug)
            print_debug(bad);
        
        return attackers;
    }
    
    void print_debug(int dmg) { 
        System.out.println("DBG: επίθεση με ζημιά " + dmg); 
    }
}