package joeyRichard;

import caveExplorer.CaveExplorer;
import java.util.Scanner;
import caveExplorer.CaveRoomPd8;

public class Temp {
	private static String[][] grid = new String[8][15];
	private static String map;
	static Scanner input; 
	static Cars zero = new Cars("0", 2);
	static Cars one = new Cars("1", 3);
	static Cars two = new Cars("2", 4);
	static Cars three = new Cars("3", 3);
	static Cars four = new Cars("4", 2);
	static Cars five = new Cars("5", 3);
	static Cars six = new Cars("6", 4);
	static Cars seven = new Cars("7", 4);
	static Cars eight = new Cars("8", 3);
	static Cars nine = new Cars("9", 3);
	static Cars ten = new Cars("10", 2);
	static Cars eleven = new Cars("11", 3);
	static Cars twelve = new Cars("12", 4);
	static Cars thirteen = new Cars("13", 4);
	
	
	public static void main(String[] args){
	createCars();
	thirteen.setPos();
	for(int[] str:thirteen.location){
		for(int z:str){
			System.out.println(z);
		}
	}
	
	
	
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
            if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
                return psn;
            }else{
                psn = searchString.indexOf(keyword,psn+1);
            }
        }
        return -1;
    }
	
	//gives cars positions start&beginning
	private static int[] createPos(int start, int end){
		int[] position = new int[2];
		position[0] = start;
		position[1] = end;
		return position;
	}
	
	//creates all the obstacle cars
	public static void createCars(){
		zero.startPos = createPos(5,1);
		zero.endPos = createPos(6,1);
		
		one.startPos = createPos(0,2);
		one.endPos = createPos(2,2);
		
		two.startPos = createPos(5,2);
		two.endPos = createPos(5,6);
		
		three.startPos = createPos(3,4);
		three.endPos = createPos(4,4);
		
		four.startPos = createPos(1,4);
		four.endPos = createPos(1,6);
		
		five.startPos = createPos(2,6);
		five.endPos = createPos(4,6);
		
		six.startPos = createPos(0,7);
		six.endPos = createPos(3,7);
		
		seven.startPos = createPos(2,8);
		seven.endPos = createPos(2,11);
		
		eight.startPos = createPos(4,8);
		eight.endPos = createPos(6,8);
		
		nine.startPos = createPos(3,9);
		nine.endPos = createPos(5,9);
		
		ten.startPos = createPos(0,10);
		ten.endPos = createPos(1,10);
		
		eleven.startPos = createPos(5,10);
		eleven.endPos = createPos(7,10);
		
		twelve.startPos = createPos(0,12);
		twelve.endPos = createPos(3,12);
		
		thirteen.startPos = createPos(7,11);
		thirteen.endPos = createPos(7,14);
	}
	
	public static String promptInput() {
        String userInput = input.nextLine();
        return userInput;
    }
	
	private int getInt(){
		String integerString = promptInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			}catch(NumberFormatException e){
				System.out.println("You must enter an integer.");
				integerString = promptInput();
			}
		}
		return value;
	}

}
