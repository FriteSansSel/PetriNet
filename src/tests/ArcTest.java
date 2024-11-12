package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import petrinet.Arc;
import petrinet.Place;

public class ArcTest {
	
	Place place;
	Arc arc;

    @BeforeEach
    void setUp() {
        place=new Place(5);
    	arc= new Arc(5,place);
    }
    
    @Test
    @Order(1)
    void testArcConstuctor() {
    	assertEquals(5,arc.weight);
    	assertSame(place,arc.place);
    }
    
    @Test
    @Order(2)
    void testArcNegativeWeight() {
    	Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Arc(-5,place);});
    	assertEquals("Weight cannot be negative", exception.getMessage());
    }
    
    @Test
    @Order(3)
    void testArcPlaceNull() {
    	Exception exception=assertThrows(NullPointerException.class, ()-> {new Arc(5,null);});
    }
    
}


