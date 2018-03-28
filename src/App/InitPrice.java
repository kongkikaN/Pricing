package App;

import java.util.Random;
import java.util.Scanner;

public class InitPrice {
	
	int price;
	final int MAX_PRICE = (new FinalVariables()).getMAX_PRICE();
	
	/**
	 * if k == 0, all prices start with the value = 0;
	 * if k == 1, all prices start randomly from 0 - 1000
	 * @param k
	 */
	public InitPrice(int k) {
		getPrice(k);
	}
	public int getPrice(int k) {
		if (k == 0) {
			return 0;
		}
		else if (k == 1) {
			Random r = new Random();
			return (r.nextInt(MAX_PRICE));
		}
		else {
			return MAX_PRICE;
		}
	}
	
}
