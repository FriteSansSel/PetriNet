package petrinet;

public class Place {
	public int token;
	
	public Place(int token) {
		this.token = token;
	}
	
	public int getToken() {
		return token;
	}
	
	public void addToken(int token) {
		this.token += token;
	}
	
	public void removeToken(int token) {
		if (this.token >= token) {
			this.token -= token;
		} else {
			System.out.println("Not enough token");
		}
	}
}
