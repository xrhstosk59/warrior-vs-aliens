package gr.university.warriorgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Satellite observer that monitors alien attacks.
 * <p>
 * The satellite can detect aliens during partial attacks.
 * It detects approximately half of the attacking aliens.
 * </p>
 */
public class Satellite implements Observer {
    private final List<Alien> detectedAliens;

    /**
     * Constructs a new Satellite observer.
     */
    public Satellite() {
        this.detectedAliens = new ArrayList<>();
    }

    @Override
    public void update(List<Alien> attackingAliens, boolean isFullAttack) {
        detectedAliens.clear();

        // Satellite only detects aliens during partial attacks
        if (!isFullAttack) {
            int halfCount = (attackingAliens.size() + 1) / 2;
            int detected = Math.min(halfCount, attackingAliens.size());

            for (int i = 0; i < detected; i++) {
                detectedAliens.add(attackingAliens.get(i));
            }

            System.out.println("Ο δορυφόρος εντόπισε " + detectedAliens.size() +
                             " εξωγήινους κατά τη μερική επίθεση.");
        }
    }

    @Override
    public List<Alien> getObservedAliens() {
        return Collections.unmodifiableList(new ArrayList<>(detectedAliens));
    }
}
