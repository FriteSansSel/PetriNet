package tests;

import org.junit.jupiter.api.BeforeEach;

import petrinet.OutArc;
import petrinet.Place;


public class OutArcTest {
	
	private Place place;
	private OutArc outarc;

    @BeforeEach
    void setUp() {
        Place place=new Place(5);
    	
        OutArc outarc= new OutArc(5,place);
    }
    
    

}
