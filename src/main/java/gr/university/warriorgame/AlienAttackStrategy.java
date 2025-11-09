package gr.university.warriorgame;

import java.util.List;

/**
 * Strategy interface for alien attack behavior.
 * <p>
 * Part of the Strategy design pattern. Different implementations
 * define different attack strategies for the alien army, such as
 * full attacks (all aliens) or partial attacks (selected aliens).
 * </p>
 */
public interface AlienAttackStrategy {

    /**
     * Executes an attack on the warrior.
     *
     * @param warrior   the warrior to attack
     * @param alienArmy the alien army performing the attack
     * @return list of aliens that participated in the attack
     */
    List<Alien> attack(Warrior warrior, AlienArmy alienArmy);
}
