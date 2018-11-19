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

public class Layout {
	static JFrame frame;
	private JPanel panel;

	public int nbLine;
	public int nbColum;
	public boolean resultLine[];
	public boolean resultCol[];
	
	private Box matrice[][];
	// private Label label[];
	int tabCond[][][];

	//public Layout(ArrayList<ArrayList<Integer>> lineSpec, ArrayList<ArrayList<Integer>> colSpec) {
	public Layout(int[][]lineSpec, int[][] colSpec) {
//		this.nbLine = lineSpec.size();
//		this.nbColum = colSpec.size();
		
		this.nbLine = lineSpec.length;
		this.nbColum = colSpec.length;

		JFrame.setDefaultLookAndFeelDecorated(true);
		this.frame = new JFrame("Layout Test");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel(new GridBagLayout());

		this.matrice = new Box[this.nbLine][this.nbColum];
		GridBagConstraints c = new GridBagConstraints();
		for (int line = 0; line < this.nbLine; line++) {
			for (int col = 0; col <  this.nbColum; col++) {
				
			}
		}
		for (int line = 1; line <= this.nbLine; line++) {
			for (int col = 1; col <= this.nbColum; col++) {
				c.gridx = col;
				c.gridy = line;
				this.matrice[line][col] = new Box(line, col);
				this.panel.add(this.matrice[line][col].getButton(),c);

			}
		}
		this.frame.setContentPane(panel);
		this.frame.pack();

		this.frame.setVisible(true);
	}

}