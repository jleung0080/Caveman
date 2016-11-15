package joeyRichard;

public class Temp {
	private static String[][] grid = new String[7][30];
	private static String map;
	public static void main(String[] args){
		grid = makeGrid(grid);
		printPic(grid);
	}
	public static String[][] makeGrid(String[][] arr){
		String[][] pic = new String[arr.length][arr[0].length];
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

		pic[(int)(pic.length/2)][pic[0].length-1] = " ";
		pic[(int)(pic.length/2)+1][0] = " ";

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

	public static void printMap(){
		for(int i = 0; i < grid[0].length - 1; i++){
			map += "__";
		}
		
		map += "_\n";
		
	}




}
