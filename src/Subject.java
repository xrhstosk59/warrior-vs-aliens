import java.util.List;

public interface Subject { 
    void notifyObservers(List<Alien> attackingAliens, boolean isFullAttack); 
    void registerObserver(Observer observer); 
    void removeObserver(Observer observer); 
}