package katherineRisa;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class KatherinePlayPuzzle implements caveExplorer.Playable {
	
	private static String[][] letters;
	private static String[][] grid;
	private static Scanner in;
	private static int[][] coordinates;

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
		String input = MainEvent.userInput();
		interpretAction(input, 0);
		System.out.println("Type in the second coordinate of the letter you want to swap with.");
		String input2 = MainEvent.userInput();
		interpretAction(input2, 1);
		
		String temp;
		temp = arr[coordinates[0][0]][coordinates[0][1]];
		arr[coordinates[0][0]][coordinates[0][1]] = arr[coordinates[1][0]][coordinates[1][1]];
		arr[coordinates[1][0]][coordinates[1][1]] = temp;
	}
	
	public void interpretAction(String input, int n) {
		while(!isValid(input, n)){
			CaveExplorer.print("Please enter a valid coordinate.");
			input = in.nextLine();
		}
	}
	
	private boolean isValid(String input, int n) {
		String[] validRow = new String[grid.length/3];
		String[] validCol = new String[grid[0].length/6];
		
		int cntr = 0;
		String subInput;
		
		for(String rowKey : validRow){
			subInput = input.substring(cntr, cntr + 1);
			if(subInput.equals(rowKey)){
				for(String colKey : validCol){
					coordinates[n][0] = Integer.parseInt(subInput); //converts string to integer
					cntr ++;
					subInput = input.substring(cntr, cntr + 1);
					if(subInput.equals(colKey)){
						coordinates[n][1] = Integer.parseInt(subInput); 
						return true;
					}
				}
				
				return false;
			}
			
			cntr ++;
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