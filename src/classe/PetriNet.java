package classe;

import java.util.ArrayList;
import java.util.List;

public class PetriNet {
	public List<Place> places;
	public List<Transition> transitions;
	
	public PetriNet() {
		places = new ArrayList<>();
		transitions = new ArrayList<>();
	}
	
	public void addPlace(int token) {
		places.add(new Place(token));
	}
	
	public void addTransition() {
		transitions.add(new Transition());
	}
}
