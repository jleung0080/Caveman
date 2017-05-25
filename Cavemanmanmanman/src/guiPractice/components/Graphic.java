package guiPractice.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Graphic implements Visible {

	private int x;
	private int y;
	private BufferedImage image;
	private boolean loadedImages;
	
	
	
	public Graphic(int x, int y, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, 0, 0);
	}
	
	public Graphic(int x, int y, int w, int h, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, w, h);
	}
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	public Graphic(int x, int y, double scale, String imageLocation){
		this.x = x+8;
		this.y = y+30;
		loadedImages = false;
		loadImages(imageLocation, scale);
	}
	
	private void loadImages(String imageLocation, int w, int h) {
		try{
			ImageIcon icon = new ImageIcon(imageLocation);
			
			if (w == 0 && h == 0){
				image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
			}else{
				//custom size
				image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				//select coodinates of top left rectangle within image
				//then select width and height to display graphic
				//THEN of the icon you want to display
				//select x, y, coordiantes and width height
				//this can split an image into parts
				g.drawImage(icon.getImage(), 0, 0, w, h, 0, 0, icon.getIconWidth(), icon.getIconHeight(), null);
			}
			loadedImages = true;
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void loadImages(String imageLocation, double scale) {
		try{
			ImageIcon icon = new ImageIcon(imageLocation);
			int newWidth = (int)(icon.getIconWidth() * scale);
			int newHeight = (int)(icon.getIconHeight() * scale);
			image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(icon.getImage(), 0, 0, newWidth, newHeight, 0, 0, icon.getIconWidth(), icon.getIconHeight(), null);
			loadedImages = true;
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	//SETS THE IMAGES 8 PIXELS AND 30 PIXELS OFFSET SO THAT THE BORDERS ARE ACCOUNTED FOR
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
	

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight();
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		//does nothing image never changes
	}

}
