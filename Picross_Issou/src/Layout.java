import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Color;
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
	// private Label label[];
	int tabCond[][][];

	 public Layout(ArrayList<ArrayList<Integer>> lineSpec, ArrayList<ArrayList<Integer>> colSpec) {
	//public Layout(int[][] lineSpec, int[][] colSpec) {
		this.nbLine = lineSpec.size();
		this.nbColum = colSpec.size();

//		this.nbLine = lineSpec.length;
//		this.nbColum = colSpec.length;
		System.out.println(this.nbLine);
		System.out.println(this.nbColum);

		JFrame.setDefaultLookAndFeelDecorated(true);
		
		this.panel = new JPanel(new GridBagLayout());

		this.matrice = new Box[this.nbLine][this.nbColum];
		GridBagConstraints c = new GridBagConstraints();
//		for (int line = 0; line < this.nbLine; line++) {
//			for (int col = 0; col <  this.nbColum; col++) {
//				
//			}
//		}
		for (int line = 0; line < this.nbLine; line++) {
			for (int col = 0; col < this.nbColum; col++) {
				c.gridx = col + 1;
				c.gridy = line + 1;
				this.matrice[line][col] = new Box(line, col);
				this.panel.add(this.matrice[line][col].getButton(), c);

			}
		}
	
	}

	public void update(Box b) {
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