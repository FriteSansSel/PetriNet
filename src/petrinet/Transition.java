package petrinet;

import java.util.ArrayList;
import java.util.List; 

public class Transition {
    // List to hold incoming arcs (InArcs) associated with this transition
    public List<InArc> inArcs;
    
    // List to hold outgoing arcs (OutArcs) associated with this transition
    public List<OutArc> outArcs;
    
    // Constructor to initialize the Transition with empty lists for arcs
    public Transition() {
        inArcs = new ArrayList<>(); 
        outArcs = new ArrayList<>(); 
    }
    
    // Method to add an inArc with a specified weight and a reference to a place
    public void addInArc(int weight, Place place) {
        inArcs.add(new InArc(weight, place)); 
    }
    
    // Method to add an inhibitor arc  to the inArcs
    public void addZeroArc(Place place) {
        inArcs.add(new InhibitorArc(place)); 
    }
    
    // Method to add a clearing arc to the inArcs
    public void addVideurArc(Place place) {
        inArcs.add(new ClearingArc(place)); 
    }
    
    // Method to add an outArc arc with a specified weight and a reference to a place
    public void addOutArc(int weight, Place place) {
        outArcs.add(new OutArc(weight, place)); 
    }
    
    // Method to trigger the transition, checking if it can occur and updating arcs accordingly
    public void trigger() {
        boolean canTrigger = true; 
        
        // Check if all  inArcs allow the transition to step
        for (InArc arc : inArcs) {
            if (!arc.canStep()) { 
                canTrigger = false;
                break;
            }
        }
        
        // If the transition can be triggered, step through all inArcs and outArcs
        if (canTrigger) {
            for (InArc arc : inArcs) {
                arc.step(); 
            }
            for (OutArc arc : outArcs) {
                arc.step(); 
            }
        } else {
            System.out.println("Transition not triggerable "); 
        }
    }
}
