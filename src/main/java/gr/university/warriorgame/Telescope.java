package gr.university.warriorgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescope observer that monitors alien attacks.
 * <p>
 * The telescope can detect all aliens during full attacks.
 * </p>
 */
public class Telescope implements Observer {
    private final List<Alien> detectedAliens;

    /**
     * Constructs a new Telescope observer.
     */
    public Telescope() {
        this.detectedAliens = new ArrayList<>();
    }

    @Override
    public void update(List<Alien> attackingAliens, boolean isFullAttack) {
        detectedAliens.clear();

        // Telescope only detects aliens during full attacks
        if (isFullAttack) {
            detectedAliens.addAll(attackingAliens);

            System.out.println("Το τηλεσκόπιο εντόπισε " + detectedAliens.size() +
                             " εχθρικούς εξωγήινους στην ολική επίθεση.");
        }
    }

    @Override
    public List<Alien> getObservedAliens() {
        return new ArrayList<>(detectedAliens);
    }
}
