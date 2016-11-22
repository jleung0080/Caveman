package caveExplorer;

import java.util.Scanner;

import haoSyed.TilesGameStart;
import joeyRichard.Temp;
import katherineRisa.MainEvent;

public class CaveExplorer {
	static Scanner input;

	public static CaveRoomPd8[][] caves;
	public static Scanner in;
	public static CaveRoomPd8 currentRoom;
	public static Inventory inventory;
	private static String[] introduction = {"Hey you!", "Yes, you!", "Do you think you can do us a favor?",
											"See, Christmas is coming around but Santa is too sick to deliver the presents.",
											"We need to find a substitute, and I think a person like you would definetely qualify."};
	private static String[] respondsNo = {"C'mon you can do this.", "Don't you want to be on Santa's nice list?",
										  "You'll be bringing joy to children around the world!", 
										  "If you don't say yes I will make Christmas your worst nightmare."};
	private static String[] respondsYes = {"Great! I'll tell you what you need to do.", 
									       "First, we need to get the presents.",
									       "Then we have to order them into the bags.",
									       "Oh, I might have forgotten to tell you but you aren't exactly 'official' yet.",
									       "What I mean is that there are others just like you, whom you will race.",
									       "The fastest racer will become the substitute Santa, so get Started right now!"};
	private static boolean accept = false;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		readSequence(introduction);
		System.out.print("Will you help us?\n");
		String response = userInput();
		int ctr = 0;
		while(!accept){
			if(response.toLowerCase().equals("yes")){
				readSequence(respondsYes);
				accept = true;
			}
			else{
				System.out.println(respondsNo[ctr]);
				ctr ++;
				System.out.print("Will you help us?\n");
				response = userInput();
			}
		}
		
		in = new Scanner(System.in);
		caves = new CaveRoomPd8[3][4];
		for(int row = 0; row < caves.length; row++){
			for(int col = 0; col < caves[row].length; col++){
				caves[row][col] = new CaveRoomPd8("This room has coordinates (" + row + ", " + col + ")");
			}
		}
		
		currentRoom = caves[2][0];
		caves[0][1] = new EventRoom("This is where you found the key", new MainEvent());
		caves[1][3] = new EventRoom("", new Temp());
		caves[2][3] = new EventRoom("", new TilesGameStart());
		
		currentRoom.enter();

		caves[2][0].setConnection(CaveRoomPd8.EAST, caves[2][1], new Door(true, false));
		caves[2][1].setConnection(CaveRoomPd8.NORTH, caves[1][1], new Door(true, false));
		caves[1][1].setConnection(CaveRoomPd8.NORTH, caves[0][1], new Door(true, false));
		caves[1][1].setConnection(CaveRoomPd8.WEST, caves[1][0], new Door(true, false));
		caves[0][1].setConnection(CaveRoomPd8.WEST, caves[0][0], new Door(true, false));
		caves[0][1].setConnection(CaveRoomPd8.EAST, caves[0][2], new Door(true, false));
		caves[1][1].setConnection(CaveRoomPd8.EAST, caves[1][2], new Door(true, false));
		caves[1][2].setConnection(CaveRoomPd8.SOUTH, caves[2][2], new Door(true, false));
		caves[2][2].setConnection(CaveRoomPd8.WEST, caves[2][1], new Door(true, false));
		caves[1][3].setConnection(CaveRoomPd8.SOUTH, caves[2][3], new Door(true, false));
		caves[1][2].setConnection(CaveRoomPd8.EAST, caves[1][3], new Door(false, true));
		inventory = new Inventory();
		startExploring();
		
	}

	private static void startExploring() {
		while(true){
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			act(input);
		}
	}
	
	private static void act(String input) {
		currentRoom.interpretAction(input);
		
	}

	public static void print(String text){
		System.out.println(text);
	}
	
	public static String userInput(){
		String uInput = input.nextLine();
		return uInput;
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			System.out.println(s);
			System.out.println("- - - Press Enter - - -");
			input.nextLine();
		}
	}

}