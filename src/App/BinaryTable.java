package App;

public class BinaryTable {
	
	int[][] binTable;
	int n;
	
	public BinaryTable(int n) {
		this.n = n;
		this.binTable = initBinaryTable(n);
	}
	
	public static int[][] initBinaryTable(int n){
		int[][] binArr = new int[(int) Math.pow(2, n)][n];
		
		for (int i = 0; i < Math.pow(2, n); i++) {
			String bin = Integer.toBinaryString(i);
			int temp = n - bin.length();
			String tem = "";
			for (int t = 0; t < temp; t++) {
				tem += "0";
			}
			bin = tem + bin;
			//System.out.println(bin);
			for (int j = 0; j < n; j++) {
				String s = bin.charAt(j) + "";
				binArr[i][j] = Integer.parseInt(s);
				//System.out.print(binArr[i][j] + " ");
			}
		}
		
		return binArr;
	}
	
	public int[][] getBinTable() {
		return this.binTable;
	}
	
	public void printBinTable() {
		for (int i = 0; i < this.binTable.length; i++) {
			for (int j = 0; j < this.binTable[0].length; j++) {
				System.out.print(this.binTable[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	public int[] getBundle(int row) {
		int [] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = this.binTable[row][i];
		}
		
		return arr;
	}
	
}
