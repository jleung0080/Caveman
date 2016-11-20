package joeyRichard;
public class Cars {
	public int[][] location;
	public int[] startPos;
	public int[] endPos;
	public Cars(String id, int length){
		location = new int[length][2];
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
			}
		}else{
			for(int i=0; i<location.length;i++){
				location[i][0] = startPos[0]+i;
				location[i][1] = startPos[1];
			}
		}
	}
}
