package petrinet;

import java.util.ArrayList;

public class PetriNet {
	// ArrayList to hold the places in the Petri net
	public ArrayList<Place> places;

	// ArrayList to hold the transitions in the Petri net
	public ArrayList<Transition> transitions;

	// Constructor to initialize the Petri net
	public PetriNet() {
		places = new ArrayList<>();
		transitions = new ArrayList<>();
	}

	// Method to add a new place with a specified number of tokens
	public Place addPlace(int token) {
		Place p=new Place(token);
		places.add(p);
		return p;
	}

	public void removePlace(Place place) {
		for (Transition t : this.transitions) {
			t.inArcs.removeIf(inarc -> inarc.place.id == place.id); 
			t.outArcs.removeIf(outarc -> outarc.place.id == place.id); 
		}
		for (int i=0;i<this.places.size();i++){
			if (this.places.get(i).id==place.id) {
				this.places.remove(i);
				break;
			}
		}
		

	}

	// Method to add a new transition to the Petri net
	public Transition addTransition() {
		Transition t=new Transition();
		transitions.add(t);
		return t;
	}

	public void removeTransition(Transition t) {
		for (int i=0;i<this.transitions.size();i++){
			if (this.transitions.get(i).id==t.id) {
				this.transitions.remove(i);
				break;
			}
		}
	}

	public void trigger(Transition t) {
		this.transitions.stream()
		.filter(t1-> t1.id==t.id)
		.forEach(Transition::trigger);
	}

}



