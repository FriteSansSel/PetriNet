package petrinet;

public class Place {
    // The number of tokens currently in this place
    public int token;
    
    // Constructor to initialize the Place with a specified number of tokens
    public Place(int token) {
        this.token = token; 
    }
    
    // Method to retrieve the current number of tokens in the place
    public int getToken() {
        return token; 
    }
    
    // Method to add tokens to the place
    public void addToken(int token) {
        this.token += token; 
    }
    
    // Method to remove a specified number of tokens from the place
    public void removeToken(int token) {
        // Check if there are enough tokens to remove
        if (this.token >= token) {
            this.token -= token; 
        } else {
            System.out.println("Not enough token"); 
        }
    }
}
