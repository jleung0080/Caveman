package guiPractice;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import guiPractice.components.Clickable;
import guiPractice.components.Visible;
import rhbattlesandstuff.NotPokemonDungeonFinalFantasyCrossOverGame;

public abstract class ClickableScreen extends Screen implements MouseListener, KeyListener {

	private ArrayList<Clickable> clickables;
	
	public ClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < clickables.size(); i++){
			Clickable c = clickables.get(i);
			if (c.isHovered(e.getX(), e.getY())){
				c.act();
				break;
			}
		}

	}
	public void moveToBack(Visible v){
		super.moveToBack(v);
		if(clickables.contains(v)){
			clickables.remove(v);
			clickables.add(0,(Clickable) v);
			}
		}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		cursorTo("src/resources/sand.png");
	}
	private void cursorTo(String s){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(s);
		Cursor c = toolkit.createCustomCursor(image , new Point(0, 0), "img");
		NotPokemonDungeonFinalFantasyCrossOverGame.pmdffcog.setCursor (c);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		cursorTo("src/resources/grass.png");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		cursorTo("src/resources/sand.png");
	}
	
	@Override
	public void addObject(Visible v){
		super.addObject(v);
		if (v instanceof Clickable){
			clickables.add((Clickable) v);
		}
	}
	
	public void remove(Visible v){
		super.remove(v);
		clickables.remove(v);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for (Visible v: viewObjects){
			if(v instanceof Clickable){
				clickables.add((Clickable) v);
			}
		}

	}

	public MouseListener getMouseListener(){
		return this;
	}
	
	public KeyListener getKeyListener(){
		return this;
	}
	
	public  void initAllObjects(ArrayList<Visible> viewObjects){
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
