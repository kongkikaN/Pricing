package UtilityClasses;

import java.util.ArrayList;
import java.util.Random;

import App.FinalVariables;

/**
 * this class implements the 
 * for every X, Y subsets of OMEGA with X subset of Y and every x in OMEGA we have 
 * f(X U {x}) - f(X) >= f(Y U {x}) - f(Y)
 * @author Nikos Kongkika
 *
 */
public class Submodular2 {
	
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	
	
	public Submodular2(int n) {
		//MAX VALUATION
		final int MAX_VALUATION = (new FinalVariables()).getMAX_VALUATION();
		
		//initialize Combinatorial valuations
		Random r = new Random();
		ArrayList<Integer> initialValuations = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			initialValuations.add(r.nextInt(MAX_VALUATION));
		}
		
		
		//initialize binary array
		int[][] binArr = new int[(int) Math.pow(2, n)][n];
		ArrayList <Bundle> bundles = new ArrayList<Bundle>();
				
		for (int i = 0; i < Math.pow(2, n); i++) {
			String bin = Integer.toBinaryString(i);
			int temp = n - bin.length();
			String tem = "";
			for (int t = 0; t < temp; t++) {
				tem += "0";
			}
			bin = tem + bin;
			//System.out.println(bin);
			for (int j = 0; j < n; j++) {
				String s = bin.charAt(j) + "";
				binArr[i][j] = Integer.parseInt(s);
				//System.out.print(binArr[i][j] + " ");
			}
		}
		
		//create bundles
		for (int i = 0; i < binArr.length; i++) {
			Bundle bundle = new Bundle(n, i, binArr[i]);
			//bundle.printBundle();
			bundles.add(bundle);
		}
		
		//calculate subsets
		for (Bundle b1 : bundles) {
			for (Bundle b2 : bundles) {
				if (isSubset(b2, b1)) {			//if b2 is subset of b1
					b2.addSubset(b1);
				}
			}
		}
		
		//calculate upperBound
		for (Bundle b : bundles) {
			int upperBound = calculateUpperBound(b, initialValuations);
			b.setUpperBound(upperBound);
		}
		
		
		//valuation of bundle {0, 0, ..., 0} is always 0
		bundles.get(0).setValue(0);
		
		//calculate lower bound
		int max = 0;
		for (Bundle b : bundles) {
			for (Bundle c : bundles) {
				if (b.getSubsets().contains(c)){
					if (max < c.getValue()) {
						max = c.getValue();
					}
				}
			}
			
			//IMPORTANT!!!
			//Value of a bundle depends on the value of its subsets
			//Let A, B be bundles
			//if A subset of B, value of A cannot be higher than value of B
			
			if (max != 0) {
				Random random = new Random();
				b.setValue(random.nextInt((b.getUpperBound() - max) + 1) + max);
			}
			else {
				b.setValue(b.getUpperBound());
			}
			
			
			b.setLowerBound(max);
			max = 0;
		}
		
		//print bundles
//		for (Bundle b : bundles) {
//			b.printBundle();
//		}
		
		for (Bundle b : bundles) {
			this.valuations.add(b.getValue());
		}
	}
	
	public int calculateUpperBound(Bundle b, ArrayList<Integer> initVals) {
		int [] arr = b.getBundle();
		int max = 0;
		for (int i = 0; i < initVals.size(); i++) {
			max += initVals.get(i) * arr[i];
		}
		return max;
	}
	
	/*
	 * returns if bundle b2 is a subset of bundle b1
	 */
	public boolean isSubset(Bundle b2, Bundle b1) {
		int[] arr2 = b2.getBundle();
		int[] arr1 = b1.getBundle();
		
		boolean isSub = true;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 0) {
				if (arr1[i] != 0) {
					isSub = false;
				}
			}
		}
		return isSub;
	}
	
	public ArrayList<Integer> getValuations(){
		return this.valuations;
	}
	
}
