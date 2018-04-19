package App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * in this case agents always try to respond optimaly
 */
public class IterativeBestResponse {
	Buyer buyer;
	ArrayList<Agent> agents;
	int n;
	
	public IterativeBestResponse(Buyer buyer, ArrayList<Agent> agents, int n) {
		this.buyer = buyer;
		this.agents = agents;
		this.n = n;
	}
	
	public void iterativeBestResponse() {
		
		//all available sets of items
		BinaryTable bt = new BinaryTable(this.n);
		int[][] table = bt.getBinTable();
		//agents always look for their best choice
		
		
		System.out.print("price = ");
		for (Agent a : this.agents) {
			System.out.print(a.getPrice() + " , ");
		}
		int maxUtility = -1;
		int indexBought = -1;
		
		for (int day = 0; day < 50; day++) {
			Agent agent = agents.get(day%this.n);
			//calculate which set the buyer is willing to buy
			this.buyer.clearUtilityArray();
			calculateUtilityTable();
			System.out.print("utilities = ");
			System.out.println(this.buyer.getUtilities());
			
			
			for (int i = 0; i < this.buyer.getUtilities().size(); i++) {
				if (this.buyer.getUtilities().get(i) >= maxUtility) {
					maxUtility = this.buyer.getUtilities().get(i);
					indexBought = i;
				}
			}
			
			//no matter if his product is sellected
			System.out.println();
			printArr(table[indexBought]);
			
			ArrayList<Integer> options = new ArrayList<Integer>();
			for (int i = 0; i < table.length; i++) {
				if (table[i][agent.getId()] == 1) {
					int othersWeight = 0;
					for (Agent ag : this.agents) {
						if (!ag.equals(agent)) {
							if (table[i][ag.getId()] == 1) {
								othersWeight += ag.getPrice();
							}
							//othersWeight += table[i][ag.getId()] * ag.getPrice();
						}
					}
					options.add(this.buyer.getValuations().get(indexBought) - othersWeight);
				}else {
					options.add(0);
				}
			}
			agent.setPrice(Collections.max(options));
			System.out.println(agent.getPrice());
			System.out.println(options);
			options.clear();
			System.out.println(agent.getId() +  " price is formed as : " +agent.getPrice());
		}
		
	}
	
	
	public void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "|");
		}
		System.out.println();
	}
	
	
	public void calculateUtilityTable() {
		BinaryTable binTable = new BinaryTable(this.n);
		int [][] binTab = binTable.getBinTable();
		int tempUtil = 0;
		int utility;
		
		for (int i = 0; i < binTab.length; i++) {
			for (int j = 0; j < n; j++) {
				binTab[i][j] = binTab[i][j] * (-1) * this.agents.get(j).getPrice();
				tempUtil += binTab[i][j];
			}
			utility = tempUtil + this.buyer.valuations.get(i);
			this.buyer.addUtility(utility);
			tempUtil = 0;
		}
	}
	
	
	
}
