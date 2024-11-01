package petrinet;

import java.util.ArrayList;

public class PetriNet {
    // ArrayList to hold the places in the Petri net
    public ArrayList<Place> places;
    
    // ArrayList to hold the transitions in the Petri net
    public ArrayList<Transition> transitions;
    
    // Constructor to initialize the Petri net
    public PetriNet() {
        places = new ArrayList<>();
        transitions = new ArrayList<>();
    }
    
    // Method to add a new place with a specified number of tokens
    public void addPlace(int token) {
        places.add(new Place(token));
    }
    
    // Method to add a new transition to the Petri net
    public void addTransition() {
    	transitions.add(new Transition());
    }
}
