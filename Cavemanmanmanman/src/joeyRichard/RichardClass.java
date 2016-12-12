package joeyRichard;

public class RichardClass {

	public static int selectedCar;
	static String map;
	static Cars zero = new Cars("you", 2);
	static Cars one = new Cars("cpu", 2);
	static Cars two = new Cars(" 2 ", 2);
	static Cars three = new Cars(" 3 ", 3);
	static Cars four = new Cars(" 4 ", 4);
	static Cars five = new Cars(" 5 ", 3);
	static Cars six = new Cars(" 6 ", 2);
	static Cars seven = new Cars(" 7 ", 3);
	static Cars eight = new Cars(" 8 ", 4);
	static Cars nine = new Cars(" 9 ", 4);
	static Cars ten = new Cars(" 10", 3);
	static Cars eleven = new Cars(" 11", 3);
	static Cars twelve = new Cars(" 12", 2);
	static Cars thirteen = new Cars(" 13", 3);
	static Cars fourteen = new Cars(" 14", 4);
	static Cars fifteen = new Cars(" 15", 4);




	public static void printMap(){
		map = " ";
		for(int i = 0; i < Main.grid[0].length - 1; i++){
			map += "___ ";
		}

		map += "___\n";

		for(int row = 0; row<Main.grid.length; row++){
			for(int textRow  = 0; textRow < 2; textRow++){
				for(int count = 0; count<Main.grid[row].length; count++){
					if(row == (int)(Main.grid.length/2) && count == 0 && textRow == 0){
						map+="EXIT";
					}
					else if(row == (int)(Main.grid.length/2) && count == 0 && textRow == 1){
						map+=" ___";
					}
					else if(textRow == 1){
						map+="|___";
					}
					else{
						if(row == (int)(Main.grid.length/2-1)&&count==Main.grid[row].length-1){
							map+= "|EXIT";
						}
						else{
							if(Main.grid[row][count] == null){
								map+="|   ";								
							}
							else{
								map+="|"+Main.grid[row][count];
							}
						}
					}
				}
				if(row == (int)(Main.grid.length/2-1)){
					map+= "\n";
				}else{
					map += "|\n";					
				}
			}
		}
		System.out.println(map);;
	}

	public static void createCars(){
		for(boolean[] row: Main.check){
			for(boolean col: row){
				col = false;
			}
		}
		zero.startPos = createPos(3,0);
		zero.endPos = createPos(3,1);
		zero.setPos();

		one.startPos = createPos(4,13);
		one.endPos = createPos(4,14);
		one.setPos();

		two.startPos = createPos(5,1);
		two.endPos = createPos(6,1);
		two.setPos();

		three.startPos = createPos(0,2);
		three.endPos = createPos(2,2);
		three.setPos();

		four.startPos = createPos(5,2);
		four.endPos = createPos(5,6);
		four.setPos();

		five.startPos = createPos(2,4);
		five.endPos = createPos(3,4);
		five.setPos();

		six.startPos = createPos(1,4);
		six.endPos = createPos(1,6);
		six.setPos();

		seven.startPos = createPos(2,6);
		seven.endPos = createPos(4,6);
		seven.setPos();

		eight.startPos = createPos(0,7);
		eight.endPos = createPos(3,7);
		eight.setPos();

		nine.startPos = createPos(2,8);
		nine.endPos = createPos(2,11);
		nine.setPos();

		ten.startPos = createPos(4,8);
		ten.endPos = createPos(6,8);
		ten.setPos();

		eleven.startPos = createPos(3,9);
		eleven.endPos = createPos(5,9);
		eleven.setPos();

		twelve.startPos = createPos(0,10);
		twelve.endPos = createPos(1,10);
		twelve.setPos();

		thirteen.startPos = createPos(5,10);
		thirteen.endPos = createPos(7,10);
		thirteen.setPos();

		fourteen.startPos = createPos(0,12);
		fourteen.endPos = createPos(3,12);
		fourteen.setPos();

		fifteen.startPos = createPos(7,11);
		fifteen.endPos = createPos(7,14);
		fifteen.setPos();
	}

	private static int[] createPos(int start, int end){
		int[] position = new int[2];
		position[0] = start;
		position[1] = end;
		return position;
	}




	private static void whichPerformMove() {
		if(selectedCar == 0){
			RichardClass.zero.performMove();
		}else if(selectedCar == 1){
			RichardClass.one.performMove();
		}else if(selectedCar == 2){
			RichardClass.two.performMove();
		}else if(selectedCar == 3){
			RichardClass.three.performMove();
		}else if(selectedCar == 4){
			RichardClass.four.performMove();
		}else if(selectedCar == 5){
			RichardClass.five.performMove();
		}else if(selectedCar == 6){
			RichardClass.six.performMove();
		}else if(selectedCar == 7){
			RichardClass.seven.performMove();
		}else if(selectedCar == 8){
			RichardClass.eight.performMove();
		}else if(selectedCar == 9){
			RichardClass.nine.performMove();
		}else if(selectedCar == 10){
			RichardClass.ten.performMove();
		}else if(selectedCar == 11){
			RichardClass.eleven.performMove();
		}else if(selectedCar == 12){
			RichardClass.twelve.performMove();
		}else if(selectedCar == 13){
			RichardClass.thirteen.performMove();
		}else if(selectedCar == 14){
			RichardClass.fourteen.performMove();
		}else
			RichardClass.fifteen.performMove();

	}

	public static void move(){
		Main.direction = "";
		int numberOfMoves = Main.roll();
		System.out.println("You rolled a "+numberOfMoves+"!");
		for(int i=numberOfMoves;i>0;i-- ){
			System.out.println("You have "+i+" moves.");
			System.out.println("Which sleigh would you like to move? Select a sleigh by its number. Your sleigh is 0 and the other santa's sleigh is 1.");
			selectedCar= Main.getInt();
			if(selectedCar==205710080){
				Main.playerWin = true;
				break;
			}else{
				while(selectedCar<0 || selectedCar>15 || JoeyClass.selectedCarStuck()){
					if(JoeyClass.selectedCarStuck()){
						System.out.println("This sleigh is stuck, please select a different sleigh to move");
						selectedCar=Main.getInt();
					}else{
						System.out.println("You must pick a sleigh between 0 and 15");
						selectedCar=Main.getInt();
					}
				}
			}
			whichPerformMove();
			RichardClass.printMap();
		}
	}
	
	public static String selectDirection(){
		// TODO Auto-generated method stub
		String directionChoice = Main.promptInput().toLowerCase();
		while(!isDir(directionChoice)){
			System.out.println("Please enter one of the following: 'up', 'down', 'left', 'right'");
			directionChoice = Main.promptInput();
		}
		String[] keys = {"up", "down", "left", "right"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(directionChoice)){
				indexFound = i;
				break;
			}
		}

		System.out.println(keys[indexFound]);
		return keys[indexFound];
	}

	private static boolean isDir(String directionChoice) {
		// TODO Auto-generated method stub
		String[] validDir = {"up", "down", "left", "right"};
		for(String key : validDir){
			if(directionChoice.equals(key))
				return true;
		}
		return false;
	}
	
	
	
	
	




	/*
	CAR CODE
	
	
	
	 public void changePos(String direction, int spaces){
		for(int[] point:location){
			Main.check[point[0]][point[1]]=false;
			Main.grid[point[0]][point[1]]=null;
		}
		for(int i =0;i<location.length;i++){
			if(Main.direction == "left"){
				Main.check[location[i][0]][location[i][1]-spaces]=true;
				Main.grid[location[i][0]][location[i][1]-spaces]=show;
				location[i][1] = location[i][1]-spaces;
			}else if(Main.direction == "right"){
				Main.check[location[i][0]][location[i][1]+spaces]=true;
				Main.grid[location[i][0]][location[i][1]+spaces]=show;
				location[i][1] = location[i][1]+spaces;
			}else if(Main.direction == "up"){
				Main.check[location[i][0]-spaces][location[i][1]]=true;
				Main.grid[location[i][0]-spaces][location[i][1]]=show;
				location[i][0] = location[i][0]-spaces;
			}else{
				Main.check[location[i][0]+spaces][location[i][1]]=true;
				Main.grid[location[i][0]+spaces][location[i][1]]=show;
				location[i][0] = location[i][0]+spaces;
			}
		}
	}

	public void setPos(){
		if(startPos[0] == endPos[0]){
			for(int i=0; i<location.length;i++){
				location[i][0] = startPos[0];
				location[i][1] = startPos[1]+i;
				Main.grid[location[i][0]][location[i][1]] = show;
				Main.check[location[i][0]][location[i][1]] = true;
			}
		}else{
			for(int i=0; i<location.length;i++){
				location[i][0] = startPos[0]+i;
				location[i][1] = startPos[1];
				Main.grid[location[i][0]][location[i][1]] = show;
				Main.check[location[i][0]][location[i][1]] = true;
			}
		}
	}
}
	 */





}
