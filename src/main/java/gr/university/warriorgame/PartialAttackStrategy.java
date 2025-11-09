package gr.university.warriorgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Partial attack strategy for the alien army.
 * <p>
 * In a partial attack, the user selects how many aliens will attack.
 * This deals less damage than a full attack but may be harder to detect.
 * The damage calculation considers both the number of attackers and
 * the warrior's visibility.
 * </p>
 */
public class PartialAttackStrategy implements AlienAttackStrategy {
    private final Scanner scanner;

    private static final int VISIBILITY_REDUCTION = 5;
    private static final int DAMAGE_DIVISOR = 200;

    /**
     * Constructs a PartialAttackStrategy.
     *
     * @param scanner scanner for reading user input
     */
    public PartialAttackStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Alien> attack(Warrior warrior, AlienArmy alienArmy) {
        List<Alien> attackers = new ArrayList<>();
        List<Alien> aliveAliens = alienArmy.getAliveAliens();

        int maxAliens = aliveAliens.size();
        if (maxAliens <= 0) {
            return attackers;
        }

        // Ask user how many aliens should attack
        int numberOfAttackers = readNumberOfAttackers(maxAliens);

        // Select the specified number of aliens
        for (int i = 0; i < numberOfAttackers; i++) {
            attackers.add(aliveAliens.get(i));
        }

        // Calculate damage based on attackers and visibility
        int visibility = warrior.getVisibility();
        int damage = attackers.size() * (100 - visibility) / DAMAGE_DIVISOR;

        // Ensure at least 1 damage
        if (damage < 1) {
            damage = 1;
        }

        // Apply damage and visibility reduction
        warrior.decreasePower(damage);
        warrior.decreaseVisibility(VISIBILITY_REDUCTION);

        System.out.println("Η στρατιά εξωγήινων πραγματοποίησε ΜΕΡΙΚΗ επίθεση με " +
                         attackers.size() + " εξωγήινους!");
        System.out.println("Ο πολεμιστής έχασε " + damage + " πόντους ισχύος.");

        return attackers;
    }

    /**
     * Reads the number of attacking aliens from user input with validation.
     *
     * @param maxAliens maximum number of aliens available
     * @return number of aliens to attack (1 to maxAliens)
     */
    private int readNumberOfAttackers(int maxAliens) {
        System.out.print("Πόσοι εχθροί θα επιτεθούν; (1-" + maxAliens + "): ");

        while (true) {
            try {
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                if (number >= 1 && number <= maxAliens) {
                    return number;
                } else {
                    System.out.println("Παρακαλώ εισάγετε αριθμό από 1 έως " + maxAliens + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη έγκυρη είσοδος! Παρακαλώ εισάγετε αριθμό.");
            }
        }
    }
}
