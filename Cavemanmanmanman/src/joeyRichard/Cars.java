package joeyRichard;
import joeyRichard.Temp;
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
		Temp.direction = Temp.selectDirection();
		while(!Temp.isValidDirection(Temp.direction)){
			Temp.direction = Temp.selectDirection();
		}
		System.out.println("How many spaces would you like to sleigh the car in that direction?");
		spaces = Temp.getInt();
		while(!validMove(spaces)){
			System.out.println("That is an invalid move. Please enter a valid number of spaces to move the sleigh.");
			spaces = Temp.getInt();
		}
		changePos(Temp.direction,spaces);
	}

	public void cpuPerformMove(){
		String[] possible = {"left", "right", "up", "down"};
		Temp.direction = "";
		for(int car:Temp.horizontal){
			if(Temp.selectedCar == car){
				Temp.direction = possible[(int)(Math.random()*2)];
			}
		}
		for(int car:Temp.vertical){
			if(Temp.selectedCar == car){
				Temp.direction = possible[(int)(Math.random()*2)+2];
			}
		}
		int spaces;
		spaces = (int)(Math.random()*5);
		while(!validMove(spaces)){
			System.out.println("That is an invalid move. Please enter a valid number of spaces to move the sleigh.");
			spaces = Temp.getInt();
		}
		System.out.println("Other Santa decides to move car "+Temp.selectedCar+" "+Temp.direction+" "+spaces+
				" spaces.");
		changePos(Temp.direction,spaces);
	}



	private boolean validMove(int spaces){
		for(int i=1; i<=spaces; i++){
			if(Temp.direction == "left"){
				if(location[0][1]-i<0){
					return false;
				}else{
					if(Temp.check[location[0][0]][location[0][1]-i]){
						return false;
					}
				}
			}else if(Temp.direction == "right"){
				if(location[0][1]+i>14){
					return false;
				}else{
					if(Temp.check[location[0][0]][location[0][1]+i]){
						return false;
					}
				}
			}else if(Temp.direction == "up"){
				if(location[0][0]-i<0){
					return false;
				}else{
					if(Temp.check[location[0][0]-i][location[0][1]]){
						return false;
					}
				}
			}else{
				if(location[location.length-1][0]+i>7){
					return false;
				}else{
					if(Temp.check[location[location.length-1][0]+i][location[location.length-1][1]]){
						return false;
					}
				}
			}

		}
		return true;
	}
	public void changePos(String direction, int spaces){
		for(int[] point:location){
			Temp.check[point[0]][point[1]]=false;
			Temp.grid[point[0]][point[1]]=null;
		}
		for(int i =0;i<location.length;i++){
			if(Temp.direction == "left"){
				Temp.check[location[i][0]][location[i][1]-spaces]=true;
				Temp.grid[location[i][0]][location[i][1]-spaces]=show;
				location[i][1] = location[i][1]-spaces;
			}else if(Temp.direction == "right"){
				Temp.check[location[i][0]][location[i][1]+spaces]=true;
				Temp.grid[location[i][0]][location[i][1]+spaces]=show;
				location[i][1] = location[i][1]+spaces;
			}else if(Temp.direction == "up"){
				Temp.check[location[i][0]-spaces][location[i][1]]=true;
				Temp.grid[location[i][0]-spaces][location[i][1]]=show;
				location[i][0] = location[i][0]-spaces;
			}else{
				Temp.check[location[i][0]+spaces][location[i][1]]=true;
				Temp.grid[location[i][0]+spaces][location[i][1]]=show;
				location[i][0] = location[i][0]+spaces;
			}
		}
	}

	public void setPos(){
		if(startPos[0] == endPos[0]){
			for(int i=0; i<location.length;i++){
				location[i][0] = startPos[0];
				location[i][1] = startPos[1]+i;
				Temp.grid[location[i][0]][location[i][1]] = show;
				Temp.check[location[i][0]][location[i][1]] = true;
			}
		}else{
			for(int i=0; i<location.length;i++){
				location[i][0] = startPos[0]+i;
				location[i][1] = startPos[1];
				Temp.grid[location[i][0]][location[i][1]] = show;
				Temp.check[location[i][0]][location[i][1]] = true;
			}
		}
	}
}
