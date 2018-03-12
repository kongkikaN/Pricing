package App;

public class Agent {
	int id;
	int budget;
	int price;
	int initType;
	InitPrice InPrice = new InitPrice(initType);
	
	/**
	 * 
	 * @param id := id of each seller
	 * @param budget := budget of buyer
	 * @param random := type of initialization
	 */
	public Agent(int id, int budget, int initType) {
		this.id = id;
		this.budget = budget;
		this.initType = initType;
		this.price = InPrice.getPrice(initType);
	}
	
	/**
	 * 
	 * @param id := id of each seller
	 * @param random := type of initialization
	 */
	public Agent(int id, int initType) {
		this.id = id;
		this.budget = budget;
		this.initType = initType;
		this.price = InPrice.getPrice(initType);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public int getPrice() {
		return price;
	}
}
