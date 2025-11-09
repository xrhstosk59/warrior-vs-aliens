package gr.university.warriorgame;

/**
 * Represents a single alien enemy in the game.
 * <p>
 * Each alien has a unique ID and can be either alive or destroyed.
 * </p>
 */
public class Alien {
    private final int id;
    private boolean alive;

    /**
     * Constructs a new Alien with the specified ID.
     * The alien starts in the alive state.
     *
     * @param id unique identifier for this alien
     */
    public Alien(int id) {
        this.id = id;
        this.alive = true;
    }

    /**
     * Gets the unique ID of this alien.
     *
     * @return the alien's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Checks if the alien is still alive.
     *
     * @return true if alive, false if destroyed
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Destroys this alien, setting its state to dead.
     */
    public void destroy() {
        this.alive = false;
    }

    /**
     * Returns a string representation of the alien.
     *
     * @return string describing the alien's ID and state
     */
    @Override
    public String toString() {
        return alive
            ? "Εξωγήινος " + id + " (ζωντανός)"
            : "Εξωγήινος " + id + " (νεκρός)";
    }
}
