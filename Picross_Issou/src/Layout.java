import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;

public class Layout implements IObserver  {

	private JPanel panel, panel2, panel3;
	public ArrayList<ArrayList<Integer>> listCond;
	public int nbLine;
	public int nbColum;
	public boolean orientation;
	public int[] resultLine;
	public int[] resultCol;
	public LabelPicross ListCondHorz[];
	public LabelPicross ListCondVert[];
	private Box matrice[][];
	public ArrayList<ArrayList<Integer>> lineSpec;
	public ArrayList<ArrayList<Integer>> colSpec;
	int tabCond[][][];

	public Layout(ArrayList<ArrayList<Integer>> lineSpec, ArrayList<ArrayList<Integer>> colSpec) {

		this.lineSpec = lineSpec;
		this.colSpec = colSpec;
		this.nbLine = this.lineSpec.size();
		this.nbColum = this.colSpec.size();
		this.ListCondVert = new LabelPicross[nbColum];
		this.ListCondHorz = new LabelPicross[nbLine];
		this.resultLine = new int[nbLine];
		this.resultCol = new int[nbColum];
		
		GridBagConstraints d = new GridBagConstraints();
		
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
			LabelPicross LabelTemp = new LabelPicross(false, lineSpec.get(line));
			this.ListCondHorz[line] = LabelTemp;  
			this.panel.add(LabelTemp.getPanelLabel(),d);// label verticaux
			
			for (int col = 0; col < this.nbColum; col++) {
				c.gridx = col + 1;
				c.gridy = line + 1;
				Box newBox = new Box(line, col);
				newBox.addObserver((IObserver) this);
				this.matrice[line][col] = newBox;
				this.panel.add(this.matrice[line][col].getButton(), c);

			}
		}
		for (int col2 = 0; col2 < this.nbColum; col2++) {
			d.gridx = col2 + 1;
			d.gridy = 0;
			LabelPicross LabelTemp = new LabelPicross(true, lineSpec.get(col2));
			this.ListCondVert[col2] = LabelTemp;
			this.panel.add(LabelTemp.getPanelLabel(), d);
		}
	}

	public void update(IObservable observable) {
		Box b = (Box) observable;
		b.getColum();
		//verifLine(b.getLine());
		verifCol(b.getColum());
		
	}

	private boolean verifLine(int line) {
		//System.out.println(ListCondHorz[line].getCond());
		int result = 1;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
		for (int i = 0 ; i<this.nbLine-1; i++) {
			if(this.matrice[line][i].getStatus() == true) {
				for (int j = i+1; j<this.nbColum; j++) {
					if(this.matrice[line][j].getStatus() == true && this.matrice[line][j-1].getStatus() == true) {
						i = j;
						result ++;
					}
				}
				tabTemp.add(result);
			}
			
		}
		if(ListCondHorz[line].getCond().equals(tabTemp)) {
			System.out.println("ligne est validée");
		}
		if(!ListCondHorz[line].getCond().equals(tabTemp)) {
			System.out.println("T TRO NUL");
		}
		
		return true;
	}

	private boolean verifCol(int Col) {
		System.out.println(ListCondHorz[Col].getCond());
		int result2 = 1;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
		for (int i = 0 ; i<this.nbLine-1; i++) {
			if(this.matrice[i][Col].getStatus() == true) {
				for (int j = i+1; j<this.nbColum; j++) {
					if(this.matrice[j][Col].getStatus() == true && this.matrice[j-1][Col].getStatus() == true) {
						i = j;
						result2 ++;
					}
				}
				tabTemp.add(result2);
			}
			
		}
		if(ListCondHorz[line].getCond().equals(tabTemp)) {
			System.out.println("ligne est validée");
		}
		if(!ListCondHorz[line].getCond().equals(tabTemp)) {
			System.out.println("T TRO NUL");
		}
		
		return true;
		return true;
	}

	public JPanel getPanel() {
		return this.panel;
	}

}