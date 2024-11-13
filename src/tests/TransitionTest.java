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
		Transition.IdCount=0;
		transition=new Transition();
	}

	@Test
	@Order(1)
	public void testConstructor() {
		assertEquals(transition.id,0);
		assertNotNull(transition.inArcs);
		assertNotNull(transition.outArcs);
		assertTrue(transition.inArcs.isEmpty());
		assertTrue(transition.outArcs.isEmpty());
		assertTrue(transition.inArcs instanceof ArrayList<InArc>);
		assertTrue(transition.outArcs instanceof ArrayList<OutArc>);
	}
	@Test
	@Order(2)
	void testConstructorId() {
		Transition t2=new Transition();
		Transition t3=new Transition();
		assertEquals(1,t2.id);
		assertEquals(2,t3.id);
	}
	@Test
	@Order(3)
	public void testAddArcIn() {
		Place place = new Place(5);
		transition.addArcIn(3, place);
		assertEquals(1, transition.inArcs.size());
		assertTrue(transition.inArcs.get(0) instanceof InArc);
		assertEquals(3, transition.inArcs.get(0).weight);
		assertSame(place, transition.inArcs.get(0).place);
	}
	@Test
	@Order(4)
	public void testAddArcInDuplicate() {
		Place place = new Place(5);
		transition.addArcIn(3, place);
		transition.addArcIn(4, place);
		assertEquals(1, transition.inArcs.size());
		assertTrue(transition.inArcs.get(0) instanceof InArc);
		assertEquals(3, transition.inArcs.get(0).weight);
		assertSame(place, transition.inArcs.get(0).place);
	}
	@Test
	@Order(5)
	public void testAddArcOut() {
		Place place = new Place(5);
		transition.addArcOut(3, place);
		assertEquals(1, transition.outArcs.size());
		assertTrue(transition.outArcs.get(0) instanceof OutArc);
		assertEquals(3, transition.outArcs.get(0).weight);
		assertSame(place, transition.outArcs.get(0).place);
	}
	@Test
	@Order(6)
	public void testAddArcOutDuplicate() {
		Place place = new Place(5);
		transition.addArcOut(3, place);
		transition.addArcOut(4, place);
		assertEquals(1, transition.outArcs.size());
		assertTrue(transition.outArcs.get(0) instanceof OutArc);
		assertEquals(3, transition.outArcs.get(0).weight);
		assertSame(place, transition.outArcs.get(0).place);
	}
	@Test
	@Order(7)
	public void testAddArcInhibitor() {
		Place place = new Place(5);
		transition.addArcInhibitor(place);
		assertEquals(1, transition.inArcs.size());
		assertTrue(transition.inArcs.get(0) instanceof InhibitorArc);
		assertEquals(0, transition.inArcs.get(0).weight);
		assertSame(place, transition.inArcs.get(0).place);
	}
	@Test
	@Order(8)
	public void testAddArcInhibitorDuplicate() {
		Place place = new Place(5);
		transition.addArcInhibitor(place);
		transition.addArcInhibitor(place);
		assertEquals(1, transition.inArcs.size());
		assertTrue(transition.inArcs.get(0) instanceof InhibitorArc);
		assertEquals(0, transition.inArcs.get(0).weight);
		assertSame(place, transition.inArcs.get(0).place);
	}
	@Test
	@Order(9)
	public void testAddArcClearing() {
		Place place = new Place(5);
		transition.addArcClearing(place);
		assertEquals(1, transition.inArcs.size());
		assertTrue(transition.inArcs.get(0) instanceof ClearingArc);
		assertEquals(1, transition.inArcs.get(0).weight);
		assertSame(place, transition.inArcs.get(0).place);
	}
	@Test
	@Order(10)
	public void testAddArcClearingDuplicate() {
		Place place = new Place(5);
		transition.addArcClearing(place);
		transition.addArcClearing(place);
		assertEquals(1, transition.inArcs.size());
		assertTrue(transition.inArcs.get(0) instanceof ClearingArc);
		assertEquals(1, transition.inArcs.get(0).weight);
		assertSame(place, transition.inArcs.get(0).place);
	}

	@Test
	@Order(11)
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
	@Order(12)
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
