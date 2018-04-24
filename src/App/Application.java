package App;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		/*
		 * this problem is equal to the combinatorial auction
		 * our goal is to find equilibrium in online markets
		 * the setup is as follows 
		 * "n Sellers, each selling a unique item"
		 * "One buyer with a private combinatorial valuation"
		 * "Sellers (= Agents) set their prices in order to maximize their income"
		 * "buyer decides to buy a bundle of products based on his utility"
		 */
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of sellers");
		
		int n = in.nextInt();			//number of sellers (each seller handles one item)
		
		//Initializing agents (Sellers)
		ArrayList<Agent> agents = new ArrayList<Agent>();
		
		System.out.println("0 : to initialize sellers with pi = 0");
		System.out.println("1 : to initialize sellers with pi = RANDOM");
		System.out.println("2 : to initialize sellers with pi = MAX_PRICE");
		int k = in.nextInt();
		for (int i = 0; i < n; i++) {
			Agent agent = new Agent(i, k);
			agents.add(agent);
		}
		//printAgents(agents);
		
		//Initializing buyer
		System.out.println("0 : for combinatorial buyer");
		System.out.println("1 : for submodular2 buyer");
		System.out.println("2 : for custom valuations");
		System.out.println("3 : for submodular buyer - using set cover");
		System.out.println("4 : for single minded buyers");
		k = in.nextInt();
		Buyer buyer = new Buyer(k, n);
		
		printBuyer(buyer);
		System.out.println("\n");
		 
		//Call Iterative Response
		
		
		IterativeResponse ir = new IterativeResponse(buyer, agents, n);
//		iterative response
		ir.IterResp();		//changes price by one
		
//		IterativeBestResponse ibr = new IterativeBestResponse(buyer, agents, n);
//		ibr.iterativeBestResponse();
		 
		
		//IterativeBestResponse ibr = new IterativeBestResponse(buyer, agents, n);
		//ibr.iterativeBestResponse();
		
		
	}
	
	public static void printBuyer(Buyer buyer) {
		System.out.println( "Buyer's Valuation : " + buyer.getValuations());
	}
	
	public static void printAgents(ArrayList<Agent> agents) {
		for (Agent agent : agents) {
			System.out.println(agent.getPrice());
		}
	}

}