package UtilityClasses;

import java.util.ArrayList;
import java.util.Random;

import App.BinaryTable;
import App.FinalVariables;

public class Submodular {
	
	ArrayList <Integer> valuations = new ArrayList<Integer>();
	
	int n;
	int m; //m >= n
	int setCover[][];
	int rows;
	int cols;
	int binTab[][];
	
	//initialize valuations for n products
	public Submodular(int n) {
		this.n = n;
		FinalVariables fv = new FinalVariables();
		this.m = fv.getMAX_VALUATION();
		this.setCover = new int [this.m][this.n];
		initSetCover();
		//printArr(this.setCover);
		initBinTab();
		//printArr(this.binTab);
		this.rows = this.binTab.length;
		this.cols = this.binTab[0].length;
		
		//algorithm for calculating valuations
		for (int i = 0; i < this.rows; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < this.cols; j++) {
				arr.add(binTab[i][j]);
			}
			calculateVal(arr);
			arr.clear();
		}
	}
	
	public void calculateVal(ArrayList<Integer> arr) {
		int[][] setCoverCopy = new int [this.m][this.n];
		
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				setCoverCopy[i][j] = arr.get(j) * this.setCover[i][j];
			}
		}
		this.valuations.add(getVal(setCoverCopy));
	}
	
	public int getVal(int [][] arr) {
		int sum = 0;
		for (int i = 0 ; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] ==  1) {
					sum += 1;
					j = arr[0].length +1;
				}
			}
		}
		return sum;
	}
	
	public void initBinTab() {
		BinaryTable bt = new BinaryTable(this.n);
		this.binTab = bt.getBinTable();
	}
	
	public void initSetCover() {
		Random r = new Random();
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				this.setCover[i][j] = r.nextInt(2);
			}
		}
	}
	
	public ArrayList<Integer> getValuations() {
		
		return this.valuations;
	}
	
	public void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ,");
			}
			System.out.println();
		}
	}
}