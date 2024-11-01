package petrinet;

public class ClearingArc extends InArc {
    // The constructor initializes a ClearingArc with a place and a weight of 0 
    public ClearingArc(Place place) {
        super(0, place);
    }
    
    // Method to check if the clearing arc can step, which is true if the place has at least one token
    public boolean canStep() {
        return place.getToken() > 0;
    }
    
    // Method to perform the step action, which removes all tokens from the place
    public void step() {
        place.removeToken(place.getToken());
    }
}
