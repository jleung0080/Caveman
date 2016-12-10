package joeyRichard;

public class JoeyClass {
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
	
}
