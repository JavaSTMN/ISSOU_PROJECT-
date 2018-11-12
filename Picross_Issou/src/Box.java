import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Box implements ActionListener {
	
	/*
	 * This class is for make a box for layout
	 * You can access variable color, button and you have function for get size.
	 * getStatus() for status of box black or white 
	 */
	
	private int height;
	private int width;
	public JButton button;
	public Color color;
	public int row;
	public int colum;

	public Box(int row,int colum) {
		JButton new_button = new JButton();
		this.button = new_button;
		this.height = 20;
		this.width = 20;
		this.row = row;
		this.colum = colum;
		setColor(Color.WHITE);
		setSizeBox();	
		this.button.addActionListener(this);
	}
	
	public JButton getButton() {
		return this.button;
	}	

	public int getRow() {
		return this.row;
	}
	
	public int getColum() {
		return this.colum;
	}
	
	public void changeColor() {
		if(this.color.equals(Color.BLACK)) {
			setColor(Color.WHITE);
		} else {
			setColor(Color.BLACK);
		}
	}
	
	public boolean getStatus() {
		if(this.color.equals(Color.BLACK)) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
		
	}
	
    public void actionPerformed(ActionEvent e) {
        changeColor();
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
