package gr.university.warriorgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Observer pattern implementation.
 */
class ObserverPatternTest {

    private Satellite satellite;
    private Telescope telescope;

    @BeforeEach
    void setUp() {
        satellite = new Satellite();
        telescope = new Telescope();
    }

    @Test
    void testSatelliteDetectsPartialAttack() {
        List<Alien> attackers = createAlienList(4);

        satellite.update(attackers, false);

        List<Alien> detected = satellite.getObservedAliens();
        assertEquals(2, detected.size()); // Should detect half
    }

    @Test
    void testSatelliteIgnoresFullAttack() {
        List<Alien> attackers = createAlienList(4);

        satellite.update(attackers, true);

        List<Alien> detected = satellite.getObservedAliens();
        assertEquals(0, detected.size()); // Should not detect full attacks
    }

    @Test
    void testTelescopeDetectsFullAttack() {
        List<Alien> attackers = createAlienList(5);

        telescope.update(attackers, true);

        List<Alien> detected = telescope.getObservedAliens();
        assertEquals(5, detected.size()); // Should detect all
    }

    @Test
    void testTelescopeIgnoresPartialAttack() {
        List<Alien> attackers = createAlienList(5);

        telescope.update(attackers, false);

        List<Alien> detected = telescope.getObservedAliens();
        assertEquals(0, detected.size()); // Should not detect partial attacks
    }

    @Test
    void testObserversClearPreviousDetections() {
        List<Alien> firstAttack = createAlienList(3);
        List<Alien> secondAttack = createAlienList(2);

        satellite.update(firstAttack, false);
        assertEquals(2, satellite.getObservedAliens().size());

        satellite.update(secondAttack, false);
        assertEquals(1, satellite.getObservedAliens().size());
    }

    private List<Alien> createAlienList(int count) {
        List<Alien> aliens = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            aliens.add(new Alien(i));
        }
        return aliens;
    }
}
