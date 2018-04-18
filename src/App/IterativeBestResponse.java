package App;

import java.util.ArrayList;

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
		//agents always look for their best choice
		for (int day = 0; day < 3000; day++) {
			System.out.println(this.buyer.getUtilities());
			
		}
	}
}
