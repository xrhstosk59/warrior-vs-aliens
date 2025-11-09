package gr.university.warriorgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Full attack strategy for the alien army.
 * <p>
 * In a full attack, all living aliens participate in the assault.
 * The damage dealt depends on the warrior's visibility - lower visibility
 * means the warrior cannot defend well, taking more damage.
 * </p>
 */
public class FullAttackStrategy implements AlienAttackStrategy {
    private final Scanner scanner;

    private static final int VISIBILITY_REDUCTION = 10;

    /**
     * Constructs a FullAttackStrategy.
     *
     * @param scanner scanner for potential user input (unused in this strategy)
     */
    public FullAttackStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Alien> attack(Warrior warrior, AlienArmy alienArmy) {
        List<Alien> attackers = new ArrayList<>();
        List<Alien> aliveAliens = alienArmy.getAliveAliens();

        // All alive aliens participate
        attackers.addAll(aliveAliens);

        // Calculate damage based on warrior's visibility
        // Lower visibility = more damage taken
        int visibility = warrior.getVisibility();
        double visibilityFactor = visibility / 100.0;
        double vulnerabilityFactor = 1.0 - visibilityFactor;

        int damage = 0;
        if (!attackers.isEmpty()) {
            damage = (int) (attackers.size() * vulnerabilityFactor);
            // Ensure at least 1 damage if there are attackers
            if (damage == 0) {
                damage = 1;
            }
        }

        // Apply damage and visibility reduction
        warrior.decreasePower(damage);
        warrior.decreaseVisibility(VISIBILITY_REDUCTION);

        System.out.println("Η στρατιά εξωγήινων πραγματοποίησε ΠΛΗΡΗ επίθεση με " +
                         attackers.size() + " εξωγήινους!");
        System.out.println("Ο πολεμιστής έχασε " + damage + " πόντους ισχύος.");

        return attackers;
    }
}
