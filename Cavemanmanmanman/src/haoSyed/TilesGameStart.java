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

		public void play() {
			readSequence(SEQUENCE_1);
			int board1FlippedCards = 16;
			int board2FlippedCards = 16;
			SyedDisplayBoard.displayBoard1(flippedCardsBoard1, board1);
			SyedDisplayBoard.displayBoard2(flippedCardsBoard2, board2);
			board1 = HaoRandomize.randomizer1();
			board2 = HaoRandomize.randomizer2();
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
				}else if (selection.equals("restart")){
					HaoRandomize.reset(board1FlippedCards, board2FlippedCards, flippedCardsBoard1, flippedCardsBoard2);
					SyedDisplayBoard.displayBoard1(flippedCardsBoard1, board1);
					SyedDisplayBoard.displayBoard2(flippedCardsBoard2, board2);
					board1 = HaoRandomize.randomizer1();
					board2 = HaoRandomize.randomizer2();
				}else if (selection.equals("1")){
					SyedDisplayBoard.displayBoard1(flippedCardsBoard1, board1);
					System.out.println("Enter the coordinates for your first card");
					String x = input.nextLine();
					if (x.length() != 2){
						System.out.println("You need to put 2 numbers.");
					}else {
						int x1 = Integer.valueOf(x.substring(0, 1)) - 1;
						int x2 = Integer.valueOf(x.substring(1, 2)) - 1;
						System.out.println("The card reads " + board1[x1][x2] + ".");
						System.out.println("Enter the coordinates for your second card");
						String y = input.nextLine();
						if (y.length() != 2){
							System.out.println("You need to put 2 numbers.");
						}else{
							int y1 = Integer.valueOf(y.substring(0, 1)) - 1;
							int y2 = Integer.valueOf(y.substring(1, 2)) - 1;
							System.out.println("The card reads " + board1[y1][y2] + ".");
							if (HaoRandomize.checkMatch(board1, board2, x1, x2, y1, y2)){
								HaoRandomize.identifyMatch(board1, x1,x2,y1,y2, flippedCardsBoard1, flippedCardsBoard2);
								board1FlippedCards -= 2;
								board2FlippedCards -= 2;
								SyedDisplayBoard.displayBoard1(flippedCardsBoard1, board1);
							}else{
								System.out.println("Try again.");
							}
						}
					}
				}else if (selection.equals("2")){
					System.out.println("Enter the coordinates for your first card");
					SyedDisplayBoard.displayBoard2(flippedCardsBoard2, board2);
					String i = input.nextLine();
					if (i.length() != 2){
						System.out.println("You need to put 2 numbers.");
					}else {
						int i1 = Integer.valueOf(i.substring(0, 1)) - 1;
						int i2 = Integer.valueOf(i.substring(1, 2)) - 1;
						System.out.println("The card reads " + board2[i1][i2] + ".");
						System.out.println("Enter the coordinates for your second card");
						String j = input.nextLine();
						if (j.length() != 2){
							System.out.println("You need to put 2 numbers.");
						}else{
							int j1 = Integer.valueOf(j.substring(0, 1)) - 1;
							int j2 = Integer.valueOf(j.substring(1, 2)) - 1;
							System.out.println("The card reads " + board2[j1][j2] + ".");
							if (HaoRandomize.checkMatch(board1, board2, i1, i2, j1, j2)){
								HaoRandomize.identifyMatch(board1, i1,i2,j1,j2, flippedCardsBoard1, flippedCardsBoard2);
								board1FlippedCards -= 2;
								board2FlippedCards -= 2;
								SyedDisplayBoard.displayBoard2(flippedCardsBoard2, board2);
							}else{
								System.out.println("Try again.");
							}
						}
					}
				}else{
					System.out.println("That is not a valid board");
				}
			}
			SyedDisplayBoard.displayBoard1(flippedCardsBoard1, board1);
			SyedDisplayBoard.displayBoard2(flippedCardsBoard2, board2);
			readSequence(SEQUENCE_2);
		}

	public static void TilesGameStart() {
		
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}
}