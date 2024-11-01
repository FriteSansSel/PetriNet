package petrinet;

public class InArc {
    // The weight of the inArc, representing the number of tokens required
    public int weight;
    
    // The place associated with this InArc
    public Place place;
    
    // Constructor to initialize the InArc with a specified weight and place
    public InArc(int weight, Place place) {
        this.weight = weight; 
        this.place = place;  
    }
    
    // Method to check if the transition can step based on the current token count in the place
    public boolean canStep() {
        return place.getToken() >= weight; 
    }
    
    // Method to perform the step action, removing the required tokens from the place
    public void step() {
        place.removeToken(weight);
    }
}
