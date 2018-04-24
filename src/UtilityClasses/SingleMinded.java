package UtilityClasses;

import java.util.ArrayList;
import java.util.Random;

import App.BinaryTable;
import App.FinalVariables;

public class SingleMinded {
	int n;
	ArrayList<Integer> valuations = new ArrayList<Integer>();
	
	public SingleMinded(int n) {
		this.n = n;
	}
	
	public ArrayList<Integer> getValuations(){
		FinalVariables fv = new FinalVariables();
		//get a random bundle (the bundle that the buyer is most interested in)
		BinaryTable binTab = new BinaryTable(this.n);
		int [][]bt = binTab.getBinTable();
		
		Random r = new Random();
		int bundle = r.nextInt(bt.length);
		ArrayList<Integer> theBundle = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			theBundle.add(bt[bundle][i]);
		}
		System.out.print("get the bundle " + bundle + " = ");
		System.out.println(theBundle);
		
		
		//flag bundles that contain bundle "bundle"
		
		
		//flag bundles that contain bundle "bundle"
		for (int i = 0; i < bt.length; i++) {
			if (isSubset(theBundle, bt[i])) {
				this.valuations.add(i, fv.getMAX_VALUATION());
			}
			else {
				this.valuations.add(i, 0);
			}
		}
		System.out.println("valuations is!! ");
		System.out.println(this.valuations);
	
		return this.valuations;
	}
	
	public boolean isSubset(ArrayList<Integer> bundle, int[] arr) {
		boolean isIt = true;
		for (int i = 0; i < bundle.size(); i++) {
			if(bundle.get(i) == 1 && arr[i] == 0) {
				isIt = false;
			}
		}
		return isIt;
	}
}
