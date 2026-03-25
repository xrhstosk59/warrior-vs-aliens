package gr.university.warriorgame;

import java.util.Scanner;

/**
 * Main game controller that manages the flow of the battle between the warrior and aliens.
 * <p>
 * This class handles:
 * <ul>
 *   <li>Game initialization</li>
 *   <li>Turn-based gameplay (warrior attacks on odd rounds, aliens on even rounds)</li>
 *   <li>Victory/defeat conditions</li>
 *   <li>User interaction and status display</li>
 * </ul>
 * </p>
 */
public class Game {
    private Warrior warrior;
    private AlienArmy alienArmy;
    private Satellite satellite;
    private Telescope telescope;
    private final Scanner scanner;
    private int currentRound;
    private int totalAliens;

    private static final int INITIAL_WARRIOR_POWER = 100;
    private static final int INITIAL_WARRIOR_VISIBILITY = 50;
    private static final String SEPARATOR = "----------";

    /**
     * Constructs a new Game instance and initializes all components.
     */
    public Game() {
        this.scanner = new Scanner(System.in);
        this.currentRound = 1;
    }

    /**
     * Initializes the game components including observers, warrior, and alien army.
     */
    private void initialize() {
        // Create observers
        satellite = new Satellite();
        telescope = new Telescope();

        // Create warrior with default strategy
        warrior = new Warrior(INITIAL_WARRIOR_POWER, INITIAL_WARRIOR_VISIBILITY,
                             new DefaultWarriorStrategy());

        // Get number of aliens from user
        printNewLine();
        int numberOfAliens = readNumberOfAliens();

        totalAliens = numberOfAliens;
        alienArmy = new AlienArmy(numberOfAliens, scanner);
        alienArmy.registerObserver(satellite);
        alienArmy.registerObserver(telescope);

        // Display initial game state
        printNewLine();
        System.out.println("=== ΜΑΧΗ ===");
        System.out.println("HP Πολεμιστή: " + warrior.getPower());
        System.out.println("Ορατότητα: " + warrior.getVisibility() + "%");
        System.out.println("Εχθροί: " + numberOfAliens);
    }

    /**
     * Reads the number of aliens from user input with validation.
     *
     * @return the number of aliens (must be positive)
     */
    private int readNumberOfAliens() {
        System.out.println("Πόσοι εχθροί θα σας επιτεθούν;");

        while (true) {
            try {
                if (!scanner.hasNextLine()) {
                    throw new InputUnavailableException("Δεν δόθηκε αριθμός εχθρών.");
                }

                int number = Integer.parseInt(scanner.nextLine());

                if (number <= 0) {
                    System.out.println("Παρακαλώ εισάγετε έναν θετικό αριθμό!");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Μη έγκυρη είσοδος! Παρακαλώ εισάγετε έναν αριθμό.");
            }
        }
    }

    /**
     * Prints a blank line for better readability.
     */
    private void printNewLine() {
        System.out.println();
    }

    /**
     * Executes a single round of the game.
     *
     * @return true if the game should continue, false if the game is over
     */
    private boolean executeRound() {
        printNewLine();
        System.out.println(SEPARATOR + " ΓΥΡΟΣ " + currentRound + " " + SEPARATOR);
        printNewLine();

        displayStatistics();

        // Odd rounds: warrior attacks
        if (currentRound % 2 == 1) {
            System.out.println(">> Επίθεση πολεμιστή");
            warrior.attack(alienArmy, satellite, telescope);

            if (alienArmy.isDefeated()) {
                System.out.println(">> Νίκη! Όλοι οι εχθροί καταστράφηκαν! :)");
                return false;
            }
        }
        // Even rounds: aliens attack
        else {
            System.out.println(">> Επιτίθενται οι εχθροί...");
            alienArmy.attack(warrior);

            if (warrior.isDefeated()) {
                System.out.println(">> Ήττα! Ο πολεμιστής ηττήθηκε... :(");
                return false;
            }
        }

        currentRound++;
        return true;
    }

    /**
     * Displays current game statistics including warrior status and remaining enemies.
     */
    private void displayStatistics() {
        int power = warrior.getPower();
        int visibility = warrior.getVisibility();

        // Warrior status with health indicator
        String healthStatus;
        if (power > 75) {
            healthStatus = "Άψογα!";
        } else if (power > 40) {
            healthStatus = "Καλά";
        } else {
            healthStatus = "ΚΙΝΔΥΝΟΣ!";
        }

        System.out.println("Πολεμιστής: " + power + " HP | " + visibility + "% ορατότητα | " + healthStatus);

        // Enemy status
        int remainingAliens = alienArmy.getAliveCount();

        if (remainingAliens > 0) {
            String alienStatus;
            if (remainingAliens > totalAliens / 2) {
                alienStatus = "Πολλοί εχθροί ακόμα...";
            } else {
                alienStatus = "Τους τρέχουμε!";
            }

            System.out.println("Εχθροί: " + remainingAliens + " από " + totalAliens + " | " + alienStatus);
        }
    }

    /**
     * Main game loop that executes rounds until victory or defeat.
     */
    public void play() {
        try {
            initialize();

            boolean continueGame = true;

            while (continueGame) {
                continueGame = executeRound();

                if (continueGame) {
                    System.out.println("\nΠατήστε Enter για να συνεχίσετε...");
                    if (!scanner.hasNextLine()) {
                        throw new InputUnavailableException("Η ροή εισόδου τερματίστηκε.");
                    }
                    scanner.nextLine();
                }
            }
        } catch (InputUnavailableException e) {
            printNewLine();
            System.out.println(">> Η είσοδος τερματίστηκε. Η μάχη ολοκληρώνεται ομαλά.");
        } finally {
            printNewLine();
            System.out.println("### ΤΕΛΟΣ ΜΑΧΗΣ ###");
            if (warrior != null && alienArmy != null) {
                displayStatistics();
            }
            scanner.close();
        }
    }
}
