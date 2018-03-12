package App;

import java.util.ArrayList;

import UtilityClasses.Submodular;

public class Buyer {
	
	int typeOfBuyer;		//0 if buyer is Combinatorial, 1 if buyer is Submodular
	int budget;
	int n; 					//n is the number of items he is offered
	int[][] arr;			//combinations of items he can buy
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	
	public Buyer(int typeOfBuyer, int budget, int n) {
		this.typeOfBuyer = typeOfBuyer;
		this.budget = budget;
		this.n = n;
		
	}
	
	public Buyer(int typeOfBuyer, int n) {
		this.typeOfBuyer = typeOfBuyer;
		this.n = n;
		
		//initialize valuations for n products
		Submodular sub = new Submodular(n);
		this.valuations = sub.getValuations();	
	}

	public int getTypeOfBuyer() {
		return typeOfBuyer;
	}

	public void setTypeOfBuyer(int typeOfBuyer) {
		this.typeOfBuyer = typeOfBuyer;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
