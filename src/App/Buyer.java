package App;

import java.util.ArrayList;

import UtilityClasses.Combinatorial;
import UtilityClasses.CustomValuation;
import UtilityClasses.SingleMinded;
import UtilityClasses.Submodular;
import UtilityClasses.Submodular2;

public class Buyer {
	
	int typeOfBuyer;		//0 if buyer is Combinatorial, 1 if buyer is Submodular
	int budget;
	int n; 					//n is the number of items he is offered
	int[][] arr;			//combinations of items he can buy
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	ArrayList<Integer> utilities = new ArrayList<Integer>();
	
	public Buyer(int typeOfBuyer, int budget, int n) {
		this.typeOfBuyer = typeOfBuyer;
		this.budget = budget;
		this.n = n;
	}
	
	public Buyer(int typeOfBuyer, int n) {
		this.typeOfBuyer = typeOfBuyer;
		this.n = n;
		
		//initialize valuations for n products
		
		if (typeOfBuyer == 0) {
			Combinatorial comb = new Combinatorial(n);
			this.valuations = comb.getValuations();
		}
		else if (typeOfBuyer == 1) {
			Submodular2 sub2 = new Submodular2(n);
			this.valuations = sub2.getValuations();
		}
		else if (typeOfBuyer == 2) {
			CustomValuation customVal = new CustomValuation(n);
			this.valuations = customVal.getValuations();
		}
		else if (typeOfBuyer == 3) {
			Submodular submodular = new Submodular(n);
			this.valuations = submodular.getValuations();
		}
		else if(typeOfBuyer == 4) {
			SingleMinded sm = new SingleMinded(n);
			this.valuations = sm.getValuations();
		}
		
		
	}
	
	public ArrayList<Integer> getValuations() {
		return this.valuations;
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
	
	public ArrayList<Integer> getUtilities(){
		return this.utilities;
	}
	
	public void addUtility(int utility) {
		this.utilities.add(utility);
	}
	
	public void clearUtilityArray() {
		this.utilities.clear();
	}
	
	public void printUtilities() {
		System.out.println("utilities : " + this.utilities);
	}
}
