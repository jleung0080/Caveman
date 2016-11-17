package katherineRisa;

public class MainEvent {
	
	static caveExplorer.Playable katherinePuzzle;
	static caveExplorer.Playable risaPuzzle;
	
	private static String[][] grid;
	private static String[][] words = {{"one", "two", "three"}, {"four", "five", "six"}, {"seven", "eight", "nine"}};

	public static void main(String[] args) {
		grid = new String[10][37];
		makeGrid(grid);
		String[][] splitWordsArray = splitWords(words, grid[0]);
		inputLetters(grid, splitWordsArray);
		
		katherinePuzzle = new KatherinePlayPuzzle();
		risaPuzzle = new RisaCheckSolution();
		
	}

	private static void inputLetters(String[][] grid, String[][] words) {
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
		int cntr = 0;
		
		for(int i = 0; i < selectedArray.length; i++){
			String[] temp = selectedArray[i].split("");
			splitWords[cntr] = temp;
			
			cntr++;
		}
		
		return splitWords;
	}

	private static void makeGrid(String[][] array) {
		for(int row = 0; row < array.length; row++){
			for(int col = 0; col < array[row].length; col++){
				array[row][col] = " ";
				if(col!= 0 && col!= array[row].length - 1 && row % 3 == 0){
					array[row][col] = "_";
				}
				if(row!= 0 && col % 6 == 0){
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
