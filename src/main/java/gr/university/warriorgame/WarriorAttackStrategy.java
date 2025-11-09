package gr.university.warriorgame;

/**
 * Strategy interface for warrior attack behavior.
 * <p>
 * Part of the Strategy design pattern. Different implementations
 * can define different attack behaviors for the warrior.
 * </p>
 */
public interface WarriorAttackStrategy {

    /**
     * Executes an attack on the alien army.
     * <p>
     * The strategy uses information from observers (Satellite and Telescope)
     * to determine which aliens to target.
     * </p>
     *
     * @param alienArmy the alien army to attack
     * @param satellite the satellite observer
     * @param telescope the telescope observer
     */
    void attack(AlienArmy alienArmy, Satellite satellite, Telescope telescope);
}
