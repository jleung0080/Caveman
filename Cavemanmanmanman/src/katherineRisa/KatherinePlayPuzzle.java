package katherineRisa;

import caveExplorer.CaveExplorer;

public class KatherinePlayPuzzle implements caveExplorer.Playable {
	
	private static String[][] letters;
	private static String[][] grid;
	private static int[][] coordinates = new int[2][2];

	public KatherinePlayPuzzle() {
		letters = MainEvent.splitWordsArray;
		grid = MainEvent.grid;
	}

	public void play() {
		mixLetters(letters);
		MainEvent.inputLetters(grid, letters);
		swap(letters);
		MainEvent.inputLetters(grid, letters);
	}

	
	private void swap(String[][] arr) {
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
						return false;
					}
					return false;
				}
			}
			return false;
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