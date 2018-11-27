import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Layout implements IObserver  {

	private JPanel panel;
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
		verifLine(b.getLine());
		//verifCol(b.getColum());
		
	}

	private boolean verifLine(int line) {
		System.out.println(ListCondHorz[line].getCond());
		int result = 0;
		ArrayList<Integer> tabTemp = new ArrayList<Integer>();
		for (int i = 0 ; i<this.nbLine-1; i++) {
			if(this.matrice[line][i].getStatus() == true) {
				result = 1;
				for (int j = i; j<this.nbColum-i-1; j++) {
						if(this.matrice[line][j+1].getStatus() == true) {
							result ++;
						}
				}
				tabTemp.add(result);
			}
		}
		System.out.println(tabTemp);
		return true;
	}

	private boolean verifCol(int Col) {
		System.out.println(ListCondHorz[Col].getCond());
		return true;
	}

	public JPanel getPanel() {
		return this.panel;
	}

}