package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import petrinet.Place;
import petrinet.InArc;

public class InArcTest {
	private Place place;
    private InArc inArc;

    @BeforeEach
    void setUp() {
        // Initializes Place object with 5 tokens
        place = new Place(5);
        // Initializes InArc with a weight of 3 and the associated square
        inArc = new InArc(3, place);
    }

    @Test
    void testInitialization() {
        // Checks that weight and place are correctly initialized
        assertEquals(3, inArc.weight);
        assertEquals(place, inArc.place);
    }

    @Test
    void testCanStepTrue() {
        // Checks that canStep() returns true when tokens are sufficient
        assertTrue(inArc.canStep());
    }

    @Test
    void testCanStepFalse() {
        // Modifies the number of tokens in place to be insufficient for canStep()
        place.removeToken(4);
        assertFalse(inArc.canStep());
    }

    @Test
    void testStep() {
        // Calls step() to remove tokens and check that the place has been updated
        inArc.step();
        assertEquals(2, place.getToken());
    }

    @Test
    void testStepWithoutEnoughTokens() {
        // Try a step without sufficient tokens, and check that the number of tokens remains unchanged.
        place.removeToken(4);
        inArc.step();
        assertEquals(1, place.getToken());
    }
}
