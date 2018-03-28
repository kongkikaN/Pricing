package App;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		int n = 3;			//number of sellers (each seller handles one item)
		
		//Initializing agents (Sellers)
		ArrayList<Agent> agents = new ArrayList<Agent>();
		
		Scanner in = new Scanner(System.in);
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
		System.out.println("1 : for submodular buyer");
		k = in.nextInt();
		Buyer buyer = new Buyer(k, n);
		
		printBuyer(buyer);
		System.out.println("\n");
		
		//Call Iterative Best Response
		IterativeBestResponse ibr = new IterativeBestResponse(buyer, agents, n);
		ibr.IterBestResp();
		
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