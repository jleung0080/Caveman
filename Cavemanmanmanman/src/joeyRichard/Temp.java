package joeyRichard;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoomPd8;

public class Temp {
	public static String[][] grid = new String[8][15];
	public static boolean[][] check = new boolean[grid.length][grid[0].length];
	private static String map;
	static Scanner input = new Scanner(System.in); 
	static Cars zero = new Cars("you", 2);
	static Cars one = new Cars("cpu", 2);
	static Cars two = new Cars(" 2 ", 2);
	static Cars three = new Cars(" 3 ", 3);
	static Cars four = new Cars(" 4 ", 4);
	static Cars five = new Cars(" 5 ", 3);
	static Cars six = new Cars(" 6 ", 2);
	static Cars seven = new Cars(" 7 ", 3);
	static Cars eight = new Cars(" 8 ", 4);
	static Cars nine = new Cars(" 9 ", 4);
	static Cars ten = new Cars(" 10", 3);
	static Cars eleven = new Cars(" 11", 3);
	static Cars twelve = new Cars(" 12", 2);
	static Cars thirteen = new Cars(" 13", 3);
	static Cars fourteen = new Cars(" 14", 4);
	static Cars fifteen = new Cars(" 15", 4);
	private int selectedCar;
	private int[] vertical = {2,3,5,7,8,10,11,12,13,14};
	private int[] horizontal = {0,1,4,6,9,15};
	private static final String[] SEQUENCE_1 = {"You have collected all your presents and are ready to go!", "Looking far in the distance, you see another Santa getting ready to go too!",
			"There can only be one Santa", "FIRST ONE OUT GETS TO BE THIS YEAR'S SANTA!! XDDDD"};
	private static final String[] SEQUENCE_2 = {"After a long battle of wits, you finally got out of your driveway", "After giving the other Santa the finger(thumbs up of course), you hurry off to deliver presents"};
	private static final String[] SEQUENCE_3 = {"The other Santa got out of his driveway first!!!!", "As a fellow Santa, it hurts your little heart to see someone else take your job", "In your bag of goodies you remember that"
			+  " you have a TIME MACHINE!!!!" + "So..... Lets try this again!!"};
	public static void main(String[] args){
		readSequence(SEQUENCE_1);
		createCars();
		printMap();
	}
	public static void readSequence(String[] seq){
		for(String s : seq){
			System.out.println(s);
			System.out.println("- - - press enter - - -");
			input.nextLine();
		}
	}
	public static void printMap(){
		map = " ";
		for(int i = 0; i < grid[0].length - 1; i++){
			map += "___ ";
		}

		map += "___\n";

		for(int row = 0; row<grid.length; row++){
			for(int textRow  = 0; textRow < 2; textRow++){
				for(int count = 0; count<grid[row].length; count++){
					if(row == (int)(grid.length/2) && count == 0 && textRow == 0){
						map+="EXIT";
					}
					else if(row == (int)(grid.length/2) && count == 0 && textRow == 1){
						map+=" ___";
					}
					else if(textRow == 1){
						map+="|___";
					}
					else{
						if(row == (int)(grid.length/2-1)&&count==grid[row].length-1){
							map+= "|EXIT";
						}
						else{
							if(grid[row][count] == null){
								map+="|   ";								
							}
							else{
								map+="|"+grid[row][count];
							}
						}
					}
				}
				if(row == (int)(grid.length/2-1)){
					map+= "\n";
				}else{
					map += "|\n";					
				}
			}
		}
		System.out.println(map);;
	}


	// WW           WW  HH     HH  YY     YY
	// WW           WW  HH     HH  YY     YY
	//  WW   WWW   WW   HH     HH   YY   YY
	//  WW   WWW   WW   HHHHHHHHH    YY YY
	//   WW WW WW WW    HHHHHHHHH     YYY
	//   WW WW WW WW    HH     HH     YYY
	//    WW     WW     HH     HH     YYY
	//    WW     WW     HH     HH     YYY      pls save us

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

	//creates an array that carries the coordinates for one point
	private static int[] createPos(int start, int end){
		int[] position = new int[2];
		position[0] = start;
		position[1] = end;
		return position;
	}

	//creates all the obstacle cars
	public static void createCars(){
		for(boolean[] row: check){
			for(boolean col: row){
				col = false;
			}
		}
		


		zero.startPos = createPos(3,0);
		zero.endPos = createPos(3,1);
		zero.setPos();

		one.startPos = createPos(4,13);
		one.endPos = createPos(4,14);
		one.setPos();

		two.startPos = createPos(5,1);
		two.endPos = createPos(6,1);
		two.setPos();

		three.startPos = createPos(0,2);
		three.endPos = createPos(2,2);
		three.setPos();

		four.startPos = createPos(5,2);
		four.endPos = createPos(5,6);
		four.setPos();

		five.startPos = createPos(2,4);
		five.endPos = createPos(3,4);
		five.setPos();

		six.startPos = createPos(1,4);
		six.endPos = createPos(1,6);
		six.setPos();

		seven.startPos = createPos(2,6);
		seven.endPos = createPos(4,6);
		seven.setPos();

		eight.startPos = createPos(0,7);
		eight.endPos = createPos(3,7);
		eight.setPos();

		nine.startPos = createPos(2,8);
		nine.endPos = createPos(2,11);
		nine.setPos();

		ten.startPos = createPos(4,8);
		ten.endPos = createPos(6,8);
		ten.setPos();

		eleven.startPos = createPos(3,9);
		eleven.endPos = createPos(5,9);
		eleven.setPos();

		twelve.startPos = createPos(0,10);
		twelve.endPos = createPos(1,10);
		twelve.setPos();

		thirteen.startPos = createPos(5,10);
		thirteen.endPos = createPos(7,10);
		thirteen.setPos();

		fourteen.startPos = createPos(0,12);
		fourteen.endPos = createPos(3,12);
		fourteen.setPos();

		fifteen.startPos = createPos(7,11);
		fifteen.endPos = createPos(7,14);
		fifteen.setPos();
	}

	private void move(){
		String direction;
		int numberOfMoves = roll();
		int spaces;
		System.out.println("Which sleigh would you like to move? Your sleigh is 0 and the other santa's sleigh is 1.");
		selectedCar = getInt();
		System.out.println("Which direction would you like to move?");
		direction = selectDirection();
		while(!isValidDirection(direction)){
			direction = selectDirection();
		}
		System.out.println("How many spaces would you like to sleigh the car in that direction?");
		spaces = getInt();
		while(intersects()){
			System.out.println("That is an invalid move. Please enter a valid number of spaces to move the sleigh.");
			spaces = getInt();
		}

	}
	
	private static int roll(){
		return (int)(Math.random()*6+1);
	}
	
	private String selectDirection(){
		// TODO Auto-generated method stub
		String directionChoice = promptInput().toLowerCase();

		while(!isDir(directionChoice)){
			System.out.println("Please enter one of the following: 'up', 'down', 'left', 'right'");
			directionChoice = promptInput();
		}
		String[] keys = {"up", "down", "left", "right"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(directionChoice)){
				indexFound = i;
				break;
			}
		}

		System.out.println(keys[indexFound]);
		return keys[indexFound];
	}


	private boolean isDir(String directionChoice) {
		// TODO Auto-generated method stub
		String[] validDir = {"up", "down", "left", "right"};
		for(String key : validDir){
			if(directionChoice.equals(key))
				return true;
		}
		return false;
	}


	private boolean isValidDirection(String dir) {
		for(int car:vertical){
			if(selectedCar == car){
				if(dir == "up"||dir == "down"){
					return true;
				}
				System.out.println("The selected car may only move up or down. Please select a valid direction.");
				return false;
			}
		}
		for(int car: horizontal){
			if(selectedCar == car){
				if(dir == "left"||dir == "right"){
					return true;
				}
				System.out.println("The selected car may only move left or right. Please select a valid direction.");
				return false;
			}
		}
		return false;
	}


	private boolean borderingCar() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean onEdge() {
		
		return false;
	}


	private static boolean intersects(){
		for
		return false;
	}


	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

	private int getInt(){
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

}