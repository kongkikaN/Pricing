package UtilityClasses;

import java.util.ArrayList;

public class Bundle {
	
	ArrayList<Bundle> subsets = new ArrayList<Bundle>();
	int id;
	int n;
	int arr[];
	int value;
	int upperBound;
	int lowerBound;
	
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

	public int[] getArr() {
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
