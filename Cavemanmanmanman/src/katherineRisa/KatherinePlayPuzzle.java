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

	public static boolean gameWon = false;

	public KatherinePlayPuzzle() {
		original = MainEvent.splitWordsArray;
		letters = MainEvent.splitWordsArray;
		grid = MainEvent.grid;
	}
	
	public void play() {
		while(!gameWon){
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

	private void swap(String[][] arr) {
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

	public void interpretAction(String input, int n) {
		while(!isValid(input, n)){
			CaveExplorer.print("Please enter a valid coordinate.");
			input = MainEvent.userInput();
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
}
