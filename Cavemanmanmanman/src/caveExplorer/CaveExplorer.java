package caveExplorer;

import java.util.Scanner;

import haoSyed.TilesGameStart;
import joeyRichard.Temp;
import katherineRisa.MainEvent;

public class CaveExplorer {

	public static CaveRoomPd8[][] caves;
	public static Scanner in;
	public static CaveRoomPd8 currentRoom;
	public static Inventory inventory;
	
	public static void main(String[] args) {
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

}