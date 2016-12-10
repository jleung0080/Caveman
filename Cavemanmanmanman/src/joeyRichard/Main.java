package joeyRichard;

import java.util.Scanner;

import caveExplorer.Playable;

public class Main implements Playable{
	public static String[][] grid = new String[8][15];
	public static boolean[][] check = new boolean[grid.length][grid[0].length];
	public static String direction;
	static Scanner input = new Scanner(System.in); 
	static boolean inLoop = true;
	static boolean playerResults;
	public static int[] vertical = {2,3,5,7,8,10,11,12,13,14};
	public static int[] horizontal = {0,1,4,6,9,15};
	private static final String[] SEQUENCE_1 = {"You have collected all your presents and are ready to go!", "Looking far in the distance, you see another Santa getting ready to go too!",
			"There can only be one Santa", "FIRST ONE OUT GETS TO BE THIS YEAR'S SANTA!! XDDDD"};
	private static final String[] SEQUENCE_2 = {"After a long battle of wits, you finally got out of your driveway", "After giving the other Santa the finger(thumbs up of course), you hurry off to deliver presents"};
	private static final String[] SEQUENCE_3 = {"The other Santa got out of his driveway first!!!!", "As a fellow Santa, it hurts your little heart to see someone else take your job", "In your bag of goodies you remember that"
			+  " you have a TIME MACHINE!!!!" + "So..... Lets try this again!!"};
	public static boolean playerWin = false;
	public static boolean cpuWin = false;
	
	
	public void play(){
		readSequence(SEQUENCE_1);
		RichardClass.createCars();
		RichardClass.printMap();
		while(!gameEnd()){
			RichardClass.move();
			if(gameEnd()){
				break;
			}
			JoeyClass.computerMove();
		}
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			System.out.println(s);
			System.out.println("- - - press enter - - -");
			input.nextLine();
		}
	}

	public static int findKeyword(String searchString, String keyword, int startPsn) {
		searchString = searchString.trim();
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		int psn = searchString.indexOf(keyword);
		while(psn>=0){
			String before = " ";
			String after = " ";
			if(psn>0){
				before = searchString.substring(psn-1, psn);
			}
			if(psn+keyword.length() < searchString.length()){
				after = searchString.substring((psn + keyword.length()), 
						psn + keyword.length()+1);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
				return psn;
			}else{
				psn = searchString.indexOf(keyword,psn+1);
			}
		}
		return -1;
	}


	
	public static int roll(){
		return (int)(Math.random()*6+1);
	}


	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

	public static int getInt(){
		String integerString = promptInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			}catch(NumberFormatException e){
				System.out.println("You must enter an integer.");
				integerString = promptInput();
			}
		}
		return value;
	}
	public static boolean gameEnd(){
		if(RichardClass.zero.location[RichardClass.zero.location.length-1][1] == 14 || playerWin == true){
			playerWin = true;
			readSequence(SEQUENCE_2);
			return true;
		}
		if(RichardClass.one.location[0][1] == 0 || cpuWin == true){
			cpuWin = true;
			readSequence(SEQUENCE_3);
			return true;
		}
		return false;
	}

	
}