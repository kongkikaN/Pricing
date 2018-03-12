package App;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		int n = 3;			//number of sellers (each seller handles one item)
		
		//Initializing agents (Sellers)
		Scanner in = new Scanner(System.in);
		System.out.println("0 : to initialize sellers with pi = 0");
		System.out.println("1 : to initialize sellers with pi = RANDOM");
		int k = in.nextInt();
		
		printPrice(k, n);
		
		
		//Initializing buyer
		System.out.println("0 : for combinatorial buyer");
		System.out.println("1 : for submodular buyer");
		k = in.nextInt();
		Buyer buyer = new Buyer(k, n);
		
	}
	
	
	
	public static void printPrice(int k, int n) {
		for (int i = 0; i < n; i++) {
			Agent agent = new Agent(i, k);
			System.out.println( i + "'s price = " + agent.getPrice());
		}
	}

}