import java.util.*;

class Telescope implements Observer 
{
    private ArrayList<Alien> aliensDetected;
    
    Telescope() 
    {
        aliensDetected = new ArrayList<>();
    }
    
    @Override
    public void update(List<Alien> attackingAliens, boolean isFullAttack) 
    {
        aliensDetected.clear();
        
        if (isFullAttack) {
            for (Alien alien : attackingAliens) {
                aliensDetected.add(alien);
            }
            
            String message = "Το τηλεσκόπιο εντόπισε ";
            message += String.valueOf(aliensDetected.size());
            message += " εχθρικούς εξωγήινους στην ολική επίθεση.";
            System.out.println(message);
        }
    }
    
    @Override
    public List<Alien> getObservedAliens() 
    {
        return new ArrayList<>(aliensDetected);
    }
}