package katherineRisa;

public class RisaCheckSolution implements caveExplorer.Playable {
	
	private static boolean gameOver = false;
	private static boolean complete = false;
	private static String[][] array;
	
	public RisaCheckSolution(String[][] splitWordsArray) {
		array = splitWordsArray;
	}

	public RisaCheckSolution() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		System.out.println("!");
		for(int i = 0; i < array.length;i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.println(array[i][j]);
			}
		}
//		checkBomb();
//		if(gameOver){
//			System.out.println("The bomb has exploded.");
//			//make user leave room
//		}else{
//			checkComplete();
//			if(!complete){
//				MainEvent.katherinePuzzle.play();
//			}
//			else{
//				System.out.println();
//			}
//		}
	}
	
//	private static void inputLetters(String[][] grid, String[][] words) {
//		int row = 2;
//		for(int i = 0; i < words.length; i++){
//			int col = 3;
//			for(int j = 0; j < words[i].length; j++){
//				String letter = words[i][j];
//				grid[row][col] = letter;
//				col = col + 6;
//			}
//			row = row + 3;
//		}
//		
//		printPic(grid);
//	}
//
//	private void checkComplete() {
//		
//		
//	}
//
//	private void checkBomb() {
//		for(int i = 0; i < ; i++){
//			for(int j = 0; j < ; j++){
//				if()
//					gameOver = true;
//			}
//		}
//		
//	}
//
}
