package joeyRichard;
import joeyRichard.Main;
public class Cars {
	public int[][] location;
	public int[] startPos;
	public int[] endPos;
	private String show;

	public Cars(String id, int length){
		location = new int[length][2];
		show = id;
	}

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
