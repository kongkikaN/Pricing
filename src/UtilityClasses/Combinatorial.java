package UtilityClasses;

import java.util.ArrayList;

public class Combinatorial {
	
	int n;
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	
	public Combinatorial(int n) {
		this.n = n;
		
	}
	
	public ArrayList<Integer> getValuations(){
		return this.valuations;
	}
}
