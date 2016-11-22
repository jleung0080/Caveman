package katherineRisa;

import caveExplorer.CaveRoomPd8;
import caveExplorer.Door;
import caveExplorer.CaveExplorer;
import katherineRisa.KatherinePlayPuzzle;

public class RisaCheckSolution implements caveExplorer.Playable {
	
	private static String[][] currentLetters;
	private static String[][] originalLetters;
	
	private static final String[] gameOverDialouge = {"You put a bomb in the bag!! How stupi-- uh... foolish can you be to mistake a bomb as a present!", "Leave! You're fired.", "...", "Actually... can you come back here please?", "I'll explain the instructions again so...", "Help me?", "Great! Thanks. Here goes."};
	
	public RisaCheckSolution() {
		currentLetters = KatherinePlayPuzzle.letters;
		originalLetters = MainEvent.splitWordsArray;
	}

	public void play() {
		if(checkBomb()){
			MainEvent.readSequence(gameOverDialouge);
			MainEvent.game();
		}else{
			if(!checkComplete()){
				MainEvent.katherinePuzzle.play();
			}
			else{
				System.out.println("Thanks! You were a great help. You can leave this room now. Bye bye!!");
				CaveExplorer.caves[1][2].setConnection(CaveRoomPd8.EAST, CaveExplorer.caves[1][3], new Door(true, false));
				MainEvent.gameWon = true;
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
				if(currentLetters[row][col].equals("!"))
					return true;
			}
		}
		return false;
	}
}