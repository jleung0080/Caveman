package joeyRichard;

public class Cars {
	public static int[][] location;
	public static int[] startPos;
	public static int[] endPos;
	public Cars(String id, int length){
		location = new int[length][2];
	}

	public static void changePos(){

	}

	public static void setPos(){
		if(startPos[0] == endPos[0]){
			for(int i=0; i<location.length;i++){
				location[i][0] = startPos[0];
				location[i][1] = startPos[1]+i;
			}
		}else{
			for(int i=0; i<location.length;i++){

			}
		}
	}
}
