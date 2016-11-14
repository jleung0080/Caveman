package caveExplorer;

public class Inventory {

	private boolean hasMap;
	private String map;
	
	public Inventory() {
		hasMap = true;
		updateMap();
	}

	public void updateMap() {
		CaveRoomPd8[][] caves = CaveExplorer.caves;
		//convert these caves to a string representation
		
		//top side. horizontal line across top row with 4
		// except for last column
		map = " ";
		for(int i = 0; i < caves[0].length - 1; i++){
			map += "____";
		}
		
		map += "___\n";
		
		//each room
		for(CaveRoomPd8[] row : caves){
			//3 rows of text
			for(int textRow  = 0; textRow < 3; textRow++){
				for(CaveRoomPd8 cr : row){
					String str = "|   ";
					String content = cr.getContents();
					
					
					if(textRow == 1){
						if(cr.getDoor(CaveRoomPd8.WEST) != null && cr.getDoor(CaveRoomPd8.WEST).isOpen())
							str = "  " + content + " ";
						else
							str = "| " + content + " ";
					}
					else if(textRow == 2){
						if(cr.getDoor(CaveRoomPd8.SOUTH) != null && cr.getDoor(CaveRoomPd8.SOUTH).isOpen()){
							str = "|_ _";
						}
						else{
							str = "|___";
						}
					}
					map+= str;
				}// ends row of caveroom
				map += "|\n";
			}
		}
		
	}

	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
	}

	public String getDescription() {
		if(hasMap)
			return map;
		else
			return "You have no inventory";
	}

}
