import java.util.List;

public interface Observer {
    void update(List<Alien> attackingAliens, boolean isFullAttack);
    List<Alien> getObservedAliens();
}