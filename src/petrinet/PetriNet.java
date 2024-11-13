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
	// Method to remove a Place from the PetriNet. Before deleting the place 
	//we must be careful to delete all the arcs linked to this place
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
	//Method to remove a Transition. In this case the arcs associated with this 
	//transition will disappear with the transition since they are contained by 
	//the transition.
	public void removeTransition(Transition t) {
		for (int i=0;i<this.transitions.size();i++){
			if (this.transitions.get(i).id==t.id) {
				this.transitions.remove(i);
				break;
			}
		}
	}
	//Method to add an ArcIn between Transition t and Place p with a weight
	public void addArcIn(Transition t, int weight, Place p) {
		t.addArcIn(weight, p);
	}
	//Method to add an Inhibitor Arc between Transition t and Place p
	public void addArcInhibitor(Transition t,Place p) {
		t.addArcInhibitor(p);
	}
	//Method to add a Clearing Arc between Transtion t and Place p
	public void addArcClearing(Transition t, Place p) {
		t.addArcClearing(p);
	}
	//Method to add an ArcOut between Transition t and Place p
	public void addArcOut(Transition t, int weight, Place p) {
		t.addArcOut(weight, p);
	}
	//Method to remove the ArcIn between Transition t and Place p
	public void removeArcIn(Transition t, Place p) {
		t.removeArcIn(p);	
	}
	//Method to remove the ArcOut between Transition t and Place p
	public void removeArcOut(Transition t, Place p) {
		t.removeArcOut(p);
	}
	//Method to trigger a transition
	public void trigger(Transition t) {
		this.transitions.stream()
		.filter(t1-> t1.id==t.id)
		.forEach(Transition::trigger);
	}

}



