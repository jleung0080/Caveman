package joeyRichard;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoomPd8;

public class Temp {
	private static String map;

	public static void main(String[] args){
		printPic(grassyPic());
	}
	public static String[][] grassyPic(){
		String[][] pic = new String[7][30];
		for(int row = 0; row <pic.length; row++){
			//put an entire array on each row
			for(int col = 0; col<pic[row].length; col++){
				//populate with coordinates
				pic[row][col] = (" ");
			}
		}








		for(int col = 1; col<pic[0].length-1; col++){
			pic[0][col] = "_";
			pic[pic.length-1][col] = "_";

		}
		for(int row = 1; row<pic.length; row++){
			pic[row][0] = "|";
			pic[row][pic[0].length-1] = "|"; 
		}
		return pic;
	}
	public static void printPic(String[][] pic){
		for(String[] row : pic){
			for(String col : row){
				System.out.print(col);
			}
			System.out.println();
		}
	}
}
