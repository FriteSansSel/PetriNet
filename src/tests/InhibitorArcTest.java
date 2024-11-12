package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import petrinet.Place;
import petrinet.InhibitorArc;

public class InhibitorArcTest {
	private Place place;
    private InhibitorArc inhibitorArc;

    @BeforeEach
    void setUp() {
        // Initializes the Place with a certain number of tokens
        place = new Place(5);
        // Initializes InhibitorArc with associated square
        inhibitorArc = new InhibitorArc(place);
    }

    @Test
    @Order(1)
    void testInitialization() {
        // Checks that the weight is always 0 in an InhibitorArc
        assertEquals(0, inhibitorArc.weight);
        assertEquals(place, inhibitorArc.place);
    }

    @Test
    @Order(2)
    void testCanStepWithTokens() {
        // Checks that canStep() returns false when tokens are present in the place
        assertFalse(inhibitorArc.canStep());
    }

    @Test
    @Order(3)
    void testCanStepWithoutTokens() {
        // Empty the place so that the number of tokens is 0
        place.removeToken(5);
        // Checks that canStep() returns true when empty
        assertTrue(inhibitorArc.canStep());
    }

    @Test
    @Order(4)
    void testStepDoesNothing() {
        // Call step() and check that the number of tokens remains unchanged
        inhibitorArc.step();
        assertEquals(5, place.getToken());
    }
}
