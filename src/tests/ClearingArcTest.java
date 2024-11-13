package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import petrinet.Place;
import petrinet.ClearingArc;

public class ClearingArcTest {
	private Place place;
	private ClearingArc clearingArc;
	
	@BeforeEach
	void setUp() {
		// Initializes the Place with a certain number of tokens
		place = new Place(5);
		// Initializes ClearingArc with associated place
		clearingArc = new ClearingArc(place);
	}
	
	@Test
	@Order(1)
	void testInitialization() {
		// Checks that the weight is always 1 in an ClearingArc
		assertEquals(1, clearingArc.getWeight());
		assertEquals(place, clearingArc.getPlace());
	}
	
	@Test
	@Order(2)
	void testCanStepWithTokens() {
		// Checks that canStep() returns true when the place has tokens.
		assertTrue(clearingArc.canStep());
	}
	
	@Test
	@Order(3)
	void testCanStepWithoutTokens() {
		// Removes all tokens from the place to make it empty and checks that canStep() returns false when the place has no tokens..
		place.removeToken(5);
		assertFalse(clearingArc.canStep());
	}
	
	@Test
	@Order(4)
	void testStepRemoveTokens() {
		// Step and check that the step remove every token
		clearingArc.step();
		assertEquals(0, place.getToken());
	}
}
