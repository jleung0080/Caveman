package haoSyed;

import java.util.Random;
import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class HaoRandomize {
	
	static Scanner input = new Scanner(System.in);
	
	
	public static String waitForEntry(){
		return input.nextLine();
	}

	public static int[][] randomizer1() {
		int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
	    int board1[][] = new int[4][4];
	    Random random = new Random();
	    int temp, t;
	    for (int j = 0; j <= 20; j++){
	        for (int x = 0; x < 16; x++){
	             t = random.nextInt(1000) % 15;
	             temp = num[x];
	             num[x] = num[t];
	             num[t] = temp;
	        }
	        t = 0;
	        for (int r = 0; r < 4; r++){
	            for (int s = 0; s < 4; s++){
	                board1[r][s] = num[t];
	                t = t + 1;
	            }
	        }
	    }
	       return board1;
	 }
	
	 public static int[][] randomizer2() {
		 int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
	     int board2[][] = new int[4][4];
	     Random random = new Random();
	     int temp, t;
	     for (int j = 0; j <= 20; j++){
	         for (int x = 0; x < 16; x++){
	             t = random.nextInt(1000) % 15;
	             temp = nums[x];
	             nums[x] = nums[t];
	             nums[t] = temp;
	         }
	         t = 0;
	         for (int r = 0; r < 4; r++){
	             for (int s = 0; s < 4; s++){
	                 board2[r][s] = nums[t];
	                 t = t + 1;
	             }
	         } 
	     }
	     return board2;
	     
	 }

	public static void identifyMatch(int[][] board1, int x1,int x2, int y1, int y2, boolean[][] flippedCardsBoard1,
		boolean[][] flippedCardsBoard2) {
		System.out.println("Nice!");
		flippedCardsBoard1[x1][x2] = true;
		flippedCardsBoard1[y1][y2] = true;
		flippedCardsBoard2[x1][x2] = true;
		flippedCardsBoard2[y1][y2] = true;		
	}

	public static boolean checkMatch(int[][] board1, int[][] board2, int x1, int x2, int y1, int y2) {
		if (x1 == y1 && x2 == y2){
			System.out.println("You can't pick the same tile twice!");
			return false;
		}
		if (board1[x1][x2] == board1[y1][y2]){
			return true;
		}
		return false;
	}

	public static void reset(int board1FlippedCards, int board2FlippedCards, boolean[][] flippedCardsBoard1,
			boolean[][] flippedCardsBoard2) {
		System.out.println("Too hard? Ho-ho-hope you get better luck and memory this time!");
		board1FlippedCards = 16;
		board2FlippedCards = 16;
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				flippedCardsBoard1[i][j] = false;
				flippedCardsBoard2[i][j] = false;
			}
		}
	}
}
