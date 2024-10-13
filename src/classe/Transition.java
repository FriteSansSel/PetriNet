package classe;

import java.util.ArrayList;
import java.util.List;

public class Transition {
	public List<InArc> inArcs;
	public List<OutArc> outArcs;
	
	public Transition() {
		inArcs = new ArrayList<>();
		outArcs = new ArrayList<>();
	}
	
	public void addInArc(int weight, Place place) {
		inArcs.add(new InArc(weight, place));
	}
	
	public void addZeroArc(Place place) {
		inArcs.add(new Zero(place));
	}
	
	public void addVideurArc(Place place) {
		inArcs.add(new Videur(place));
	}
	
	public void addOutArc(int weight, Place place) {
		outArcs.add(new OutArc(weight, place));
	}
	
	public void trigger() {
		boolean canTrigger = true;
		
		for (InArc arc : inArcs) {
			if (!arc.canStep()) {
				canTrigger = false;
				break;
			}
		}
		
		if (canTrigger) {
			for (InArc arc : inArcs) {
				arc.step();
			}
			for (OutArc arc : outArcs) {
				arc.step();
			}
		} else {
			System.out.println("système non tirable");
		}
	}
}
