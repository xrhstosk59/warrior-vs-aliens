package gr.university.warriorgame;

/**
 * Signals that the interactive input stream ended before the game
 * received the data it needed to continue.
 */
public class InputUnavailableException extends RuntimeException {

    /**
     * Creates a new exception with a human-readable explanation.
     *
     * @param message details about the missing input
     */
    public InputUnavailableException(String message) {
        super(message);
    }
}
