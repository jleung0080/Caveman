package haoSyed;

import caveExplorer.CaveExplorer;
import java.util.Scanner;
import caveExplorer.Playable;

public class TilesGameStart implements Playable {

	private static final String[] SEQUENCE_1 = {"The door locks behind you.", "Something something solve this puzzle to escape."};
	
	private static final String[] SEQUENCE_2 = {"something soemthing solved puzzle", "something something door opens"};
	
	private static String[] board1 = {"present", "tree", "reindeer", "present", "santa", "elf", "jingle bells", 
			"star", "reindeer", "cookies", "cookies", "tree", "santa", "star", "jingle bells", "elf"};
	private static String[] board2 = {"santa", "elf", "santa", "reindeer", "present", "jingle bells", "star", 
			"tree", "star", "reindeer", "cookies", "tree", "jingle bells", "cookies", "jingle bells", "elf"};
	
	static Scanner input = new Scanner(System.in);
	
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	public TilesGameStart() {
		
	}
	
	public static void main (String[] args){
		
	}
	
	public void play() {
		readSequence(SEQUENCE_1);
		createGrid();
		boolean inGameLoop = true;
		while (inGameLoop){
			System.out.println("Which board would you like to play from?");
			if (input.nextLine() == "1"){
				board1();
				if (!isMatch(askForTile(), askForSecondTile())){
					flipCards();
					System.out.println("Try again.");
					unflipCards();
				}
				else{
					flipCards();
					System.out.println("Nice!");
				}
			}
			else if (input.nextLine() == "2"){
				board2();
				if (!isMatch(askForTile(), askForSecondTile())){
					flipCards();
					System.out.println("Try again.");
					unflipCards();
				}
				else{
					flipCards();
					System.out.println("Nice!");
				}
			}
			else{
				System.out.println("Please type either '1' or '2'.");
			}
			if (gameCleared()){
				inGameLoop = false;
				readSequence(SEQUENCE_2);
			}
		}
		CaveExplorer.inventory.setHasMap(true);

	}
	
	/** These are for you
	private void unflipCards() {
		
		
	}

	private void flipCards() {
		
		
	}

	private void createGrid() {
		
		
	}
	
	private boolean gameCleared() {
		return false;
	}
	**/

	private String askForSecondTile() {
		String in = waitForEntry();
		System.out.println("What is the first tile you want to flip?");
		if (!isValid(in)){
			System.out.println("The letter '" + in + "' is not on the board. Please choose"
					+ " something that is on the board.");
		}
		return in;
	}

	private String askForTile() {
		String in = waitForEntry();
		System.out.println("What is the first tile you want to flip?");
		if (!isValid(in)){
			System.out.println("The letter '" + in + "' is not on the board. Please choose"
					+ " something that is on the board.");
		}
		return in;
	}

	private void board2() {
		// TODO Auto-generated method stub
		
	}

	private void board1() {
		// TODO Auto-generated method stub
		
	}

	public static boolean isMatch(String string, String string2){
		if (string == string2){
			return true;
		}
		return false;
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}
	
	public static boolean isValid(String input){
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p"};
		for (int i = 0; i < letters.length; i++){
			if (input != letters[i]){
				return false;
			}
		}
		return true;
	}
}
