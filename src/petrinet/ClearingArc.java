package petrinet;

public class ClearingArc extends InArc {
	public int weight;
	public Place place;
	
	public ClearingArc(Place place) {
		super(0, place);
	}
	
	public boolean canStep() {
		return place.getToken() > 0;
	}
	
	public void step() {
		place.removeToken(place.getToken());
	}
}
