package katherineRisa;

public class KatherinePlayPuzzle implements caveExplorer.Playable {
	
	private static String[][] letters;
	private static String[][] grid;

	public KatherinePlayPuzzle() {
		letters = MainEvent.splitWordsArray;
		grid = MainEvent.grid;
	}

	public void play() {
		mixLetters(letters);
		MainEvent.inputLetters(grid, letters);
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
