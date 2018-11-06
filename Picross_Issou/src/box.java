import java.awt.Dimension;
import javax.swing.*;
import java.awt.Color;

public class box {
	
	/*
	 * This class is for make a box for layout
	 * You can access variable color, button and you have function for get size.
	 * getStatus() for status of box black or white 
	 */
	
	private int height;
	private int width;
	public JButton button;
	public Color color;

	public box(int height, int width) {
		JButton new_button = new JButton();
		this.button = new_button;
		this.height = height;
		this.width = width;
		this.color = Color.WHITE;
		this.button.setForeground(color);
		setSizeBox();	
	}
	
	public JButton getButton() {
		return this.button;
	}	
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}

	public void change_color() {
		if(this.color.equals(Color.BLACK)) {
			setColor(Color.WHITE);
		} else {
			setColor(Color.BLACK);
		}
	}
	
	public boolean getStatus() {
		if(this.color.equals(color.BLACK)) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
		
	}
	
	private void setSizeBox() {
	    this.button.setPreferredSize(new Dimension(this.height, this.width));
	}
	
	private void setColor(Color Color) {
		this.color = Color;
		this.button.setForeground(this.color);
		this.button.setBackground(this.color);
	}
	
}
