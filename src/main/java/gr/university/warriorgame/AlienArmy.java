package gr.university.warriorgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents an army of aliens that can attack the warrior.
 * <p>
 * Implements the Subject interface from the Observer pattern.
 * The army can notify observers (Satellite and Telescope) when attacks occur.
 * Uses the Strategy pattern to vary attack behavior.
 * </p>
 */
public class AlienArmy implements Subject {
    private final List<Alien> aliens;
    private final List<Observer> observers;
    private final Scanner scanner;
    private AlienAttackStrategy attackStrategy;

    /**
     * Constructs an AlienArmy with the specified number of aliens.
     *
     * @param numberOfAliens the number of aliens in the army
     * @param scanner        scanner for user input
     */
    public AlienArmy(int numberOfAliens, Scanner scanner) {
        this.aliens = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.scanner = scanner;

        // Create all aliens
        for (int i = 1; i <= numberOfAliens; i++) {
            aliens.add(new Alien(i));
        }

        // Set default attack strategy
        this.attackStrategy = new FullAttackStrategy();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(List<Alien> attackingAliens, boolean isFullAttack) {
        for (Observer observer : observers) {
            observer.update(attackingAliens, isFullAttack);
        }
    }

    /**
     * Executes an attack on the warrior.
     * Prompts the user to select attack strategy, then notifies observers.
     *
     * @param warrior the warrior to attack
     */
    public void attack(Warrior warrior) {
        selectAttackStrategy();

        List<Alien> attackers = attackStrategy.attack(warrior, this);

        boolean isFullAttack = attackStrategy instanceof FullAttackStrategy;
        notifyObservers(attackers, isFullAttack);
    }

    /**
     * Prompts the user to select an attack strategy.
     */
    private void selectAttackStrategy() {
        System.out.println("\nΕπιλέξτε τύπο επίθεσης εξωγήινων:");
        System.out.println("1. Ολική επίθεση");
        System.out.println("2. Μερική επίθεση");

        while (true) {
            try {
                if (!scanner.hasNextLine()) {
                    throw new InputUnavailableException("Δεν επιλέχθηκε τύπος επίθεσης.");
                }

                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);

                if (choice == 1) {
                    attackStrategy = new FullAttackStrategy();
                    break;
                } else if (choice == 2) {
                    attackStrategy = new PartialAttackStrategy(scanner);
                    break;
                } else {
                    System.out.println("Παρακαλώ επιλέξτε 1 ή 2!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη έγκυρη είσοδος! Παρακαλώ εισάγετε αριθμό.");
            }
        }
    }

    /**
     * Gets all aliens in the army (both alive and dead).
     *
     * @return a copy of the aliens list
     */
    public List<Alien> getAllAliens() {
        return new ArrayList<>(aliens);
    }

    /**
     * Gets only the aliens that are still alive.
     *
     * @return list of alive aliens
     */
    public List<Alien> getAliveAliens() {
        List<Alien> aliveAliens = new ArrayList<>();

        for (Alien alien : aliens) {
            if (alien.isAlive()) {
                aliveAliens.add(alien);
            }
        }

        return aliveAliens;
    }

    /**
     * Gets the count of aliens still alive.
     *
     * @return number of alive aliens
     */
    public int getAliveCount() {
        return getAliveAliens().size();
    }

    /**
     * Checks if the entire army has been defeated.
     *
     * @return true if no aliens are alive, false otherwise
     */
    public boolean isDefeated() {
        return getAliveCount() == 0;
    }
}
