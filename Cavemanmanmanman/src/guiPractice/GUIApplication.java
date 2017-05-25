package guiPractice;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable{
	
	private Screen currentScreen;
	
	public GUIApplication(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		int x = 0;
		int y = 0;
		int width = 716;
		int height = 738;
		setBounds(x, y, width, height);
		initScreen();
		
		setVisible(true);
	}

	protected abstract void initScreen();
	
	public void setScreen(Screen screen){
		//stop controls from last screen
		if (currentScreen != null){
			if (currentScreen.getMouseListener() != null){
				removeMouseListener(currentScreen.getMouseListener());
			}
			if (currentScreen.getMouseMotionListener() != null){
				removeMouseMotionListener(currentScreen.getMouseMotionListener());
			}
			if (currentScreen.getKeyListener() != null){
				removeKeyListener(currentScreen.getKeyListener());
			}
			
		}
		currentScreen = screen;
		//add controls for new Screen
		if (currentScreen != null){
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
			addKeyListener(currentScreen.getKeyListener());
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
	
	public void run(){
		while (true){
//			currentScreen.update();
			//update the window
			repaint();
			try {
				Thread.sleep(40);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	
}
