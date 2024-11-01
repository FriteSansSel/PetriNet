package petrinet;

public class InhibitorArc extends InArc {
	public int weight;
	public Place place;
	
	public InhibitorArc(Place place) {
		super(0, place);
	}
	
	public boolean canStep() {
		return place.getToken() == 0;
	}
	
	public void step() {
		
	}
}
