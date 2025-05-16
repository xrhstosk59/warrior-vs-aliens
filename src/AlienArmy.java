import java.util.*;

public class AlienArmy implements Subject 
{
    ArrayList<Alien> aliens;
    List<Observer> observers;
    AlienAttackStrategy attackStrategy;
    Scanner scan;
    int totalKills = 0;
    
    public AlienArmy(int numAliens, Scanner scan) 
    {
        aliens = new ArrayList<>();
        observers = new ArrayList<>();
        this.scan = scan;
        
        for(int i=1;i<=numAliens;i++) 
        {
            aliens.add(new Alien(i));
        }
        
        attackStrategy = new FullAttackStrategy(scan);
    }
    
    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }
    
    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }
    
    @Override
    public void notifyObservers(List<Alien> attackingAliens, boolean isFullAttack) 
    {
        for(Observer o : observers) 
        {
            o.update(attackingAliens, isFullAttack);
        }
    }
    
    public void attack(Warrior w) 
    {
        pickStrategy();
        
        List<Alien> attackers = attackStrategy.attack(w, this);
        
        boolean fullAttack = attackStrategy instanceof FullAttackStrategy;
        notifyObservers(attackers, fullAttack);
    }
    
    private void pickStrategy() 
    {
        System.out.println("\nΔιάλεξε επίθεση εξωγήινων:");
        System.out.println("1. Ολική επίθεση");
        System.out.println("2. Μερική επίθεση");
        
        int choice;
        while(true) 
        {
            try {
                String inp = scan.nextLine();
                choice = Integer.parseInt(inp);
                
                if(choice==1) {
                    attackStrategy = new FullAttackStrategy(scan);
                    break;
                } 
                else if(choice==2) {
                    attackStrategy = new PartialAttackStrategy(scan);
                    break;
                } 
                else {
                    System.out.println("Βάλε 1 ή 2!");
                }
            } 
            catch(Exception e) {
                System.out.println("Δώσε σωστό αριθμό!");
            }
        }
    }
    
    public List<Alien> getAliens() 
    {
        return new ArrayList<>(aliens);
    }
    
    public List<Alien> getAliveAliens() 
    {
        ArrayList<Alien> alive = new ArrayList<>();
        
        for(Alien a : aliens) 
        {
            if(a.isAlive()==true) {
                alive.add(a);
            }
        }
        
        return alive;
    }
    
    public int getAliveCount() 
    {
        return getAliveAliens().size();
    }
    
    public boolean isDefeated() 
    {
        return getAliveCount()==0;
    }
}