package App;

import java.util.Random;
import java.util.Scanner;

public class InitPrice {
	
	int price;
	
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
		else {
			Random r = new Random();
			return (r.nextInt(1000));
		}
	}
}
