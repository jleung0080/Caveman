package guiPractice.sampleGames;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class BlankScreenGames extends GUIApplication {

	
	
	@Override
	protected void initScreen() {
		Screen s = new BlankScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		new BlankScreenGames();

	}

}
