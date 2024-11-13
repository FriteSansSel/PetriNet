package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import petrinet.Place;

public class PlaceTest {
	
	private Place place;

    @BeforeEach
    void setUp() {
        // Initializes Place with 5 tokens before each test
    	Place.IdCount=0;
        place = new Place(5);
    }

    @Test
    @Order(1)
    void testConstructorWithNegativeToken() {
    	// Checks that the constructor throws an IllegalArgumentException for a negative number of tokens
    	Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Place(-5);});
    	assertEquals("Token count cannot be negative", exception.getMessage());
    }
    @Test
    @Order(2)
    void testConstructorId() {
    	assertEquals(0,place.id);
    	Place p2=new Place(3);
    	assertEquals(1,p2.id);
    }
    
    @Test
    @Order(3)
    void testGetToken() {
        // Checks that the initial number of tokens is the one supplied to the constructor and test getToken()
        assertEquals(5, place.getToken());
    }

    @Test
    @Order(4)
    void testAddToken() {
        // Adds 3 tokens and checks that the number of tokens has been updated correctly
        place.addToken(3);
        assertEquals(8, place.getToken());
    }

    @Test
    @Order(5)
    void testAddNegativeToken() {
    	// Checks that adding a negative number of tokens does nothing
    	place.addToken(-2);
    	assertEquals(5, place.getToken());
    }
    
    @Test
    @Order(6)
    void testRemoveTokenSuccess() {
        // Remove 2 tokens and check that the number of tokens has been updated correctly
        place.removeToken(2);
        assertEquals(3, place.getToken());
    }

    @Test
    @Order(7)
    void testRemoveNegativeToken() {
    	// Checks that removing a negative number of tokens does nothing
    	place.removeToken(-2);
    	assertEquals(5, place.getToken());
    }
    
    @Test
    @Order(8)
    void testRemoveTokenFailure() {
        // Attempt to withdraw more tokens than available and check that the number of tokens remains unchanged
        place.removeToken(10);
        assertEquals(5, place.getToken());
    }
}
