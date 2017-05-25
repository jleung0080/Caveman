package guiPractice.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

class AnotherScreen extends Screen implements MouseMotionListener, MouseListener{

	private TextArea para;
	private Button back;
	private Button picture;
	

	public AnotherScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		back = new Button(50,50,100,60,"Back",Color.GRAY, new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.coordScreen);
			}
		});
		picture = new Button(450,50,100,60,"Picture",Color.BLUE, new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.picScreen);
			}
		});
		para = new TextArea(240, 185, 550, 500, "Oh baby a triple.");
		viewObjects.add(para);
		viewObjects.add(back);
		viewObjects.add(picture);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(back.isHovered(e.getX(), e.getY())){
			  back.act();
		}
		if(picture.isHovered(e.getX(), e.getY())){
			  picture.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MouseListener getMouseListener(){
		return this;
	}
}
