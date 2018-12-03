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

public class Layout implements IObserver,IObservable2 {

	private JPanel panel, panel2, panel3;
	public ArrayList<ArrayList<Integer>> listCond;
	public int nbLine;
	public int nbColum;
	public boolean orientation;
	public boolean[] resultLine;
	public boolean[] resultCol;
	public LabelPicross ListCondHorz[];
	public LabelPicross ListCondVert[];
	private Box matrice[][];
	public ArrayList<ArrayList<Integer>> lineSpec;
	public ArrayList<ArrayList<Integer>> colSpec;
	int tabCond[][][];
	public ArrayList<IObserver2> Observer;
	
	public Layout(ArrayList<ArrayList<Integer>> lineSpec, ArrayList<ArrayList<Integer>> colSpec) {

		this.lineSpec = lineSpec;
		this.colSpec = colSpec;
		this.nbLine = this.lineSpec.size();
		this.nbColum = this.colSpec.size();
		this.ListCondVert = new LabelPicross[nbColum];
		this.ListCondHorz = new LabelPicross[nbLine];
		this.resultLine = new boolean[nbLine];
		this.resultCol = new boolean[nbColum];
		this.Observer = new ArrayList<>();
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
			this.panel.add(LabelTemp.getPanelLabel(), d);// label verticaux

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
			LabelPicross LabelTemp = new LabelPicross(true, colSpec.get(col2));
			this.ListCondVert[col2] = LabelTemp;
			this.panel.add(LabelTemp.getPanelLabel(), d);
		}
		// debug
//		this.matrice[0][0].setColor(Color.BLACK);
//		this.matrice[0][1].setColor(Color.BLACK);
//		this.matrice[0][3].setColor(Color.BLACK);
		// debug
	}

	public void update(IObservable observable) {
		Box b = (Box) observable;
		b.getColum();
		verifLine(b.getLine());
		verifCol(b.getColum());
//		if (isWin()) {
//			notifyObservable2();
//		}
	}

	private void verifLine(int line) {
		// System.out.println(ListCondHorz[line].getCond());
		int result = 1;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
		for (int i = 0; i < this.nbLine; i++) {
			if (this.matrice[line][i].getStatus() == true) {
				for (int j = i + 1; j < this.nbColum; j++) {
					if (this.matrice[line][j].getStatus() == true && this.matrice[line][j - 1].getStatus() == true) {
						i = j;
						result++;
					} else {
						break;
					}
				}
				tabTemp.add(result);
				result = 1;
			}
		}
		if (ListCondHorz[line].getCond().equals(tabTemp)) {
			//System.out.println("ligne est validée");
			this.ListCondHorz[line].setBackgroundTrue(Color.GREEN);
			this.resultLine[line] = true;
		} else {
			this.ListCondHorz[line].setBackgroundTrue(null);
			this.resultLine[line] = false;
		}
	}

	private void verifCol(int Col) {
		int result2 = 1;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
		for (int i = 0; i < this.nbLine; i++) {
			if (this.matrice[i][Col].getStatus() == true) {
				for (int j = i + 1; j < this.nbColum; j++) {
					if (this.matrice[j][Col].getStatus() == true && this.matrice[j - 1][Col].getStatus() == true) {
						i = j;
						result2++;
					} else {
						break;
					}
				}
				tabTemp.add(result2);
				result2 = 1;
			}

		}
		if (ListCondVert[Col].getCond().equals(tabTemp)) {
			//System.out.println("col est validée");
			this.ListCondVert[Col].setBackgroundTrue(Color.GREEN);
			this.resultCol[Col] = true;
		} else {
			this.ListCondVert[Col].setBackgroundTrue(null);
			this.resultCol[Col] = false;
		}
	}

	private boolean isWin() {
		for (boolean b : this.resultLine)
			if (!b)
				return false;
		for (boolean b : this.resultCol)
			if (!b)
				return false;
		return true;
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public void notifyObservable2() {
		for (IObserver2 l : this.Observer) {
			l.updateWin(this);
		}
	}
	
	public void addObserver2(IObserver2 observer) {
		this.Observer.add(observer);
	}

	
}