import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Layout implements IObserver {

	private JPanel panel;
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

	public Layout(ArrayList<ArrayList<Integer>> lineSpec, ArrayList<ArrayList<Integer>> colSpec) {
		
		this.lineSpec = lineSpec;
		this.colSpec = colSpec;
		this.nbLine = this.lineSpec.size();
		this.nbColum = this.colSpec.size();
		this.ListCondVert = new LabelPicross[nbColum];
		this.ListCondHorz = new LabelPicross[nbLine];
		this.resultLine = new boolean[nbLine];
		this.resultCol = new boolean[nbColum];
		
				
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
			LabelPicross LabelTemp = new LabelPicross(true, colSpec.get(col2));
			this.ListCondVert[col2] = LabelTemp;
			this.panel.add(LabelTemp.getPanelLabel(), d);
		}
		
	//debug
//		this.matrice[0][0].setColor(Color.BLACK);
//		this.matrice[0][1].setColor(Color.BLACK);
//		this.matrice[0][3].setColor(Color.BLACK);
	
	//debug
	}

	public void update(IObservable observable) {
		Box b = (Box) observable;
		b.getColum();
		verifLine(b.getLine());
		verifCol(b.getColum());

	}

	private boolean verifLine(int line) {
		System.out.println(ListCondHorz[line].getCond());
		int result = 1;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
<<<<<<< HEAD
		for (int i = 0 ; i<this.nbLine-1; i++) {
			if(this.matrice[line][i].getStatus() == true) {
				result = 1;
				for (int j = i; j<this.nbColum-i-1; j++) {
						if(this.matrice[line][j+1].getStatus() == true) {
							result ++;
						}
=======
		for (int i = 0; i < this.nbLine; i++) {
			if (this.matrice[line][i].getStatus() == true) {
				for (int j = i + 1; j < this.nbColum; j++) {
					if (this.matrice[line][j].getStatus() == true && this.matrice[line][j - 1].getStatus() == true) {																					
						i = j;
						result++;
					}
					else {
						break;
					}
>>>>>>> pierre
				}
				tabTemp.add(result);
				result = 1;
			}
<<<<<<< HEAD
=======
		}
		if (ListCondHorz[line].getCond().equals(tabTemp)) {
			System.out.println("ligne est validée");
			this.ListCondHorz[line].setBackgroundTrue(Color.GREEN);
			this.resultLine[line] = true;
		}
		else {
			this.ListCondHorz[line].setBackgroundTrue(null);
			this.resultLine[line] = false;
		}
		if (isWin(this.resultLine, this.resultCol) == true) {
			System.out.println("Victoire");
>>>>>>> pierre
		}
		System.out.println(tabTemp);
		return true;
	}

	private boolean verifCol(int Col) {
		int result2 = 1;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
		for (int i = 0; i < this.nbLine; i++) {
			if (this.matrice[i][Col].getStatus() == true) {
				for (int j = i + 1; j < this.nbColum; j++) {
					if (this.matrice[j][Col].getStatus() == true && this.matrice[j - 1][Col].getStatus() == true) {
						i = j;
						result2++;
					} 
					else {
						break;
					}
				}
				tabTemp.add(result2);
				result2 = 1;
			}

		}
		if (ListCondVert[Col].getCond().equals(tabTemp)) {
			System.out.println("col est validée");
			this.ListCondVert[Col].setBackgroundTrue(Color.GREEN);
			this.resultCol[Col] = true;
		}
		else {
			this.ListCondVert[Col].setBackgroundTrue(null);
			this.resultLine[Col] = false;
		}
		if (isWin(this.resultLine, this.resultCol) == true) {
			System.out.println("Victoire");
		}
		return true;
	}

	private boolean isWin(boolean[] resultLine, boolean[] resultCol) {
		for (boolean b : resultLine)
			if (!b)
				return false;
		for (boolean b : resultCol)
			if (!b)
				return false;
		return true;
	}

	public JPanel getPanel() {
		return this.panel;
	}

}