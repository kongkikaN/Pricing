package UtilityClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CustomValuation {
	
	ArrayList <Integer> customVals = new ArrayList<Integer>();
	
	public CustomValuation(int n) {
		System.out.println("Please enter " + Math.pow(2, n)  + " valuations ");
		System.out.println("For example if number of sellers = 2 enter " + " ' 0 4 4 6");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		for (int i = 0; i < Math.pow(2, n); i++) {
			this.customVals.add(Integer.parseInt(Arrays.asList(str.trim().split(" ")).get(i)));
		}
	}
	
	public ArrayList<Integer> getValuations(){
		return this.customVals;
	}
	
	
}
