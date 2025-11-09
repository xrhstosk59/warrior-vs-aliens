package gr.university.warriorgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Warrior class.
 */
class WarriorTest {

    private Warrior warrior;
    private WarriorAttackStrategy mockStrategy;

    @BeforeEach
    void setUp() {
        mockStrategy = new DefaultWarriorStrategy();
        warrior = new Warrior(100, 50, mockStrategy);
    }

    @Test
    void testWarriorCreation() {
        assertEquals(100, warrior.getPower());
        assertEquals(50, warrior.getVisibility());
        assertFalse(warrior.isDefeated());
    }

    @Test
    void testDecreasePower() {
        warrior.decreasePower(30);
        assertEquals(70, warrior.getPower());
        assertFalse(warrior.isDefeated());
    }

    @Test
    void testDecreasePowerBelowZero() {
        warrior.decreasePower(150);
        assertEquals(0, warrior.getPower());
        assertTrue(warrior.isDefeated());
    }

    @Test
    void testDecreaseVisibility() {
        warrior.decreaseVisibility(20);
        assertEquals(30, warrior.getVisibility());
    }

    @Test
    void testDecreaseVisibilityBelowZero() {
        warrior.decreaseVisibility(100);
        assertEquals(0, warrior.getVisibility());
    }

    @Test
    void testIncreaseVisibility() {
        warrior.increaseVisibility(30);
        assertEquals(80, warrior.getVisibility());
    }

    @Test
    void testIncreaseVisibilityAbove100() {
        warrior.increaseVisibility(60);
        assertEquals(100, warrior.getVisibility());
    }

    @Test
    void testIsDefeated() {
        assertFalse(warrior.isDefeated());

        warrior.decreasePower(100);
        assertTrue(warrior.isDefeated());
    }

    @Test
    void testSetAttackStrategy() {
        WarriorAttackStrategy newStrategy = new DefaultWarriorStrategy();
        warrior.setAttackStrategy(newStrategy);
        // No exception should be thrown
        assertNotNull(warrior);
    }
}
