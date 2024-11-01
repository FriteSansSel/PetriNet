package petrinet;

public class InArc {
	public int weight;
	public Place place;
	
	public InArc(int weight, Place place) {
		this.weight = weight;
		this.place = place;
	}
	
	public boolean canStep() {
		return place.getToken() >= weight;
	}
	
	public void step() {
		place.removeToken(weight);
	}
}
