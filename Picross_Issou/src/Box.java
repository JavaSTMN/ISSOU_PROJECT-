import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Color;

public class Box implements ActionListener, IObservable {

	/*
	 * This class is for make a box for layout You can access variable color, button
	 * and you have function for get size. getStatus() for status of box black or
	 * white
	 */

	private int height;
	private int width;
	private int comptEtat;
	private Insets f;
	public JButton button;
	public Color color;
	public int line;
	public int colum;
	public ArrayList<IObserver> Observer;

	public Box(int line, int colum) {
		this.button = new JButton();
		this.height = 20;
		this.width = 20;
		this.line = line;
		this.colum = colum;
		this.f = new Insets(0, 0, 0, 0);
		this.button.setMargin(f);
		this.color = Color.WHITE;
		setColor(Color.WHITE);
		setSizeBox();
		this.comptEtat = 0;
		this.button.addActionListener(this);
		this.Observer = new ArrayList<>();
	}

	public JButton getButton() {
		return this.button;
	}

	public int getLine() {
		return this.line;
	}

	public int getColum() {
		return this.colum;
	}
		
	public boolean getStatus() {
		if (this.color.equals(Color.BLACK)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	public void actionPerformed(ActionEvent e) {
		this.comptEtat = this.comptEtat + 1;
		if (this.comptEtat == 0) {
			this.button.setText("");
			setColor(Color.WHITE);
		} else if (this.comptEtat == 1) {
			this.button.setText("");
			setColor(Color.BLACK);
		} else {
			this.comptEtat = -1;
			this.button.setText("X");
			setColor(Color.WHITE);
			this.button.setForeground(Color.RED);
		}
		notifyObservable();
	}

	public void setSizeBox() {
		this.button.setPreferredSize(new Dimension(this.height, this.width));
	}

	public void setColor(Color Color) {
		this.color = Color;
		this.button.setForeground(this.color);
		this.button.setBackground(this.color);
	}

	public void notifyObservable() {
		for (IObserver l : this.Observer) {
			l.update(this);
		}
	}

	public void addObserver(IObserver observer) {
		this.Observer.add(observer);
	}
}
