package gr.university.warriorgame;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

/**
 * Integration tests for graceful handling of exhausted stdin.
 */
class GameInputHandlingTest {

    @Test
    void testGameExitsGracefullyWhenInputEndsAfterFirstRound() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream("2\n".getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            assertDoesNotThrow(() -> new Game().play());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        String console = output.toString(StandardCharsets.UTF_8);
        assertTrue(console.contains("Η είσοδος τερματίστηκε"));
        assertTrue(console.contains("### ΤΕΛΟΣ ΜΑΧΗΣ ###"));
    }
}
