package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import petrinet.OutArc;
import petrinet.Place;


public class OutArcTest {
	
	private Place place;
	private OutArc outarc;

    @BeforeEach
    void setUp() {
    	place=new Place(5);
    	
        outarc= new OutArc(5,place);
    }
    
    @Test
    @Order(1)
    void testStep() {
    	outarc.step();
    	assertEquals(10,place.getToken());
    	
    }
    
    

}
