package katherineRisa;

import katherineRisa.KatherinePlayPuzzle;

public class RisaCheckSolution implements caveExplorer.Playable {
	
	private static String[][] currentLetters;
	private static String[][] completeLetters;
	private static boolean complete = false;
	
	public RisaCheckSolution() {
		currentLetters = KatherinePlayPuzzle.letters;
		completeLetters = MainEvent.splitWordsArray;
	}

	public void play() {
		
		if(checkBomb()){
			System.out.println("You put a bomb in the bag!! How stupi-- uh... foolish can you be to mistake a bomb as a present! Leave! You're fired.");
			//MainEvent.main();
		}else{
			checkComplete();
			if(!complete){
				MainEvent.katherinePuzzle.play();
			}
			else{
				System.out.println("Thanks! You were a great help. You can leave this room now. Bye bye!!");
			}
		}
	}

	private void checkComplete() {
		A : for(int i = 0; i < completeLetters.length; i++){
				for(int j = 0; j < completeLetters[i].length; j++){
					if(currentLetters[i][j] != completeLetters[i][j]){
						if(completeLetters[i][j] == " " && currentLetters[i][j] == "!"){
							complete = true;
						}
						complete = false;
						break A;
					}
				}
			}
		
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
}