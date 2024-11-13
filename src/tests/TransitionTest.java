package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import petrinet.ClearingArc;
import petrinet.InArc;
import petrinet.InhibitorArc;
import petrinet.OutArc;
import petrinet.Place;
import petrinet.Transition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class TransitionTest {

	Transition transition;
	@BeforeEach
	void setUp() {
		Transition.setIdCount(0);
		transition=new Transition();
	}

	@Test
	@Order(1)
	public void testConstructor() {
		assertEquals(transition.getId(),0);
		assertNotNull(transition.getInArcs());
		assertNotNull(transition.getOutArcs());
		assertTrue(transition.getInArcs().isEmpty());
		assertTrue(transition.getOutArcs().isEmpty());
		assertTrue(transition.getInArcs() instanceof ArrayList<InArc>);
		assertTrue(transition.getOutArcs() instanceof ArrayList<OutArc>);
	}
	@Test
	@Order(2)
	void testConstructorId() {
		Transition t2=new Transition();
		Transition t3=new Transition();
		assertEquals(1,t2.getId());
		assertEquals(2,t3.getId());
	}
	@Test
	@Order(3)
	public void testAddArcIn() {
		Place place = new Place(5);
		transition.addArcIn(3, place);
		assertEquals(1, transition.getInArcs().size());
		assertTrue(transition.getInArcs().get(0) instanceof InArc);
		assertEquals(3, transition.getInArcs().get(0).getWeight());
		assertSame(place, transition.getInArcs().get(0).getPlace());
	}
	@Test
	@Order(4)
	public void testAddArcInDuplicate() {
		Place place = new Place(5);
		transition.addArcIn(3, place);
		transition.addArcIn(4, place);
		assertEquals(1, transition.getInArcs().size());
		assertTrue(transition.getInArcs().get(0) instanceof InArc);
		assertEquals(3, transition.getInArcs().get(0).getWeight());
		assertSame(place, transition.getInArcs().get(0).getPlace());
	}
	@Test
	@Order(5)
	public void testAddArcOut() {
		Place place = new Place(5);
		transition.addArcOut(3, place);
		assertEquals(1, transition.getOutArcs().size());
		assertTrue(transition.getOutArcs().get(0) instanceof OutArc);
		assertEquals(3, transition.getOutArcs().get(0).getWeight());
		assertSame(place, transition.getOutArcs().get(0).getPlace());
	}
	@Test
	@Order(6)
	public void testAddArcOutDuplicate() {
		Place place = new Place(5);
		transition.addArcOut(3, place);
		transition.addArcOut(4, place);
		assertEquals(1, transition.getOutArcs().size());
		assertTrue(transition.getOutArcs().get(0) instanceof OutArc);
		assertEquals(3, transition.getOutArcs().get(0).getWeight());
		assertSame(place, transition.getOutArcs().get(0).getPlace());
	}
	@Test
	@Order(7)
	public void testAddArcInhibitor() {
		Place place = new Place(5);
		transition.addArcInhibitor(place);
		assertEquals(1, transition.getInArcs().size());
		assertTrue(transition.getInArcs().get(0) instanceof InhibitorArc);
		assertEquals(0, transition.getInArcs().get(0).getWeight());
		assertSame(place, transition.getInArcs().get(0).getPlace());
	}
	@Test
	@Order(8)
	public void testAddArcInhibitorDuplicate() {
		Place place = new Place(5);
		transition.addArcInhibitor(place);
		transition.addArcInhibitor(place);
		assertEquals(1, transition.getInArcs().size());
		assertTrue(transition.getInArcs().get(0) instanceof InhibitorArc);
		assertEquals(0, transition.getInArcs().get(0).getWeight());
		assertSame(place, transition.getInArcs().get(0).getPlace());
	}
	@Test
	@Order(9)
	public void testAddArcClearing() {
		Place place = new Place(5);
		transition.addArcClearing(place);
		assertEquals(1, transition.getInArcs().size());
		assertTrue(transition.getInArcs().get(0) instanceof ClearingArc);
		assertEquals(1, transition.getInArcs().get(0).getWeight());
		assertSame(place, transition.getInArcs().get(0).getPlace());
	}
	@Test
	@Order(10)
	public void testAddArcClearingDuplicate() {
		Place place = new Place(5);
		transition.addArcClearing(place);
		transition.addArcClearing(place);
		assertEquals(1, transition.getInArcs().size());
		assertTrue(transition.getInArcs().get(0) instanceof ClearingArc);
		assertEquals(1, transition.getInArcs().get(0).getWeight());
		assertSame(place, transition.getInArcs().get(0).getPlace());
	}
	
	@Test
	@Order(11)
	public void testRemoveArcIn() {
		Place place = new Place(5);
		transition.addArcIn(3, place);
		transition.removeArcIn(place);
		assertEquals(0, transition.getInArcs().size());
	}
	
	@Test
	@Order(12)
	public void testRemoveArcOut() {
		Place place = new Place(5);
		transition.addArcOut(3, place);
		transition.removeArcOut(place);
		assertEquals(0, transition.getInArcs().size());
	}

	@Test
	@Order(13)
	public void testTriggerTrue() {
		Place p1=new Place(4);
		Place p2=new Place(3);
		Place p3=new Place(0);
		Place p4=new Place(5);
		transition.addArcIn(2, p1);
		transition.addArcClearing(p2);
		transition.addArcInhibitor(p3);
		transition.addArcOut(2, p4);

		transition.trigger();

		assertEquals(2,p1.getToken());
		assertEquals(0,p2.getToken());
		assertEquals(0,p3.getToken());
		assertEquals(7,p4.getToken());
	}

	@Test
	@Order(14)
	public void testTriggerFalse() {
		Place p1=new Place(1);
		Place p2=new Place(3);
		transition.addArcIn(2, p1);
		transition.addArcOut(2, p2);

		transition.trigger();

		assertEquals(1,p1.getToken());
		assertEquals(3,p2.getToken());
	}


}
