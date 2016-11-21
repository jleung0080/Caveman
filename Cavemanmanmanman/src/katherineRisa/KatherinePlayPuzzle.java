package katherineRisa;

import caveExplorer.CaveExplorer;

public class KatherinePlayPuzzle implements caveExplorer.Playable {
	
	public static String[][] original;
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

	public KatherinePlayPuzzle() {
		original = MainEvent.splitWordsArray;
		letters = MainEvent.splitWordsArray;
		grid = MainEvent.grid;
	}
	
	public void play() {
		for(int i = 0; i < original.length; i++){
			for(int j = 0; j < original[i].length; j++){
				System.out.println(original[i][j]);
			}
		}
		
		
		while(firstPlay){
			mixLetters(letters);
			makeBombs(letters);
			MainEvent.inputLetters(grid, letters);
			firstPlay = false;
		}
		swap(letters);
		MainEvent.inputLetters(grid, letters);
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
		if(response.toLowerCase().equals("yes")){
			giveHint(original, hints);
		}
		
		System.out.println("Type in the first coordinate of the letter you want to swap.");
		String coord1 = MainEvent.userInput();
		interpretAction(coord1, 0);
		
		System.out.println("Type in the second coordinate of the letter you want to swap with.");
		String coord2 = MainEvent.userInput();
		interpretAction(coord2, 1);
		
		String temp;
		temp = arr[coordinates[0][0]][coordinates[0][1]];
		arr[coordinates[0][0]][coordinates[0][1]] = arr[coordinates[1][0]][coordinates[1][1]];
		arr[coordinates[1][0]][coordinates[1][1]] = temp;
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
		else if(arr[0][0] == "c"){
			System.out.println(hints[0][hintIdx]);
			hintIdx++;
		}
		else if(arr[1][0] == "p"){
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

	public static void mixLetters(String[][] words){
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
				words[i][j] = temp[cntr];
				cntr ++;
			}
		}
	}
}
