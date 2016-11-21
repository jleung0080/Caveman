package katherineRisa;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoomPd8;
import caveExplorer.Door;
import katherineRisa.RisaCheckSolution;

public class KatherinePlayPuzzle implements caveExplorer.Playable {
	
	private static String[][] original;
	public static String[][] letters;
	private static String[][] grid;
	private static int[][] coordinates = new int[2][2];
	private static boolean firstPlay = true;
	private static String[][] hints = {{"First Row : Candy you would see for sure on Christmas.", 
									    "Second Row : Something chocolate is made from.", 
									    "Third Row : What should you leave for Santa?"},
									   {"First Row : For the ladies who want to smell nice.", 
									    "Second Row : Something comfortable to walk indoors.", 
									    "Third Row : A synonym for clothes maybe?"},
									   {"First Row : A common item to hold your hot chocolate.", 
									    "Second Row : Something to place your cookies in.", 
									    "Third Row : What would you use to feed a baby milk?"}};
	private static int hintIdx = 0;
	public static boolean gameWon = false;

	public KatherinePlayPuzzle() {
		original = MainEvent.splitWordsArray;
		letters = MainEvent.splitWordsArray;
		grid = MainEvent.grid;
	}
	
	public void play() {
		while(!gameWon){
			
			while(firstPlay){
				if(gameWon){
					break;
				}
				letters = mixLetters(letters);
				makeBombs(letters);
				MainEvent.inputLetters(grid, letters);
				firstPlay = false;
			}
			if(gameWon){
				break;
			}
			swap(letters);
			if(RisaCheckSolution.complete == false){
				if(gameWon){
					break;
				}
				MainEvent.inputLetters(grid, letters);
				MainEvent.risaPuzzle.play();
			}
		}
	}
	
	private boolean gameEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	private void makeBombs(String[][] arr) {
		int num = (int) (Math.random()*3) + 1;
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				if(num > 0 && arr[row][col] == " "){
					if(row != 1){
						arr[row][col] = "!";
						num --;
					}
				}
			}
		}
	}

	private void swap(String[][] arr) {
		System.out.println("Would you like a hint?");
		String response = MainEvent.userInput();
		if(response.toLowerCase().equals("cheat")){
			cheatCode();
			
		}else{
		if(response.toLowerCase().equals("yes")){
			giveHint(original, hints);
		}
		
		System.out.println("Type in the first coordinate of the letter you want to swap.");
		String coord1 = MainEvent.userInput();
		interpretAction(coord1, 0);
		
		System.out.println("Type in the second coordinate of the letter you want to swap with.");
		String coord2 = MainEvent.userInput();
		interpretAction(coord2, 1);
		
		if(coordinates[0][0] == (coordinates[1][0] - 1) || coordinates[0][0] == (coordinates[1][0] + 1) || coordinates[0][1] == (coordinates[1][1] - 1) || coordinates[0][1] == (coordinates[1][1] + 1)){
			String temp;
			temp = arr[coordinates[0][0]][coordinates[0][1]];
			arr[coordinates[0][0]][coordinates[0][1]] = arr[coordinates[1][0]][coordinates[1][1]];
			arr[coordinates[1][0]][coordinates[1][1]] = temp;
		}
		else{
			System.out.println("You can only swap adjacent pieces.");
		}
		}
		
	}

	public void interpretAction(String input, int n) {
		while(!isValid(input, n)){
		CaveExplorer.print("Please enter a valid coordinate.");
		input = MainEvent.userInput();
		}
	}
	
	private void giveHint(String[][] arr, String[][] hints) {
		if(hintIdx == 3){
			System.out.println("I would love to give you more hints, but you are limited to only 3.");
		}
		else if(arr[0][0].substring(0,  1) == "c"){
			System.out.println(hints[0][hintIdx]);
			hintIdx++;
		}
		else if(arr[1][0].substring(0,  1) == "p"){
			System.out.println(hints[1][hintIdx]);
			hintIdx++;
		}
		else{
			System.out.println(hints[2][hintIdx]);
			hintIdx++;
		}
	}
	
	private boolean isValid(String input, int n) {
		String[] validRow = new String[grid.length/3];
		String[] validCol = new String[grid[0].length/6];
		
		for(int i = 0; i < validRow.length; i++){
			validRow[i] = "" + i; 
		}
		
		for(int i = 0; i < validCol.length; i++){
			validCol[i] = "" + i;
		}
		
		String coord;
		
		for(int i = 0; i < input.length(); i++){
			coord = input.substring(i, i + 1);
			for(String rowKey : validRow){
				if(coord.equals(rowKey)){
					coordinates[n][0] = Integer.parseInt(coord); //converts string to integer
					for(int j = i + 1; j < input.length(); j++){
						coord = input.substring(j, j + 1);
						for(String colKey : validCol){
							if(coord.equals(colKey)){
								coordinates[n][1] = Integer.parseInt(coord);
								return true;
							}
						}
					}
					return false;
				}
			}
		}
		return false;
	}

	public static String[][] mixLetters(String[][] words){
		String[][] mixedArray = new String[words.length][words[0].length];
		String[] temp = new String[words.length * words[0].length];
		int cntr = 0;
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j < words[i].length; j++){
				temp[cntr] = words[i][j];
				cntr ++;
			}
		}
		
		String placeHolder;
		for(int i = 0; i < temp.length; i++){
			int rnd = (int)(Math.random()*temp.length);
			placeHolder = temp[i];
			temp[i] = temp[rnd];
			temp[rnd] = placeHolder;
		}
		
		cntr = 0;
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j < words[i].length; j++){
				mixedArray[i][j] = temp[cntr];
				cntr ++;
			}
		}
		return mixedArray;
	}
	
	private static void cheatCode(){
			RisaCheckSolution.complete = true;
			MainEvent.inputLetters(grid, original);
			System.out.println("You did it. Now on to the next job.");
			CaveExplorer.caves[1][2].setConnection(CaveRoomPd8.EAST, CaveExplorer.caves[1][3], new Door(true, false));
			gameWon = true;
	}
}
