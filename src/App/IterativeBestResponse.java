package App;

import java.util.ArrayList;

public class IterativeBestResponse {
	
	
	static Buyer buyer;
	static ArrayList<Agent> agents;
	static int n;
	
	public IterativeBestResponse(Buyer buyer, ArrayList<Agent> agents, int n) {
		this.buyer = buyer;
		this.agents = agents;
		this.n = n;
	}
	
	
	public static void IterBestResp() {
		
		// TODO : seller sets price based on binary search
		
		
		//calculate utility of buyer
		BinaryTable binTable = new BinaryTable(n);
		int [][] binTab = binTable.getBinTable();
		int [][] binTabCopy = binTab;
		
		int tempUtil = 0;
		int utility;
		
		for (int i = 0; i < binTab.length; i++) {
			for (int j = 0; j < n; j++) {
				binTab[i][j] = binTab[i][j] * (-1) * agents.get(j).getPrice();
				tempUtil += binTab[i][j];
			}
			utility = tempUtil + buyer.valuations.get(i);
			buyer.addUtility(utility);
			tempUtil = 0;
		}
		
		
		buyer.printUtilities();
		
		
	}
	
	
	public static void printTable(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ,");
			}
			
		}
	}
}
