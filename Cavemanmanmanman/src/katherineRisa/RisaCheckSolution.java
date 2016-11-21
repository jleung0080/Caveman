package katherineRisa;

public class RisaCheckSolution implements caveExplorer.Playable {
	
	private static boolean gameOver = false;
	private static boolean complete = false;
	
	public RisaCheckSolution() {
	}

	public void play() {
		checkBomb();
		if(gameOver){
			System.out.println("The bomb has exploded.");
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
		
		
	}

	private void checkBomb() {
		for(int i = 0; i < ; i++){
			for(int j = 0; j < ; j++){
				if()
					gameOver = true;
			}
		}
		
	}
}
