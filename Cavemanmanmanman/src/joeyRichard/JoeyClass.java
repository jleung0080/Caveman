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
