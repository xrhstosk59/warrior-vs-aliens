package gr.university.warriorgame;

import java.util.List;

/**
 * Observer interface from the Observer design pattern.
 * <p>
 * Observers monitor subjects and respond to state changes.
 * In this game, Satellite and Telescope act as observers that
 * detect alien attacks and help the warrior target enemies.
 * </p>
 */
public interface Observer {

    /**
     * Called when the subject (AlienArmy) performs an attack.
     * Observers can detect and track attacking aliens.
     *
     * @param attackingAliens the list of aliens participating in the attack
     * @param isFullAttack    true if this is a full attack, false for partial
     */
    void update(List<Alien> attackingAliens, boolean isFullAttack);

    /**
     * Gets the list of aliens that this observer has detected.
     *
     * @return list of detected aliens
     */
    List<Alien> getObservedAliens();
}
