package guiPractice.sampleGames;

import guiPractice.GUIApplication;

public class ClickGraphicsGame extends GUIApplication {


	public static void main(String[] args){
		ClickGraphicsGame stuff = new ClickGraphicsGame();
		Thread app = new Thread(stuff);
		app.start();
	}
	@Override
	protected void initScreen() {
		NewScreen gcs = new NewScreen(getWidth(), getHeight());
		setScreen(gcs);
	}

}
