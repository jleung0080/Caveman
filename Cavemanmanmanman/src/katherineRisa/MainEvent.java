package katherineRisa;

public class MainEvent {
	
	private static String[][] grid;
	private static String[][] words = {{}, {}, {}};
	
	public MainEvent() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		grid = new String[17][17];
		makeGrid(grid);

	}

	private static void makeGrid(String[][] array) {
		for(int row = 0; row < array.length; row++){
			for(int col = 0; col < array[row].length; col++){
				array[row][col] = " ";
				if(col!= 0 && col!= array[row].length - 1 && row % 4 == 0){
					array[row][col] = "_";
				}
				if(row!= 0 && col % 4 == 0){
					array[row][col] = "|";
				}
			}
		}
		
		printPic(array);
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
