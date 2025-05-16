import java.util.*;

class Satellite implements Observer 
{
    private ArrayList<Alien> detectedAliens;
    private boolean debugFlag = false;
    
    Satellite() 
    {
        detectedAliens = new ArrayList<>();
    }
    
    @Override
    public void update(List<Alien> attackingAliens, boolean isFullAttack) 
    {
        detectedAliens.clear();
        
        if (!isFullAttack) {
            int half = (attackingAliens.size() + 1) / 2;
            
            int counter = 0;
            while (counter < attackingAliens.size() && counter < half) {
                detectedAliens.add(attackingAliens.get(counter));
                counter++;
            }
            
            StringBuilder output = new StringBuilder();
            output.append("Ο δορυφόρος εντόπισε ");
            
            if (debugFlag) {
                System.err.println("Debug: adding aliens");
            }
            
            output.append(detectedAliens.size());
            output.append(" εξωγήινους");
            output.append(" κατά τη μερική επίθεση.");
            
            System.out.println(output.toString());
        }
    }
    
    void toggleDebug() {
        debugFlag = !debugFlag;
    }
    
    @Override
    public List<Alien> getObservedAliens() 
    {
        return Collections.unmodifiableList(new ArrayList<>(detectedAliens));
    }
}