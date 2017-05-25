package guiPractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiPractice.components.Visible;

public abstract class Screen {

	private int width;
	private int height;
	protected ArrayList<Visible> viewObjects;
	protected BufferedImage image;
	
	public Screen(int width, int height){
		viewObjects = new ArrayList<Visible>();
		this.width = width;
		this.height = height;
		initObjects(viewObjects);
		initImage();
	}

	public abstract void initObjects(ArrayList<Visible> viewObjects);
	
	private void initImage() {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}

	public void update() {
		//draw stuff
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		//draw all visible components
		for (Visible v: viewObjects){
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
//		g.setFont(new Font("Helvetica", Font.PLAIN, 20));
//		g.drawString("Hello", 40, 80);
//		g.drawOval(0, 40, 120, 80);
//		g.drawRect(20, 120, 80, 110);
//		g.drawLine(100, 120, 110, 200);
//		g.setColor(Color.green);
//		for (int i = 0; i < image.getWidth(); i += 4){
//			g.drawLine(i, 230, i, 234);
//		}
	}
	
	public void remove(Visible v){
		/**ArrayList notes
		 * While this method is very simple, do not underestimate
		 * the trickiness of removing items in an ArrayList
		 * It causes indieces to change
		 * Example suppose you have an ArrayList<Integers>
		 * and you want to remove all values greater than 5
		 * This is BAD:
		 * 
		 * for (int i = 0; i < list.size(); i++){
		 * 		if (list.get(i) > 5) list.remove(i);
		 * }
		 * Why is this bad?
		 * Suppose you have (4,5,6,7)
		 * the first Integer to be removed is 6, at index 2
		 * since it gets removed, 7 moves from index 3 to 2
		 * list is now (4,5,7)
		 * after you increment i, i = 3.
		 * This is out of bounds, therefore resulting an exception and 7 never gets removed.
		 * Instead, when an object is removed, 
		 * decrease i to compensate for change in list.length()
		 * 
		 * CORRECT:
		 * 
		 * for (int i = 0; i < list.size(); i++){
		 * 		if (list.get(i) > 5){
		 * 			list.remove(i);
		 * 			i--;
		 * 		}
		 * }
		 * 
		 * ALSO CORRECT
		 * for (int i = 0; i < list.size(); i++){
		 * 		while (i < list.size() && list.get(i) > 5) list.remove(i);
		 * }
		 * 
		 * This way, i stays at the same index
		 * and therefore the array out of bounds exception will never occur
		 * 
		 * following doesn't work:
		 * for (Integer i: list){
		 * 		if (i > 5) list.remove(i);
		 * }
		 * 
		 * finally if you remove using an index, it returns the removed object so you can do this
		 * System.out.println(list.remove(0).toString() + " was removed");
		 * 
		 */
		viewObjects.remove(v);
		/**
		 * This removes the objects that have the same identity as v,
		 * not an object that is equal to v
		 */
		
	}
	
	public void moveToFront(Visible v){
		if (viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}
	
	public void moveToBack(Visible v){
		//moves all objects with index >= n
		//or by 1, increases size by 1
		//adds object to index n
		if (viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(0, v);
		}
	}
	
	public BufferedImage getImage(){
		return image;
	}

	public MouseListener getMouseListener() {
		return null;
	}

	public MouseMotionListener getMouseMotionListener() {
		return null;
	}
	
	public KeyListener getKeyListener() {
		return null;
	}

	public void addObject(Visible v) {
		viewObjects.add(v);
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
