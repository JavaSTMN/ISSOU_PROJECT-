import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Layout implements IObserver {

	private JPanel panel;

	public int nbLine;
	public int nbColum;
	public boolean resultLine[];
	public boolean resultCol[];

	private Box matrice[][];

	int tabCond[][][];

	public Layout(ArrayList<ArrayList<Integer>> lineSpec, ArrayList<ArrayList<Integer>> colSpec, LabelPicross condVert,
			LabelPicross condHorz) {
		GridBagConstraints d = new GridBagConstraints();
		this.nbLine = lineSpec.size();
		this.nbColum = colSpec.size();

		JFrame.setDefaultLookAndFeelDecorated(true);

		this.panel = new JPanel(new GridBagLayout());
		this.matrice = new Box[this.nbLine][this.nbColum];
		GridBagConstraints c = new GridBagConstraints();
		for (int line = 0; line < this.nbLine; line++) {
			c.gridx = 0;
			c.gridy = line + 1;

		}

		for (int line = 0; line < this.nbLine; line++) {
			d.gridx = 0;
			d.gridy = line + 1;
			this.panel.add(condVert.getLabel(false, line), d);
			for (int col = 0; col < this.nbColum; col++) {
				c.gridx = col + 1;
				c.gridy = line + 1;
				Box newBox = new Box(line, col);
				newBox.addObserver((IObserver)this);
				this.matrice[line][col] = newBox;
				this.panel.add(this.matrice[line][col].getButton(), c);

			}
		}
		for (int col2 = 0; col2 < this.nbColum; col2++) {
			d.gridx = col2 + 1;
			d.gridy = 0;
			this.panel.add(condHorz.getLabel(true, col2), d);
		}
	}

	public void update(IObservable observable) {
		Box b = (Box)observable;
		b.getLine();
		b.getColum();
	}

	private boolean verifLine(int line) {

		return true;
	}

	private boolean verifCol(int Col) {

		return true;
	}

	public JPanel getPanel() {
		return this.panel;
	}
}