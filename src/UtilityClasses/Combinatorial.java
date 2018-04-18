package UtilityClasses;

import java.util.ArrayList;
import java.util.Random;

import App.BinaryTable;
import App.FinalVariables;

public class Combinatorial {
	
	int n;
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	
	public Combinatorial(int n) {
		this.n = n;
	}
	
	public ArrayList<Integer> getValuations(){
		BinaryTable bt = new BinaryTable(n);
		int[][] binTab = bt.getBinTable();
		ArrayList<Integer> seperateVals = new ArrayList<Integer>();
		FinalVariables fv = new FinalVariables();
		
		Random r = new Random();
		//calculate valuation for each item
		for (int i = 0; i < n; i++) {
			seperateVals.add(r.nextInt(fv.getMAX_VALUATION() +1));
		}
		//calculate valuation for bundles
		int temp = 0;
		for (int i = 0; i < binTab.length; i++) {
			for (int j = 0; j < binTab[0].length; j++) {
				binTab[i][j] = binTab[i][j] * seperateVals.get(j);
				temp += binTab[i][j];
			}
			this.valuations.add(temp);
			temp = 0;
		}
		
		//return valuations;
		
		return this.valuations;
	}
}
