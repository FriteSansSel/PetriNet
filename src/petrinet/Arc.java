package petrinet;

public class Arc {
	 // The weight of the Arc
    public int weight;
    
    // The place associated with this Arc
    public Place place;
    
    public Arc(int weight, Place place) {
    	if (place==null) {
    		throw new NullPointerException("Null place was given");
    	}
    	else {
    		this.place=place;
    	}
    	this.place=place;
    	if (weight<0) {
    		throw new IllegalArgumentException("Weight cannot be negative");
    	}
    	else {
    		this.weight=weight;
    	}
    }
}

