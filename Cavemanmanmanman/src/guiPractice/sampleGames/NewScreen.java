package guiPractice.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class NewScreen extends Screen implements MouseMotionListener, MouseListener {

	private ClickableGraphic picture;
	private Graphic pictures;
	
	public NewScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		picture = new ClickableGraphic(50, 50, .5, "resources/sampleImages/Angry_Facebook_React_Face.png");
		picture.setAction(new Action() {
			public void act(){
				pictures = new Graphic((int)(Math.random() * 600), (int)(Math.random() * 350), .5, "resources/sampleImages/Angry_Facebook_React_Face.png");
				viewObjects.add(pictures);
			}
		});
		viewObjects.add(picture);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(picture.isHovered(e.getX(), e.getY())){
			  picture.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
