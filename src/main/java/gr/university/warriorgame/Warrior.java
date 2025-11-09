package gr.university.warriorgame;

/**
 * Represents the warrior character in the game.
 * <p>
 * The warrior has power (health points) and visibility attributes.
 * Uses the Strategy pattern to determine attack behavior.
 * </p>
 */
public class Warrior {
    private int power;
    private int visibility;
    private WarriorAttackStrategy attackStrategy;

    private static final int MAX_VISIBILITY = 100;
    private static final int MIN_VALUE = 0;

    /**
     * Constructs a new Warrior with specified attributes.
     *
     * @param power          initial power/health points
     * @param visibility     initial visibility percentage (0-100)
     * @param attackStrategy the strategy to use for attacks
     */
    public Warrior(int power, int visibility, WarriorAttackStrategy attackStrategy) {
        this.power = power;
        this.visibility = visibility;
        this.attackStrategy = attackStrategy;
    }

    /**
     * Attacks the alien army using the current attack strategy.
     * Increases visibility after each attack.
     *
     * @param alienArmy the alien army to attack
     * @param satellite the satellite observer
     * @param telescope the telescope observer
     */
    public void attack(AlienArmy alienArmy, Satellite satellite, Telescope telescope) {
        attackStrategy.attack(alienArmy, satellite, telescope);
        increaseVisibility(15);
    }

    /**
     * Gets the current power (health) of the warrior.
     *
     * @return current power value
     */
    public int getPower() {
        return power;
    }

    /**
     * Gets the current visibility percentage.
     *
     * @return visibility percentage (0-100)
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * Decreases the warrior's power by the specified amount.
     * Power cannot go below 0.
     *
     * @param amount the amount to decrease
     */
    public void decreasePower(int amount) {
        this.power -= amount;
        if (this.power < MIN_VALUE) {
            this.power = MIN_VALUE;
        }
    }

    /**
     * Decreases the warrior's visibility by the specified amount.
     * Visibility cannot go below 0.
     *
     * @param amount the amount to decrease
     */
    public void decreaseVisibility(int amount) {
        this.visibility -= amount;
        if (this.visibility < MIN_VALUE) {
            this.visibility = MIN_VALUE;
        }
    }

    /**
     * Increases the warrior's visibility by the specified amount.
     * Visibility cannot exceed 100.
     *
     * @param amount the amount to increase
     */
    public void increaseVisibility(int amount) {
        this.visibility += amount;
        if (this.visibility > MAX_VISIBILITY) {
            this.visibility = MAX_VISIBILITY;
        }
    }

    /**
     * Changes the attack strategy dynamically.
     *
     * @param attackStrategy the new attack strategy to use
     */
    public void setAttackStrategy(WarriorAttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    /**
     * Checks if the warrior has been defeated.
     *
     * @return true if power is 0 or below, false otherwise
     */
    public boolean isDefeated() {
        return power <= MIN_VALUE;
    }
}
