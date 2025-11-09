package gr.university.warriorgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Alien class.
 */
class AlienTest {

    @Test
    void testAlienCreation() {
        Alien alien = new Alien(1);
        assertEquals(1, alien.getId());
        assertTrue(alien.isAlive());
    }

    @Test
    void testAlienDestroy() {
        Alien alien = new Alien(5);
        assertTrue(alien.isAlive());

        alien.destroy();
        assertFalse(alien.isAlive());
    }

    @Test
    void testAlienToString() {
        Alien alien = new Alien(3);
        assertTrue(alien.toString().contains("3"));
        assertTrue(alien.toString().contains("ζωντανός"));

        alien.destroy();
        assertTrue(alien.toString().contains("νεκρός"));
    }

    @Test
    void testMultipleDestroyCalls() {
        Alien alien = new Alien(2);
        alien.destroy();
        alien.destroy(); // Should not throw exception
        assertFalse(alien.isAlive());
    }
}
