package App;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class IterativeResponse {
	
	static Buyer buyer;
	static ArrayList<Agent> agents;
	static int n;
	
	public IterativeResponse(Buyer buyer, ArrayList<Agent> agents, int n) {
		IterativeResponse.buyer = buyer;
		IterativeResponse.agents = agents;
		IterativeResponse.n = n;
	}
	
	public static void IterResp() throws FileNotFoundException, UnsupportedEncodingException {
		
		//iterative response
		//changes price by one in each iteration without considering the prices of the other sellers
		
		PrintWriter r = new PrintWriter("test-YourNumber.txt" , "UTF-8");
		for (int day = 0; day < 100; day++) {
			
			System.out.println("---------------------------------------------");
			System.out.println("DAY " + day + "\n");
			//calculate utility of buyer
			calculateUtilityTable();
			
			//print buyers utility
			buyer.printUtilities();
			
			//get index of bundle (=id) the buyer will purchase
			int bundlePurchasedIndex = getIndexWithMaxUtil();
			System.out.println("bundle purchased id = " + bundlePurchasedIndex);
			
			BinaryTable bi = new BinaryTable(n);
			int[] bundlePurchased = bi.getBundle(bundlePurchasedIndex);
			//print the bundle the buyer will purchase
			
			
			//calculate sellers utility
			/*
			 * sellers utility = 0, if buyer doesn't purchase his product
			 * sellers utility = price, if buyer purchases his product
			 */
			
			for (int i = 0; i < n; i++) {
				agents.get(i).setUtility(bundlePurchased[i] * agents.get(i).getPrice());
			}
			
			//select a seller
			Agent seller = agents.get(day%n);		//select agent day % n
			
			/*
			 * if seller doesn't sell
			 * he will decrease the price he is charging
			 */
			if (bundlePurchased[agents.indexOf(seller)] == 0) {
				if (seller.getPrice() == 0) {
					System.out.println("\n Seller " + seller.id + " will not change his price");
				}
				else if (seller.getPrice() > 0) {
					seller.setPrice(seller.getPrice() - 1);
					System.out.println("\n Seller " + seller.id + " will decrease his price");
				}
			}
			/*
			 * if seller sells
			 * he will either increase his price (to get more money)
			 * or he will keep his price intact.
			 */
			else {
				int currentUtility = seller.getUtility();
				seller.setPrice(seller.getPrice() + 1);
				buyer.clearUtilityArray();
				calculateUtilityTable();
				int temporaryUtility = seller.getUtility();
				if (currentUtility < temporaryUtility) {
					seller.setPrice(seller.getPrice() -1);
					calculateUtilityTable();
					System.out.println("\n Seller " + seller.id + " will not change his price");
				}else {
					//everything is fine !!! good job increasing your price
					System.out.println("\n Seller " + seller.id + " will increase his price");
					seller.setUtility(seller.price);
				}
			}
			System.out.println("\n"  + " UTILITY TABLE WILL BECOME " );
			buyer.printUtilities();
			System.out.println("\n");
			printPrices(r);
			System.out.print("bundle purchased : { ");
			printTable(bundlePurchased);
			System.out.println("}");
			System.out.println();
			
			//at the end of the day clear workspace
			clearWorkspace();
		}
		
		r.close();
	}
	
	public static void printPrices(PrintWriter writer) throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println();
		
		System.out.print("Agent prices = {");
		for (Agent agent : agents) {
			System.out.print(agent.getPrice() + ", ");
			writer.print(agent.getPrice() + " ");
		}
		writer.println();
		System.out.println("}");
	}
	
	public static void calculateUtilityTable() {
		BinaryTable binTable = new BinaryTable(n);
		int [][] binTab = binTable.getBinTable();
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
	}
	
	public static void clearWorkspace() {
		buyer.clearUtilityArray();
	}
	
	public static int getIndexWithMaxUtil() {
		int max = 0;
		int index = 0;
		for (Integer util : buyer.getUtilities()) {
			if (util > max) {
				max = util;
				index = buyer.getUtilities().indexOf(util);
			}
		}
		return index;
	}
	
	public static void printTable(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ,");
			}
		}
	}
	
	public static void printTable(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}