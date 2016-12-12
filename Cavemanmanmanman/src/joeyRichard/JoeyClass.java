package joeyRichard;



public class JoeyClass {

	public static void computerMove(){
		if(!Main.gameEnd()){
			int numberOfMoves = Main.roll();
			System.out.println("Other Santa rolled a "+numberOfMoves+"!");
			for(int i=numberOfMoves;i>0;i-- ){
				System.out.println("He has "+i+" move(s).");
				RichardClass.selectedCar = (int)(Math.random()*15);
				while(selectedCarStuck()){
					RichardClass.selectedCar = (int)(Math.random()*15);
				}
				whichCpuPerformMove();
				RichardClass.printMap();
			}
		}

	}


	private static void whichCpuPerformMove() {
		if(RichardClass.selectedCar == 0){
			RichardClass.zero.cpuPerformMove();
		}else if(RichardClass.selectedCar == 1){
			RichardClass.one.cpuPerformMove();
		}else if(RichardClass.selectedCar == 2){
			RichardClass.two.cpuPerformMove();
		}else if(RichardClass.selectedCar == 3){
			RichardClass.three.cpuPerformMove();
		}else if(RichardClass.selectedCar == 4){
			RichardClass.four.cpuPerformMove();
		}else if(RichardClass.selectedCar == 5){
			RichardClass.five.cpuPerformMove();
		}else if(RichardClass.selectedCar == 6){
			RichardClass.six.cpuPerformMove();
		}else if(RichardClass.selectedCar == 7){
			RichardClass.seven.cpuPerformMove();
		}else if(RichardClass.selectedCar == 8){
			RichardClass.eight.cpuPerformMove();
		}else if(RichardClass.selectedCar == 9){
			RichardClass.nine.cpuPerformMove();
		}else if(RichardClass.selectedCar == 10){
			RichardClass.ten.cpuPerformMove();
		}else if(RichardClass.selectedCar == 11){
			RichardClass.eleven.cpuPerformMove();
		}else if(RichardClass.selectedCar == 12){
			RichardClass.twelve.cpuPerformMove();
		}else if(RichardClass.selectedCar == 13){
			RichardClass.thirteen.cpuPerformMove();
		}else if(RichardClass.selectedCar == 14){
			RichardClass.fourteen.cpuPerformMove();
		}else
			RichardClass.fifteen.cpuPerformMove();

	}



	public static boolean selectedCarStuck() {
		if(RichardClass.selectedCar == 0){
			return RichardClass.zero.stuck();
		}else if(RichardClass.selectedCar == 1){
			return RichardClass.one.stuck();
		}else if(RichardClass.selectedCar == 2){
			return RichardClass.two.stuck();
		}else if(RichardClass.selectedCar == 3){
			return RichardClass.three.stuck();
		}else if(RichardClass.selectedCar == 4){
			return RichardClass.four.stuck();
		}else if(RichardClass.selectedCar == 5){
			return RichardClass.five.stuck();
		}else if(RichardClass.selectedCar == 6){
			return RichardClass.six.stuck();
		}else if(RichardClass.selectedCar == 7){
			return RichardClass.seven.stuck();
		}else if(RichardClass.selectedCar == 8){
			return RichardClass.eight.stuck();
		}else if(RichardClass.selectedCar == 9){
			return RichardClass.nine.stuck();
		}else if(RichardClass.selectedCar == 10){
			return RichardClass.ten.stuck();
		}else if(RichardClass.selectedCar == 11){
			return RichardClass.eleven.stuck();
		}else if(RichardClass.selectedCar == 12){
			return RichardClass.twelve.stuck();
		}else if(RichardClass.selectedCar == 13){
			return RichardClass.thirteen.stuck();
		}else if(RichardClass.selectedCar == 14){
			return RichardClass.fourteen.stuck();
		}else
			return RichardClass.fifteen.stuck();
	}






	/*
	 CAR CODE




	 public void performMove(){
		int spaces;
		System.out.println("Which direction would you like to move?");
		Main.direction = RichardClass.selectDirection();
		while(!isValidDirection(Main.direction)){
			Main.direction = RichardClass.selectDirection();
		}
		System.out.println("How many spaces would you like to sleigh the car in that direction?");
		spaces = Main.getInt();
		while(!validMove(spaces)){
			System.out.println("That is an invalid move. Please enter a valid number of spaces to move the sleigh.");
			spaces = Main.getInt();
		}
		changePos(Main.direction,spaces);
	}

	public void cpuPerformMove(){
		String[] possible = {"left", "right", "up", "down"};
		Main.direction = "";
		for(int car:Main.horizontal){
			if(RichardClass.selectedCar == car){
				if(leftBlock()){
					Main.direction =  "right";
				}else if(rightBlock()){
					Main.direction = "left";
				}else
					Main.direction = possible[(int)(Math.random()*2)];

			}
		}
		for(int car:Main.vertical){
			if(RichardClass.selectedCar == car){
				if(upBlock()){
					Main.direction =  "down";
				}else if(downBlock()){
					Main.direction = "up";
				}else
					Main.direction = possible[(int)(Math.random()*2)+2];
			}
		}
		int spaces;
		spaces = (int)(Math.random()*7+1);
		while(!validMove(spaces)){
			spaces = (int)(Math.random()*7+1);
		}
		System.out.println("Other Santa decides to move car "+RichardClass.selectedCar+" "+Main.direction+" "+spaces+
				" spaces.");
		changePos(Main.direction,spaces);
	}

	public boolean isValidDirection(String dir) {
		for(int car:Main.vertical){
			if(RichardClass.selectedCar == car){
				if(upBlock()&&dir=="up"){
					System.out.println("The selected car may only move down. Please select a valid direction.");
					return false;
				}else if(downBlock()&&dir=="down"){
					System.out.println("The selected car may only move up. Please select a valid direction.");
					return false;
				}else if(dir == "up"||dir == "down"){
					return true;
				}
				System.out.println("The selected car may only move up or down. Please select a valid direction.");
				return false;
			}
		}
		for(int car: Main.horizontal){
			if(RichardClass.selectedCar == car){
				if(leftBlock()&&dir=="left"){
					System.out.println("The selected car may only move right. Please select a valid direction.");
					return false;
				}else if(rightBlock()&&dir=="right"){
					System.out.println("The selected car may only move left. Please select a valid direction.");
					return false;
				}else if(dir == "left"||dir == "right"){
					return true;
				}
				System.out.println("The selected car may only move left or right. Please select a valid direction.");
				return false;
			}
		}
		return false;
	}



	public boolean upBlock(){
		if(location[0][0] == 0){
			return true;
		}else if(Main.check[location[0][0]-1][location[0][1]]){
			return true;
		}
		return false;
	}
	public boolean downBlock(){
		if(location[location.length-1][0] == Main.check.length-1){
			return true;
		}else if(Main.check[location[location.length-1][0]+1][location[0][1]]){
			return true;
		}
		return false;
	}
	public boolean leftBlock(){
		if(location[0][1] == 0){
			return true;
		}else if(Main.check[location[0][0]][location[0][1]-1]){
			return true;
		}
		return false;
	}
	public boolean rightBlock(){
		if(location[location.length-1][1] == Main.check[0].length-1){
			return true;
		}else if(Main.check[location[location.length-1][0]][location[location.length-1][1]+1]){
			return true;
		}
		return false;
	}

	public boolean stuck(){
		if(location[0][0] == location[location.length-1][0]){
			if(leftBlock()&&rightBlock()){
				return true;
			}
		}else if(upBlock()&&downBlock()){
			return true;
		}
		return false;

	}

	private boolean validMove(int spaces){
		if(spaces<1){
			return false;
		}
		for(int i=1; i<=spaces; i++){
			if(Main.direction == "left"){
				if(location[0][1]-i<0){
					return false;
				}else{
					if(Main.check[location[0][0]][location[0][1]-i]){
						return false;
					}
				}
			}else if(Main.direction == "right"){
				if(location[location.length-1][1]+i>14){
					return false;
				}else{
					if(Main.check[location[location.length-1][0]][location[location.length-1][1]+i]){
						return false;
					}
				}
			}else if(Main.direction == "up"){
				if(location[0][0]-i<0){
					return false;
				}else{
					if(Main.check[location[0][0]-i][location[0][1]]){
						return false;
					}
				}
			}else{
				if(location[location.length-1][0]+i>7){
					return false;
				}else{
					if(Main.check[location[location.length-1][0]+i][location[location.length-1][1]]){
						return false;
					}
				}
			}

		}
		return true;
	}
	 */







}
