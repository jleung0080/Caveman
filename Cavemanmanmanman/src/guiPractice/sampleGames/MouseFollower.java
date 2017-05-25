package guiPractice.sampleGames;

import guiPractice.GUIApplication;

public class MouseFollower extends GUIApplication {

	public static CoordinateScreen coordScreen;
	public static AnotherScreen myScreen;
	public static NewScreen picScreen;
	public static MouseFollower game;
	
	public static void main (String[] args){
		game = new MouseFollower();
		Thread app = new Thread(game);
		app.start();
	}
	
	@Override
	protected void initScreen() {
		myScreen = new AnotherScreen(getWidth(), getHeight());
		coordScreen = new CoordinateScreen(getWidth(), getHeight());
		picScreen = new NewScreen(getWidth(), getHeight());
		setScreen(coordScreen);
	}

}
