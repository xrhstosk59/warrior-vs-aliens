package gr.university.warriorgame;

import java.util.List;

/**
 * Subject interface from the Observer design pattern.
 * <p>
 * Subjects maintain a list of observers and notify them of state changes.
 * In this game, the AlienArmy acts as a subject that notifies observers
 * when attacks occur.
 * </p>
 */
public interface Subject {

    /**
     * Notifies all registered observers about an alien attack.
     *
     * @param attackingAliens the list of aliens participating in the attack
     * @param isFullAttack    true if this is a full attack, false for partial
     */
    void notifyObservers(List<Alien> attackingAliens, boolean isFullAttack);

    /**
     * Registers an observer to receive notifications.
     *
     * @param observer the observer to register
     */
    void registerObserver(Observer observer);

    /**
     * Removes an observer from the notification list.
     *
     * @param observer the observer to remove
     */
    void removeObserver(Observer observer);
}
