package petrinet;

public class Arc {
	 // The weight of the Arc
    public int weight;
    
    // The place associated with this Arc
    public Place place;
    
    public Arc(int weight, Place place) {
    	this.place=place;
    	this.weight=weight;
    }
}
