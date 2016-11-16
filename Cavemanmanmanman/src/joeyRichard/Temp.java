package joeyRichard;

import caveExplorer.CaveRoomPd8;

public class Temp {
	private static String[][] grid = new String[6][10];
	private static String map;
	public static void main(String[] args){
		
		printMap();
	}
//	public static String[][] makeGrid(String[][] arr){
//		String[][] pic = new String[arr.length][arr[0].length];
//		for(int row = 0; row <pic.length; row++){
//			//put an entire array on each row
//			for(int col = 0; col<pic[row].length; col++){
//				//populate with coordinates
//				pic[row][col] = (" ");
//			}
//		}
//
//		for(int col = 1; col<pic[0].length-1; col++){
//			pic[0][col] = "_";
//			pic[pic.length-1][col] = "_";
//
//		}
//
//		for(int row = 1; row<pic.length; row++){
//			pic[row][0] = "|";
//			pic[row][pic[0].length-1] = "|"; 
//		}
//
//		pic[(int)(pic.length/2)][pic[0].length-1] = " ";
//		pic[(int)(pic.length/2)+1][0] = " ";
//
//		return pic;
//	}
//	public static void printPic(String[][] pic){
//		for(String[] row : pic){
//			for(String col : row){
//				System.out.print(col);
//			}
//			System.out.println();
//		}
//	}

	public static void printMap(){
		map = " ";
		for(int i = 0; i < grid[0].length - 1; i++){
			map += "____";
		}
		
		map += "___\n";
		
		for(int row = 0; row<grid.length; row++){
			for(int textRow  = 0; textRow < 2; textRow++){
				for(int count = 0; count<grid[row].length; count++){
					if(row == (int)(grid.length/2) && count == 0 && textRow == 0){
						map+="    ";
					}else if(row == (int)(grid.length/2) && count == 0 && textRow == 1){
						map+=" ___";
					}else if(textRow == 1){
						map+="|___";
					}else{
						map+="|   ";
					}
				}
				if(row == (int)(grid.length/2-1)){
					map+= "\n";
				}else{
					map += "|\n";					
				}
			}
		}
		System.out.println(map);;
	}




}
