package haoSyed;

import caveExplorer.CaveExplorer;

import java.util.Random;
import java.util.Scanner;
import caveExplorer.Playable;

public class TilesGameStart implements Playable {

	private static final String[] SEQUENCE_1 = {"Bells jingle in the distance", "Ho, Ho, Ho, solve this puzzle to show your holiday spirit"};
	
	private static final String[] SEQUENCE_2 = {"By Blixen you've done it", "The door opens", "Merry Christmas!!!!"};
	
	static int board1[][] = new int[4][4];
	static int board2[][] = new int[4][4];
	static boolean flippedCardsBoard1[][] = new boolean[4][4];
	static boolean flippedCardsBoard2[][] = new boolean[4][4];
	
	static Scanner input = new Scanner(System.in);
	
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	
	//ASK NOCKLES MONDAY
		public void play() {
			readSequence(SEQUENCE_1);
			int board1FlippedCards = 16;
			int board2FlippedCards = 16;
			displayBoard1(flippedCardsBoard1, board1);
			displayBoard2(flippedCardsBoard2, board2);
			int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
			board1 = randomizer1();
			board2 = randomizer2();
			while (board1FlippedCards > 0 && board2FlippedCards > 0){
				System.out.println("Which board would you like to play from?");
				String selection = input.nextLine();
				if (selection.equals("skip")){
					board1FlippedCards = 0;
					board2FlippedCards = 0;
					for (int i = 0; i < 4; i++){
						for (int j = 0; j < 4; j++){
							flippedCardsBoard1[i][j] = true;
							flippedCardsBoard2[i][j] = true;
						}
					}
				}
				else if (selection.equals("restart")){
					System.out.println("Too hard? Ho-ho-hope you get better luck and memory this time!");
					board1FlippedCards = 16;
					board2FlippedCards = 16;
					for (int i = 0; i < 4; i++){
						for (int j = 0; j < 4; j++){
							flippedCardsBoard1[i][j] = false;
							flippedCardsBoard2[i][j] = false;
						}
					}
					board1 = randomizer1();
					board2 = randomizer2();
					displayBoard1(flippedCardsBoard1, board1);
					displayBoard2(flippedCardsBoard2, board2);
				}
				else if (selection.equals("1")){
					displayBoard1(flippedCardsBoard1, board1);
					System.out.println("Enter the coordinates for your first card");
					String x = input.nextLine();
					if (x.length() != 2){
						System.out.println("You need to put 2 numbers.");
					}
					else {
						int x1 = Integer.valueOf(x.substring(0, 1)) - 1;
						int x2 = Integer.valueOf(x.substring(1, 2)) - 1;
						System.out.println("The card reads " + board1[x1][x2] + ".");
					
						System.out.println("Enter the coordinates for your second card");
						String y = input.nextLine();
						if (y.length() != 2){
							System.out.println("You need to put 2 numbers.");
						}
						else{
							int y1 = Integer.valueOf(y.substring(0, 1)) - 1;
							int y2 = Integer.valueOf(y.substring(1, 2)) - 1;
							System.out.println("The card reads " + board1[y1][y2] + ".");
							if (x1 == y1 && x2 == y2){
								System.out.println("You can't pick the same tile twice!");
							}
							else if (board1[x1][x2] == board1[y1][y2]){
								System.out.println("Nice!");
								flippedCardsBoard1[x1][x2] = true;
								flippedCardsBoard1[y1][y2] = true;
								board1FlippedCards -= 2;
								flippedCardsBoard2[x1][x2] = true;
								flippedCardsBoard2[y1][y2] = true;
								board2FlippedCards -= 2;
								displayBoard1(flippedCardsBoard1, board1);
							}
							else{
								System.out.println("Try again.");
							}
						}
					}
				}
				else if (selection.equals("2")){
					System.out.println("Enter the coordinates for your first card");
					displayBoard2(flippedCardsBoard2, board2);
					String i = input.nextLine();
					if (i.length() != 2){
						System.out.println("You need to put 2 numbers.");
					}
					else {
						int i1 = Integer.valueOf(i.substring(0, 1)) - 1;
						int i2 = Integer.valueOf(i.substring(1, 2)) - 1;
						System.out.println("The card reads " + board2[i1][i2] + ".");
						
						System.out.println("Enter the coordinates for your second card");
						String j = input.nextLine();
						if (j.length() != 2){
							System.out.println("You need to put 2 numbers.");
						}
						else{
							int j1 = Integer.valueOf(j.substring(0, 1)) - 1;
							int j2 = Integer.valueOf(j.substring(1, 2)) - 1;
							System.out.println("The card reads " + board2[j1][j2] + ".");
							if (i1 == j1 && i2 == j2){
								System.out.println("You can't pick the same tile twice!");
							}
							else if (board2[i1][i2] == board2[j1][j2]){
								System.out.println("Nice!");
								flippedCardsBoard1[i1][i2] = true;
								flippedCardsBoard1[j1][j2] = true;
								board1FlippedCards -= 2;
								flippedCardsBoard2[i1][i2] = true;
								flippedCardsBoard2[j1][j2] = true;
								board2FlippedCards -= 2;
							}
							else{
								System.out.println("Try again.");
							}
						}
					}
				}
				else{
					System.out.println("That is not a valid board");
				}
			}
			displayBoard1(flippedCardsBoard1, board1);
			displayBoard2(flippedCardsBoard2, board2);
			readSequence(SEQUENCE_2);
		}
	
	public static void createGrid() {//adjust for haoSyed
            for (int i = 0; i < 4; i++) {
            	for (int a = 0; a < 4; a++) {
                flippedCardsBoard1[i][a]=false;
                flippedCardsBoard2[i][a]=false;
                }
            }
   	}
	public static void TilesGameStart() {
		
	}

	private static void displayBoard2(boolean flippedCardsBoard2[][], int[][] board2) {//adjust boolean and int to haoSyed

        System.out.println("   |     1     |     2     |     3     |     4     ");
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int a = 0; a < 4; a++) {
                if (flippedCardsBoard2[i][a]) {
                    System.out.print("|     " + board2[i][a]+ "    ");
                    System.out.print(" ");
                }
                else
                    System.out.print("|     *     ");
            }
            System.out.println();
        }
        System.out.println();
    }

	private static void displayBoard1(boolean flippedCardsBoard1[][], int[][] board1) {//adjust boolean and int to haoSyed

        System.out.println("   |     1     |     2     |     3     |     4     ");
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int a = 0; a < 4; a++) {
                if (flippedCardsBoard1[i][a]) {
                    System.out.print("|     " + board1[i][a]+ "    ");
                    System.out.print(" ");
                }
                else
                    System.out.print("|     ?     ");
            }
            System.out.println("");
        }
        System.out.println("");
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
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}
}
