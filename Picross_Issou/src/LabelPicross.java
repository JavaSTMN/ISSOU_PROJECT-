import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelPicross {

	public JPanel panelList;
	public boolean orientation;
	public JPanel ListCondHorz[];
	public JPanel ListCondVert[];
	public ArrayList<ArrayList<Integer>> listCond;
	public int sizeCond;
	public JPanel panel;
	public Color color;
	public ArrayList<Integer> spec;

	public  LabelPicross(boolean orientation, ArrayList<Integer> spec) {
		this.orientation = orientation;
		this.color = Color.black;
		this.panel = new JPanel();
		this.spec = spec;
		//setColor(this.color);
		if (orientation == true) // Horizontal
		{
			BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // top to bottom
			this.panel.setLayout(boxLayout);
			for (int nombre : spec) {
				String str = Integer.toString(nombre);
				this.panel.add(new JLabel(str + "  "));
			}
		} else {
			BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS); // top to bottom
			this.panel.setLayout(boxLayout);
			for (int nombre : spec) {
				String str = Integer.toString(nombre);
				JLabel jlabel = new JLabel(str + " ");
				this.panel.add(jlabel);
			}
		}
		
	}

	public JPanel getPanelLabel() {
		return this.panel;
	}
	
	public void setBackgroundTrue(Color colortoset) {
		this.panel.setBackground(colortoset);
	}

	public ArrayList<Integer> getCond() {
		return this.spec;
	}
	
}
