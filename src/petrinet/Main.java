package petrinet;

public class Main {
    public static void main(String[] args) {
        // Create a new instance of the PetriNet
        PetriNet petrinet = new PetriNet();
        
        // Add a place with 2 tokens to the Petri net
        petrinet.addPlace(2);
        Place place1 = petrinet.places.get(0);
        
        // Add another place with 3 tokens to the Petri net
        petrinet.addPlace(3);
        Place place2 = petrinet.places.get(1); 
        
        Transition transition1 = new Transition();
        
        // Add an inArc from place1 with a weight of 1
        transition1.addArcIn(1, place1);
        
        // Add an outArc to place2 with a weight of 2
        transition1.addArcOut(2, place2);
        
        // Display the token count in both places before triggering the transition
        System.out.println("Before :");
        System.out.println("place1 : " + place1.getToken());
        System.out.println("place2 : " + place2.getToken());

        // Trigger the transition to update token counts
        transition1.trigger();

        // Display the token count in both places after triggering the transition
        System.out.println("After :");
        System.out.println("place1 : " + place1.getToken());
        System.out.println("place2 : " + place2.getToken());
    }
}
