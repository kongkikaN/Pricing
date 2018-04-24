package App;

public class Agent {
	int id;
	int price;
	int initType;
	InitPrice InPrice = new InitPrice(initType);
	int utility;
	/**
	 * 
	 * @param id := id of each seller
	 * @param random := type of initialization
	 */
	public Agent(int id, int initType) {
		this.id = id;
		this.initType = initType;
		this.price = InPrice.getPrice(initType);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void printAgent() {
		System.out.println("Seller id : " + this.id + " & price : " + this.price + " sellers utility = " + this.utility);
	}
	
	public int getUtility() {
		return utility;
	}

	public void setUtility(int utility) {
		this.utility = utility;
	}
}
