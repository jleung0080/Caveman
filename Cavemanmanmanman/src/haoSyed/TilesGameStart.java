package haoSyed;

import caveExplorer.CaveExplorer;
import java.util.Scanner;
import caveExplorer.Playable;

public class TilesGameStart implements Playable {

	private static final String[] SEQUENCE_1 = {"The door locks behind you.", "Something something solve this puzzle to escape."};
	
	private static final String[] SEQUENCE_2 = {"something soemthing solved puzzle", "something something door opens"};
	
	private static String[] board1Cards = {"present", "tree", "reindeer", "present", "santa", "elf", "jingle bells", 
			"star", "reindeer", "cookies", "cookies", "tree", "santa", "star", "jingle bells", "elf"};
	private static String[] board2Cards = {"santa", "elf", "santa", "reindeer", "present", "jingle bells", "star", 
			"tree", "star", "reindeer", "cookies", "tree", "jingle bells", "cookies", "jingle bells", "elf"};
	
	
	static int board1[][] = new int[4][4];
	static int board2[][] = new int[4][4];
	static boolean flippedCardsBoard1[][] = new boolean[4][4];
	static boolean flippedCardsBoard2[][] = new boolean[4][4];
	
	static Scanner input = new Scanner(System.in);
	
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	public static void main (String[] args){
		TilesGameStart();
		
	}
	
	public void play() {

	}
	
	public static void TilesGameStart() {
		readSequence(SEQUENCE_1);
		createGrid();
		int board1FlippedCards = 16;
		int board2FlippedCards = 16;
		while (board1FlippedCards > 0 && board2FlippedCards > 0){
			System.out.println("Which board would you like to play from?");
			if (waitForEntry() == "1"){
				displayBoard1();
				System.out.println("Enter the coordinates for your first card");
				String x = input.nextLine();
				int x1 = Integer.valueOf(x.substring(0, 1)) - 1;
				int x2 = Integer.valueOf(x.substring(0, 2)) - 1;
				System.out.print(board1[x1][x2]);
				
				System.out.println("Enter the coordinates for your second card");
				String y = input.nextLine();
				int y1 = Integer.valueOf(y.substring(0, 1)) - 1;
				int y2 = Integer.valueOf(y.substring(0, 2)) - 1;
				System.out.print(board1[y1][y2]);
				
				if (board1[x1][x2] == board1[y1][y2]){
					System.out.println("Nice!");
					flippedCardsBoard1[x1][x2] = true;
					flippedCardsBoard1[y1][y2] = true;
					board1FlippedCards -= 2;
				}
				else{
					System.out.println("Try again.");
				}
			}
			if (waitForEntry() == "2"){
				displayBoard2();
				System.out.println("Enter the coordinates for your first card");
				String i = input.nextLine();
				int i1 = Integer.valueOf(i.substring(0, 1)) - 1;
				int i2 = Integer.valueOf(i.substring(0, 2)) - 1;
				System.out.print(board2[i1][i2]);
				
				System.out.println("Enter the coordinates for your second card");
				String j = input.nextLine();
				int j1 = Integer.valueOf(j.substring(0, 1)) - 1;
				int j2 = Integer.valueOf(j.substring(0, 2)) - 1;
				System.out.print(board2[j1][j2]);
				
				if (board2[i1][i2] == board2[j1][j2]){
					System.out.println("Nice!");
					flippedCardsBoard2[i1][i2] = true;
					flippedCardsBoard2[j1][j2] = true;
					board2FlippedCards -= 2;
				}
				else{
					System.out.println("Try again.");
				}
			}
		}
		displayFinishedBoard();
		readSequence(SEQUENCE_2);
	}

	private void displayBoard2() {
		// TODO Auto-generated method stub
		
	}

	private void displayBoard1() {
		// TODO Auto-generated method stub
		
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}
	
}
