package joeyRichard;

import caveExplorer.CaveExplorer;
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
						map+="EXIT";
					}else if(row == (int)(grid.length/2) && count == 0 && textRow == 1){
						map+=" ___";
					}else if(textRow == 1){
						map+="|___";
					}else{
						if(row == (int)(grid.length/2-1)&&count==grid[row].length-1){
							map+= "|EXIT";
						}else{				
							map+="|   ";
						}
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
		//function uses string and prints out board. we need to use getcontent to update mapping
	}
	
	public void interpretAction(String input) {
		while(!isValid(input)){
			CaveExplorer.print("Please enter 'w', 'a', 's' or 'd'");
			input = CaveExplorer.in.nextLine().toLowerCase();
		}
		
		String[] keys = {"w", "d", "s", "a"};//order matters
		int indexFound = -1;
		
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(input)){
				indexFound = i;
				break;
			}
		}
		
		
		
	}
	
	public static int findKeyword(String searchString, String keyword, int startPsn) {
        searchString = searchString.trim();
        searchString = searchString.toLowerCase();
        keyword = keyword.toLowerCase();
        int psn = searchString.indexOf(keyword);
        while(psn>=0){
            String before = " ";
            String after = " ";
            if(psn>0){
                before = searchString.substring(psn-1, psn);
            }
            if(psn+keyword.length() < searchString.length()){
                after = searchString.substring((psn + keyword.length()), 
                        psn + keyword.length()+1);
            }
            if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)){
                return psn;
            }else{
                psn = searchString.indexOf(keyword,psn+1);
            }
        }
        return -1;
    }
	private static boolean noNegations(String searchString, int psn) {
        if(psn - 3 >= 0  && searchString.substring(psn-3, psn).equals("no "))
        {
            return false;
        }
        if(psn - 4 >= 0  && searchString.substring(psn-4, psn).equals("not "))
        {
            return false;
        }
        if(psn - 6 >= 0  && searchString.substring(psn-6, psn).equals("never "))
        {
            return false;
        }
        if(psn - 4 >= 0  && searchString.substring(psn-4, psn).equals("n't "))
        {
            return false;
        }
        return true;
        
    }


}
