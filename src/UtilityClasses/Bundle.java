package UtilityClasses;

import java.util.ArrayList;

public class Bundle {
	
	//this IS NOT a utility class... 
	//This is only a Bundle class to calculate bundles (only for Submodular2 class)
	
	
	ArrayList<Bundle> subsets = new ArrayList<Bundle>();
	int id;
	int n;
	int arr[];
	int value;
	int upperBound;		//only needed to calculate the value
	int lowerBound;		//only needed to calculate the value
	
	public Bundle(int n,int id, int arr[]) {
		this.id = id;
		this.arr = arr;
	}
	
	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int[] getBundle() {
		return this.arr;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void addSubset(Bundle b) {
		this.subsets.add(b);
	}
	
	public ArrayList<Bundle> getSubsets(){
		return this.subsets;
	}
	
	public int getId() {
		return this.id;
	}
	
	
	public void printBundle() {
		System.out.print("Bundle id = " + id + "		||     ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(this.arr[i] + " , ");
		}
		System.out.println("\n");
		
		System.out.print("bundle " + this.id + "'s subsets are =  {");
		for (Bundle b : subsets) {
			System.out.print( b.id + ", ");
		}
		System.out.println("}");
		System.out.println("\n");
		
		System.out.println(this.getId() + "'s value = " + this.getValue());
	}
	
}
