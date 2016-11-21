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
	

	public void changePos(String direction, int spaces){
		if(direction == "left"){
			for(int i = 0; i< location.length; i++){
				
			}
		}else if(direction == "right"){
			
		}else if(direction == "up"){
			
		}else if(direction == "down"){
			
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
