package classe;

public class Videur extends InArc {
	public int weight;
	public Place place;
	
	public Videur(Place place) {
		super(0, place);
	}
	
	public boolean canStep() {
		return place.getToken() > 0;
	}
	
	public void step() {
		place.removeToken(place.getToken());
	}
}
