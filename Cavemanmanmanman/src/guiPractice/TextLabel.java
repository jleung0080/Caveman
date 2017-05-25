package guiPractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class TextLabel extends Component {

	private String text;
	private String font;
	private int size;
	
	public TextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h);
		this.text = text;
		font = "Helvetica";
		size = 20;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		if (text != null){
			g.setFont(new Font(font, Font.PLAIN, size));
			g.drawString(text, 4, getHeight() - 5);
		}
	}

	public void setText(String s){
		this.text = s;
		update();
	}
	
	public String getText() {
		return text;
	}

	public String getFont() {
		return font;
	}

	public int getSize() {
		return size;
	}

	public void setFont(String s){
		this.font = s;
		update();
	}
	
	public void setSize(int s){
		this.size = s;
		update();
	}
}
