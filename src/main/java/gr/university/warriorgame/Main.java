package gr.university.warriorgame;

/**
 * Main entry point for the Warrior vs Aliens game.
 * <p>
 * This is a turn-based battle game where a warrior fights against an army of aliens.
 * The game demonstrates the use of Strategy and Observer design patterns.
 * </p>
 *
 * @author University of [Your University] - Computer Science Department
 * @version 1.0
 */
public class Main {

    /**
     * Main method to start the game.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== ΠΑΙΧΝΙΔΙ ΜΑΧΗΣ: ΠΟΛΕΜΙΣΤΗΣ VS ΕΞΩΓΗΙΝΟΙ ===");
        System.out.println("------------------------------------------------");

        Game game = new Game();
        game.play();
    }
}
