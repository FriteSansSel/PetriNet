package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import petrinet.InArc;
import petrinet.PetriNet;
import petrinet.Place;
import petrinet.Transition;

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
		assertEquals(0, petriNet.getPlaces().size());

		// Add a place with 5 tokens
		petriNet.addPlace(5);

		// Verify that one place has been added to the PetriNet
		assertEquals(1, petriNet.getPlaces().size());
		assertEquals(5, petriNet.getPlaces().get(0).getToken());
	}

	@Test
	@Order(2)
	void testAddTransition() {
		// Ensure that the PetriNet starts with no transitions
		assertEquals(0, petriNet.getTransitions().size());

		// Add a transition
		petriNet.addTransition();

		// Verify that one transition has been added to the PetriNet
		assertEquals(1, petriNet.getTransitions().size());
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
		assertEquals(2, petriNet.getPlaces().size());
		assertEquals(2, petriNet.getTransitions().size());

		// Verify the number of tokens in the first and second place
		assertEquals(3, petriNet.getPlaces().get(0).getToken());
		assertEquals(2, petriNet.getPlaces().get(1).getToken());
	}
	@Test
	@Order(4)
	void testRemoveTransition() {
		Transition t1=petriNet.addTransition();
		petriNet.removeTransition(t1);
		assertEquals(petriNet.getTransitions().size(),0);

	}


	@Test
	@Order(5)
	void testRemovePlace() {
		Place p1=petriNet.addPlace(3);
		Transition t1=petriNet.addTransition();
		petriNet.addArcIn(t1, 2, p1);
		petriNet.addArcOut(t1, 3, p1);
		petriNet.removePlace(p1);
		assertEquals(petriNet.getPlaces().size(),0);
		assertEquals(t1.getInArcs().size(), 0);
		assertEquals(t1.getOutArcs().size(),0);
	}

	@Test
	@Order(6)
	void testRemoveArcIn() {
		Place p1=petriNet.addPlace(3);
		Transition t1=petriNet.addTransition();
		petriNet.addArcIn(t1, 2, p1);
		petriNet.removeArcIn(t1, p1);
		assertEquals(t1.getInArcs().size(), 0);
	}

	@Test
	@Order(7)
	void testRemoveArcOut() {
		Place p1=petriNet.addPlace(3);
		Transition t1=petriNet.addTransition();
		petriNet.addArcOut(t1, 2, p1);
		petriNet.removeArcOut(t1, p1);
		assertEquals(t1.getOutArcs().size(), 0);

	}
	@Test
	@Order(8)
	void testTrigger() {
		Place p1=petriNet.addPlace(3);
		Place p2=petriNet.addPlace(2);
		Transition t1=petriNet.addTransition();
		petriNet.addArcIn(t1, 2, p1);
		petriNet.addArcOut(t1, 3, p2);
		petriNet.trigger(t1);
		assertEquals(1,p1.getToken());
		assertEquals(5,p2.getToken());
	}

}
