package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import petrinet.PetriNet;

public class PetriNetTest {
	private PetriNet petriNet;

    @BeforeEach
    void setUp() {
        // Initialize a new PetriNet before each test
        petriNet = new PetriNet();
    }

    @Test
    @Order(1)
    void testAddPlace() {
        // Ensure that the PetriNet starts with no places
        assertEquals(0, petriNet.places.size());

        // Add a place with 5 tokens
        petriNet.addPlace(5);

        // Verify that one place has been added to the PetriNet
        assertEquals(1, petriNet.places.size());
        assertEquals(5, petriNet.places.get(0).getToken());
    }

    @Test
    @Order(2)
    void testAddTransition() {
        // Ensure that the PetriNet starts with no transitions
        assertEquals(0, petriNet.transitions.size());

        // Add a transition
        petriNet.addTransition();

        // Verify that one transition has been added to the PetriNet
        assertEquals(1, petriNet.transitions.size());
    }

    @Test
    @Order(3)
    void testAddMultiplePlacesAndTransitions() {
        // Add multiple places and transitions
        petriNet.addPlace(3);  // First place with 3 tokens
        petriNet.addPlace(2);  // Second place with 2 tokens
        petriNet.addTransition();  // First transition
        petriNet.addTransition();  // Second transition

        // Verify the number of places and transitions
        assertEquals(2, petriNet.places.size());
        assertEquals(2, petriNet.transitions.size());

        // Verify the number of tokens in the first and second place
        assertEquals(3, petriNet.places.get(0).getToken());
        assertEquals(2, petriNet.places.get(1).getToken());
    }
}
