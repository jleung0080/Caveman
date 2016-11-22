package katherineRisa;

import java.util.Scanner;

public class MainEvent implements caveExplorer.Playable{
	static Scanner input;
	
	private static final String[] DESCRIPTION = {"Ugh. Getting all those gifts were tiring. At least you were here to help.",
												 "Wait what are you doing?",
												 "There's no time to relax. You can have that cup of hot chocolate later.",
												 "Your next job is to put the gifts into the bags.",
												 "See those tags right there?",
												 "Make sure the correct items are put in.",
												 "It's not as simple as it sounds so you might want to get started now."};
	private static final String[] DIRECTIONS = {"On each tag there are three words.", 
												"Each word is scrambled so the letters are all over the place.",
												"Put the letters back together to form a complete word.",
												"To do this, type in the coordinates of the pieces you would like to swap.",
												"I'll give you a hint: there is one word in each row.",
												"If you need an extra hint, just type yes!",
												"Oh, and, before you start, make sure not to swap the '!' pieces with the middle pieces!"};
	
	static caveExplorer.Playable katherinePuzzle;
	static caveExplorer.Playable risaPuzzle;
	
	static String[][] grid;
	private static String[][] words = {{"candycane", "cocoa", "cookies"}, {"perfume", "slippers", "apparel"}, {"mugs", "jars", "bottles"}};
	static String[][] splitWordsArray;
	
	public void play(){
		game();
	}
	
	public static void game(){
		input = new Scanner(System.in);
		readSequence(DESCRIPTION);
		readSequence(DIRECTIONS);
		
		grid = new String[11][62];
		makeGrid(grid);
		splitWordsArray = splitWords(words, grid[0]);
		inputLetters(grid, splitWordsArray);
		createFields();
		katherinePuzzle.play();
		risaPuzzle.play();	
	}

	public static String userInput(){
		String uInput = input.nextLine();
		return uInput;
	}
	
	private static void createFields() {
		katherinePuzzle = new KatherinePlayPuzzle();
		risaPuzzle = new RisaCheckSolution();
		
	}

	public static void inputLetters(String[][] grid, String[][] words) {
		int row = 2;
		for(int i = 0; i < words.length; i++){
			int col = 3;
			for(int j = 0; j < words[i].length; j++){
				String letter = words[i][j];
				grid[row][col] = letter;
				col = col + 6;
			}
			row = row + 3;
		}
		printPic(grid);
	}

	private static String[][] splitWords(String[][] words, String[] gridCol){
		int rndIndx = (int)(Math.random()*words.length);
		String[] selectedArray = words[rndIndx];
		
		String[][] splitWords = new String[selectedArray.length][gridCol.length/6]; //length of column should be same as column length of grid
		
		for(int i = 0; i < splitWords.length; i++){
			for(int j = 0; j < splitWords[i].length; j++){
				splitWords[i][j] = " ";
			}
		}
		
		for(int i = 0; i < selectedArray.length; i++){
			for(int j = 0; j < selectedArray[i].length(); j++){
				String letter = selectedArray[i].substring(j, j + 1);
				splitWords[i][j] = letter;						
			}
		}
		
//		CAN USE SPLIT
//		
//		int cntr = 0;
//		
//		for(int i = 0; i < selectedArray.length; i++){
//			String[] temp = selectedArray[i].split("");
//			splitWords[cntr] = temp;
//			
//			cntr++;
//		}
		
		return splitWords;
	}

	private static void makeGrid(String[][] array) {
		int colNum = 0;
		int rowNum = 0;
		for(int row = 0; row < array.length; row++){
			for(int col = 0; col < array[row].length; col++){
				array[row][col] = " ";
				if(col == array[row].length - 1 && row != 0 && row % 3 == 0){
					array[row][col] = "" +  colNum;
					colNum++;
				}
				if(row == array.length - 1 && col % 6 == 0){
					array[row][col] = "" + rowNum;
					rowNum++;
				}
				if(col != (array[row].length - 1) && col!= 0 && row % 3 == 0){
					array[row][col] = "_";
				}
				if(row!= 0 && row != (array.length - 1) && col % 6 == 0){
					array[row][col] = "|";
				}
			}
		}
	}
	
	private static void printPic(String[][] arr) {
		for(String[] row : arr){
			for(String col : row){
				System.out.print(col);
			}
			System.out.println();
		}
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			System.out.println(s);
			System.out.println("- - - Press Enter - - -");
			input.nextLine();
		}
	}
	
	/*
	 * puzzle is a list of words
	 * if the length of the word does not fill the length of columns, fill it with blank spaces
	 * 
	 * describe event
	 * helper method to make grid
	 * "pieces" are letters and make words
	 * user will swap pieces that are next to each other to make a word
	 * if piece is at the right place, user can't move it
	 * check if bomb piece is in the middle -  game over if it is
	 * check if puzzle is complete
	 */
}
