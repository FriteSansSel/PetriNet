package classe;

public class OutArc {
	public int weight;
	public Place place;
	
	public OutArc(int weight, Place place) {
		this.weight = weight;
		this.place = place;
	}
	
	public void step() {
		place.addToken(weight);
	}
}
