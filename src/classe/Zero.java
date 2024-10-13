package classe;

public class Zero extends InArc {
	public int weight;
	public Place place;
	
	public Zero(Place place) {
		super(0, place);
	}
	
	public boolean canStep() {
		return place.getToken() == 0;
	}
	
	public void step() {
		
	}
}
