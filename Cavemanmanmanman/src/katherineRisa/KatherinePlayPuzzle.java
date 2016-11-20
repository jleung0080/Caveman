package katherineRisa;

public class KatherinePlayPuzzle implements caveExplorer.Playable {
	
	private static String[][] words;

	public KatherinePlayPuzzle(String[][] splitWordsArray) {
		String[][] words = splitWordsArray;
	}

	public void play() {
		mixLetters(words);
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
	}

}
