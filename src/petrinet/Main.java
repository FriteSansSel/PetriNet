package petrinet;

public class Main {
	public static void main(String[] args) {
		PetriNet petrinet = new PetriNet();
		
		petrinet.addPlace(2);
		Place place1 = petrinet.places.get(0);
		petrinet.addPlace(3);
		Place place2 = petrinet.places.get(1);

		
		Transition transition1 = new Transition();
		
		transition1.addInArc(1, place1);
		transition1.addOutArc(2, place2);
		
        System.out.println("Avant :");
        System.out.println("place1 : " + place1.getToken());
        System.out.println("place2 : " + place2.getToken());

        transition1.trigger();

        System.out.println("Après :");
        System.out.println("place1 : " + place1.getToken());
        System.out.println("place2 : " + place2.getToken());
	}
}
