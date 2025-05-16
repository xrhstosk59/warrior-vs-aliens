public class Alien 
{
    private int id; 
    private boolean alive;
    
    public Alien(int id) 
    {
        this.id = id;
        alive = true;
    }
    
    public int getId() 
    {
        return id;
    }
    
    public boolean isAlive() 
    {
        return alive;
    }
    
    public void destroy() 
    {
        alive = false;
    }
    
    @Override
    public String toString() 
    {
        if (alive) {
            return "Εξωγήινος " + id + " (ζωντανός)";
        } else {
            return "Εξωγήινος " + id + " (νεκρός)";
        }
    }
}