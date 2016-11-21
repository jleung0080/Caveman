package katherineRisa;

import katherineRisa.KatherinePlayPuzzle;

public class RisaCheckSolution implements caveExplorer.Playable {
	
	private static String[][] currentLetters;
	private static String[][] completeLetters;
	private static boolean gameOver = false;
	private static boolean complete = false;
	
	public RisaCheckSolution() {
		currentLetters = KatherinePlayPuzzle.letters;
		completeLetters = MainEvent.splitWordsArray;
	}

	public void play() {
		checkBomb();
		if(gameOver){
			System.out.println("You put a bomb in the bag!! How stup-- uh foolish can you be to mistake a present as a bomb! Leave! You're fired.");
			//make user leave room
		}else{
			checkComplete();
			if(!complete){
				MainEvent.katherinePuzzle.play();
			}
			else{
				System.out.println();
			}
		}
	}

	private void checkComplete() {
		for(int i = 0; i < completeLetters.length; i++){
			for(int j = 0; j < completeLetters[i].length; j++)
		}
		
	}

	private void checkBomb() {
		for(int row = 1; row < currentLetters.length - 1; row++){
			for(int col = 1; col < currentLetters[row].length - 1; col++){
				if(currentLetters[row][col] == "!")
					gameOver = true;
			}
		}
	}
}