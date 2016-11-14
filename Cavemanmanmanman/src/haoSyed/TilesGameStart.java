package haoSyed;

import caveExplorer.CaveExplorer;
import caveExplorer.Playable;

public class TilesGameStart implements Playable {

	private static final String[] SEQUENCE_1 = {"The door locks behind you.", "Something something solve this puzzle to escape."};
	
	private static final String[] SEQUENCE_2 = {"something soemthing solved puzzle", "something something door opens"};
	
	
	public TilesGameStart() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQUENCE_1);
		createGrid();
		boolean inGameLoop = true;
		while (inGameLoop){
			
		}
		readSequence(SEQUENCE_2);
		CaveExplorer.inventory.setHasMap(true);

	}
	
	public static void isMatch(String[] array1, String[] array2){
		for (int i = 0; i < array1.length; i++){
			for (int j = 0; j < array2.length; j++){
				if (array1[i] == array2[j]){
					i++;
				}
			}
		}
	}
	public static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - press enter - - -");
			CaveExplorer.in.nextLine();
		}
	}

}
