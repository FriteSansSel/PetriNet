package petrinet;

public class OutArc {
    // The weight of the outArc, representing the number of tokens to be added to the place
    public int weight;
    
    // The place associated with this outArc
    public Place place;
    
    // Constructor to initialize the OutArc with a specified weight and place
    public OutArc(int weight, Place place) {
        this.weight = weight; 
        this.place = place;   
    }
    
    // Method to perform the step action, which adds tokens to the place according to the outArc's weight
    public void step() {
        place.addToken(weight); 
    }
}
