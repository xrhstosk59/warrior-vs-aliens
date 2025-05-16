import java.util.*;

public class PartialAttackStrategy implements AlienAttackStrategy {
    Scanner s;
    int tmpVal = 0;
    boolean dbg = false;
    
    public PartialAttackStrategy(Scanner scnr) {
        s = scnr;
    }
    
    @Override
    public List<Alien> attack(Warrior w, AlienArmy army) {
        ArrayList<Alien> epith = new ArrayList<>();
        List<Alien> zontanoi = army.getAliveAliens();
        
        int max = zontanoi.size();
        if (max <= 0) { 
            if(dbg) 
                System.out.println("Δεν βρέθηκαν εχθροί!");
            return epith;
        }
        
        System.out.print("Πόσοι εχθροί επίθεση? (1-" + max + "): ");
        
        int n=0;
        boolean ok = false;
        
        while (!ok) { 
            try {
                String inp = s.nextLine();
                n = Integer.parseInt(inp);
                
                if (n >= 1 && n <= max) {
                    ok = true;
                } else 
                    System.out.println("Λάθος! Από 1 ως " + max);
            } 
            catch (Exception e) 
            {
                System.out.println("Δώσε αριθμό!");
            }
        }
        
        for(int i=0;i<n;i++)
        {
            Alien tmp = zontanoi.get(i);
            epith.add(tmp);
        }
        
        int vis = w.getVisibility();
        int zhmia = epith.size() * (100 - vis) / 200;
        
        if (zhmia < 1) 
            zhmia = 1;
        
        w.decreasePower(zhmia);
        w.decreaseVisibility(5);
        
        String msg = "Η στρατιά εξωγήινων πραγματοποίησε ΜΕΡΙΚΗ επίθεση με " + 
                      epith.size() + " εξωγήινους!";
        System.out.println(msg);
        
        msg = "Ο πολεμιστής έχασε " + zhmia + " πόντους ισχύος.";
        System.out.println(msg);
        
        if(dbg) print_dbg(zhmia);
        
        return epith;
    }
    
    void print_dbg(int z) { 
        System.out.println("DBG: μερική επίθεση με ζημιά " + z); 
    }
}