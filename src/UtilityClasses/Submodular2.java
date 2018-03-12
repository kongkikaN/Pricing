package UtilityClasses;

import java.util.ArrayList;
import java.util.Random;

public class Submodular2 {
	
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	
	
	public Submodular2(int n) {
		//MAX VALUATION
		final int MAX_VALUATION = 100;
		
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
		
		//TODO : calculate lowerBound
		
		//valuation of bundle {0, 0, ..., 0} is always 0
		bundles.get(0).setValue(0);
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
			
			Random random = new Random();
			b.setValue(random.nextInt((b.getUpperBound() - max) + 1) + max);
			
			
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
		
		int [] arr = b.getArr();
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
		int[] arr2 = b2.getArr();
		int[] arr1 = b1.getArr();
		
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
