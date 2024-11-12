package petrinet;

public class InhibitorArc extends InArc {
    // The constructor initializes an InhibitorArc with a place and a weight of 0 
    public InhibitorArc(Place place) {
        super(0, place); 
    }
    
    // Method to check if the inhibitor arc can step, which is true if the place has no tokens
    public boolean canStep() {
        return place.getToken() == 0; 
    }
    
    // Method to perform the step action for the inhibitor arc, which does nothing
    public void step() {
        
    }
}