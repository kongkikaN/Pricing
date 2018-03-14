package UtilityClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Submodular {
	
	ArrayList <Integer> valuations = new ArrayList<Integer>();
	
	//initialize valuations for n products
	public Submodular(int n) {
		
		//initialize binary array
		int[][] binArr = new int[(int) Math.pow(2, n)][n];
		
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
		//create binary array copy
		
		
		//create initial Valuations for each item respectively
		ArrayList<Integer> initialVal;
		initialVal = createVals(n);
		
		
		
		ArrayList <Integer> finValuation = new ArrayList<Integer>();
		//for each combination of items return valuation
		for (int i = 0; i < Math.pow(2, n); i++) {
			finValuation.add(calcFinValuation(initialVal, binArr, i, n, finValuation));
		}
		//System.out.println("final valuation = " + finValuation);
	}
	
	public static int calcFinValuation(ArrayList<Integer> initialVal, int[][] arr,int i,int n, ArrayList<Integer> finValuation) {
		
		
		int lowerBound = 0;
		int upperBound = 0;
		
		//calculate upperBound
		upperBound = getUpperBound(initialVal, arr, i, n);
		//System.out.print("upperBound = " + upperBound + " ");
		//calculate lowerBound
		lowerBound = getLowerBound(initialVal, arr, i, n, finValuation);
		//System.out.println("lowerBound = " + lowerBound);
		
		//System.out.println("(" + lowerBound + ", " + upperBound + ")");
		
		return 0;
		
	}
	
	
	public static int getLowerBound(ArrayList<Integer> initialVal, int[][] arr,int i,int n, ArrayList<Integer> finValuation) {
		
		//print(arr);
		//System.out.println("\n" + initialVal + " , i = " + i + " ,  n = " + n);
		//System.out.println("\n");
		
		
		//create bundles
		ArrayList<Bundle> bundles = new ArrayList<Bundle>();
		for (int b = 0; b < arr.length; b++) {
			Bundle bundle  = new Bundle(n, b, arr[b]);
			bundles.add(bundle);
		}
		
		//ArrayList <Integer> maxV = new ArrayList<Integer>();
		//int max = 0;
		//int temp = 0;
		boolean isSubset = true;
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < n; k++) {
				//current line = arr[i]
				//checking if arr[j] is a subset of arr[i]
				//System.out.println( "i = " + i);
				if (arr[j][k] > 0) {
					if (arr[i][k] == 0) {
						isSubset = false;
					}
				}
			}
			
			//System.out.println(j + " line is " + isSubset  + " of line " + i);
			if (isSubset) {
				bundles.get(i).addSubset(bundles.get(j));
			}
		}
		
		
		
		for (Bundle bundle : bundles) {
			bundle.printBundle();
		}
		return 0;
	}
	
	public static int getUpperBound(ArrayList<Integer> initialVal, int[][] arr,int i,int n) {
		int upperBound = 0;
		for (int j = 0; j < n; j++) {
			arr[i][j] = arr[i][j] * initialVal.get(j);
			upperBound += arr[i][j];
		}
		return upperBound;
	}
	
	public static ArrayList<Integer> createVals(int n){
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			arr.add(r.nextInt(100));
		}
		return arr;
	}
	
	public static void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<Integer> getValuations(){
		return this.valuations;
	}
}
