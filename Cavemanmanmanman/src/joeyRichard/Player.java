package joeyRichard;
public class Player {
	public int[] position;
	
	public Player(String id){
		String name = id;
	}
	
	public static void main(String[] args) {
		System.out.print(roll());
	}
	
	public static int roll(){
		return (int)(Math.random()*6+1);
	}
}
