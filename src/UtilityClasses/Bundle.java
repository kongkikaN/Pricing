package UtilityClasses;

import java.util.ArrayList;

public class Bundle {
	
	ArrayList<Bundle> subsets = new ArrayList<Bundle>();
	int id;
	int n;
	int arr[];
	
	public Bundle(int n,int id, int arr[]) {
		this.id = id;
		this.arr = arr;
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
		for (int i = 0; i < this.getSubsets().size(); i++) {
			System.out.println( "bundle " + this.getId() + " has subsets : " + this.getSubsets().get(i).getId());
		}
		System.out.println("\n");
	}
	
}
