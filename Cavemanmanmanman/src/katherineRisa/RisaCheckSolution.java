package katherineRisa;

import caveExplorer.CaveRoomPd8;
import caveExplorer.Door;
import katherineRisa.KatherinePlayPuzzle;

public class RisaCheckSolution implements caveExplorer.Playable {
	
	private static String[][] currentLetters;
	private static String[][] originalLetters;
	private static String[][] grid;
	static boolean complete = false;
	
	public RisaCheckSolution() {
		currentLetters = KatherinePlayPuzzle.letters;
		originalLetters = MainEvent.splitWordsArray;
		grid = MainEvent.grid;
	}

	public void play() {
		if(checkBomb()){
			System.out.println("You put a bomb in the bag!! How stupi-- uh... foolish can you be to mistake a bomb as a present! Leave! You're fired.");
			System.out.println("- - - Press Enter - - -");
			MainEvent.userInput();
			MainEvent.game();
		}else{
			if(!checkComplete()){
				MainEvent.katherinePuzzle.play();
			}
			else{
				System.out.println("Thanks! You were a great help. You can leave this room now. Bye bye!!");
				//caves[1][2].setConnection(CaveRoomPd8.EAST, caves[1][3], new Door(true, false));
			}
		}
	}

	private boolean checkComplete() {
		for(int i = 0; i < originalLetters.length; i++){
			for(int j = 0; j < originalLetters[i].length; j++){
				if(originalLetters[i][j] != currentLetters[i][j] || originalLetters[i][j] != " " && currentLetters[i][j] != "!"){
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkBomb() {
		for(int row = 1; row < currentLetters.length - 1; row++){
			for(int col = 1; col < currentLetters[row].length - 1; col++){
				if(currentLetters[row][col] == "!")
					return true;
			}
		}
		return false;
	}
	
	private static void cheatCode(){
		if(MainEvent.userInput() == "cheat"){
			MainEvent.inputLetters(grid, originalLetters);
			System.out.println("You did it. Now on to the next job.");
			
		}
	}
}