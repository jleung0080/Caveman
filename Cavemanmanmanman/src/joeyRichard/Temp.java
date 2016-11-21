package joeyRichard;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoomPd8;

public class Temp {
	private static String[][] grid = new String[8][15];
	private static boolean[][] check = new boolean[grid.length][grid[0].length];
	private static String map;
	static Scanner input = new Scanner(System.in); 
	static Cars two = new Cars("0", 2);
	static Cars three = new Cars("1", 3);
	static Cars four = new Cars("2", 4);
	static Cars five = new Cars("3", 3);
	static Cars six = new Cars("4", 2);
	static Cars seven = new Cars("5", 3);
	static Cars eight = new Cars("6", 4);
	static Cars nine = new Cars("7", 4);
	static Cars ten = new Cars("8", 3);
	static Cars eleven = new Cars("9", 3);
	static Cars twelve = new Cars("10", 2);
	static Cars thirteen = new Cars("11", 3);
	static Cars fourteen = new Cars("12", 4);
	static Cars fifteen = new Cars("13", 4);
	private int selectedCar;

	public static void main(String[] args){
		createCars();
				thirteen.setPos();
				for(int[] str:thirteen.location){
					for(int z:str){
						System.out.println(z);
					}
				}



		printMap();
	}
	public static void printMap(){
		String[] carNum = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen"};
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
					//lengths of 2 units
					else if(row == two.startPos[0] && count == two.startPos[1] && textRow == 1){
						map += "| 2 ";
					}
					else if(row == two.endPos[0] && count == two.endPos[1] && textRow == 0){
						map += "| 2 ";
					}
					else if(row == five.startPos[0] && count == five.startPos[1] && textRow == 1){
						map += "| 5 ";
					}
					else if(row == five.endPos[0] && count == five.endPos[1] && textRow == 0){
						map += "| 5 ";
					}
					else if(row == twelve.startPos[0] && count == twelve.startPos[1] && textRow == 1){
						map += "| 12";
					}
					else if(row == twelve.endPos[0] && count == twelve.endPos[1] && textRow == 0){
						map += "| 12";
					}
					//lengths of 3 units
					else if(row == three.startPos[0] && count == three.startPos[1] && textRow == 1){
						map += "| 3 ";
					}
					else if(row == (three.startPos[0] + three.endPos[0])/2 && count == three.startPos[1] && (textRow == 0 || textRow == 1)){
						map += "| 3 ";
					}
					else if(row == three.endPos[0] && count == three.endPos[1] && textRow == 0){
						map += "| 3 ";
					}
					else if(row == seven.startPos[0] && count == seven.startPos[1] && textRow == 1){
						map += "| 7 ";
					}
					else if(row == (seven.startPos[0] + seven.endPos[0])/2 && count == seven.startPos[1] && (textRow == 0 || textRow == 1)){
						map += "| 7 ";
					}
					else if(row == seven.endPos[0] && count == seven.endPos[1] && textRow == 0){
						map += "| 7 ";
					}
					else if(row == ten.startPos[0] && count == ten.startPos[1] && textRow == 1){
						map += "| 10";
					}
					else if(row == (ten.startPos[0] + ten.endPos[0])/2 && count == ten.startPos[1] && (textRow == 0 || textRow == 1)){
						map += "| 10";
					}
					else if(row == ten.endPos[0] && count == ten.endPos[1] && textRow == 0){
						map += "| 10";
					}
					else if(row == eleven.startPos[0] && count == eleven.startPos[1] && textRow == 1){
						map += "| 11";
					}
					else if(row == (eleven.startPos[0] + eleven.endPos[0])/2 && count == eleven.startPos[1] && (textRow == 0 || textRow == 1)){
						map += "| 11";
					}
					else if(row == eleven.endPos[0] && count == eleven.endPos[1] && textRow == 0){
						map += "| 11";
					}
					else if(row == thirteen.startPos[0] && count == thirteen.startPos[1] && textRow == 1){
						map += "| 13";
					}
					else if(row == (thirteen.startPos[0] + thirteen.endPos[0])/2 && count == thirteen.startPos[1] && (textRow == 0 || textRow == 1)){
						map += "| 13";
					}
					else if(row == thirteen.endPos[0] && count == thirteen.endPos[1] && textRow == 0){
						map += "| 13";
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
							map+="|   ";
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
		//function uses string and prints out board. we need to use getcontent to update mapping
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
		two.startPos = createPos(5,1);
		two.endPos = createPos(6,1);

		three.startPos = createPos(0,2);
		three.endPos = createPos(2,2);

		four.startPos = createPos(5,2);
		four.endPos = createPos(5,6);

		five.startPos = createPos(3,4);
		five.endPos = createPos(4,4);

		six.startPos = createPos(1,4);
		six.endPos = createPos(1,6);

		seven.startPos = createPos(2,6);
		seven.endPos = createPos(4,6);

		eight.startPos = createPos(0,7);
		eight.endPos = createPos(3,7);

		nine.startPos = createPos(2,8);
		nine.endPos = createPos(2,11);

		ten.startPos = createPos(4,8);
		ten.endPos = createPos(6,8);

		eleven.startPos = createPos(3,9);
		eleven.endPos = createPos(5,9);

		twelve.startPos = createPos(0,10);
		twelve.endPos = createPos(1,10);

		thirteen.startPos = createPos(5,10);
		thirteen.endPos = createPos(7,10);

		fourteen.startPos = createPos(0,12);
		fourteen.endPos = createPos(3,12);

		fifteen.startPos = createPos(7,11);
		fifteen.endPos = createPos(7,14);
	}

	private void move(){
		String direction;
		int spaces;
		System.out.println("Which car would you like to move? The player's car is 0 and the computer's car is 1.");
		selectedCar = getInt();
		System.out.println("Which direction would you like to move?");
		direction = selectDirection();
		while(!isValidDirection(direction)){
			direction = selectDirection();
		}
		System.out.println("How many spaces would you like to move the car in that direction?");
		spaces = getInt();
		while(intersects()){
			System.out.println("That is an invalid move. Please enter a valid number of spaces to move the car.");
			spaces = getInt();
		}

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
		if(selectedCar == 0 || selectedCar == 1 || selectedCar == 3 || 
				selectedCar == 5 || selectedCar == 6 || selectedCar == 8 || 
				selectedCar == 9 || selectedCar == 10 || selectedCar == 11 || selectedCar == 12){
			if(dir == "up"||dir == "down"){
				return true;
			}
			System.out.println("The selected car may only move up or down. Please select a valid direction.");
			return false;
		}else if(selectedCar == 2 ||selectedCar == 4||selectedCar == 7||selectedCar == 13){
			if(onEdge() || borderingCar()){

			}
			if(dir == "left"||dir == "right"){
				return true;
			}
			System.out.println("The selected car may only move left or right. Please select a valid direction.");
			return false;
		}else
			return false;
	}


	private boolean borderingCar() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean onEdge() {
		if(selectedCar==2){
			if(two.location[0][0] == 0 || two.location[two.location.length-1][0] == grid.length-1){
				
			}
		}
		if(selectedCar==1){
			if(two.location[0][0] == 0 || two.location[two.location.length-1][0] == grid.length-1){
				
			}
		}
		if(selectedCar==2){

		}
		if(selectedCar==3){

		}
		if(selectedCar==4){

		}
		if(selectedCar==5){

		}
		if(selectedCar==6){

		}
		if(selectedCar==7){

		}
		if(selectedCar==8){

		}
		if(selectedCar==9){

		}
		if(selectedCar==10){

		}
		if(selectedCar==11){

		}
		if(selectedCar==12){

		}
		if(selectedCar==13){

		}
		return false;
	}


	private static boolean intersects(){




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
