import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelPicross {
<<<<<<< HEAD
	
	public JPanel panelList;
	public boolean orientation;
	public ArrayList<ArrayList<Integer>> listCond;
	public int sizeCond; 
	public JPanel panel;
	
	public LabelPicross(boolean orientation, ArrayList<ArrayList<Integer>> listCond) {
		
	this.orientation=orientation;
	this.listCond=listCond;
	this.panelList = new JPanel();
	this.sizeCond = listCond.size();
	
	panel = CreatePanel(this.orientation, this.listCond);
	
		
	}
	
	private JPanel CreatePanel(boolean orientation, ArrayList<ArrayList<Integer>> listCond) {
		
		if(orientation==true) // Horizontal
		{
		this.panelList.setLayout(new BoxLayout(this.panelList, BoxLayout.X_AXIS));
		for(ArrayList<Integer> numero : listCond)
		{
			JPanel panel = new JPanel();
			BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // top to bottom 	
		    panel.setLayout(boxLayout);
		    for(int nombre : numero)
			{
				String str = Integer.toString(nombre);
				panel.add(new JLabel(str+ "  "));
			}
			panelList.add(panel);
		}
		
		return panelList;	
		}
		else
		{
		this.panelList.setLayout(new BoxLayout(this.panelList, BoxLayout.Y_AXIS));
		for(ArrayList<Integer> numero : listCond)
			{
			JPanel panel = new JPanel();
			BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS); // top to bottom 	
		    panel.setLayout(boxLayout);
		    for(int nombre : numero)
				{
				String str = Integer.toString(nombre);
				panel.add(new JLabel(str+ " "));
				}
				panelList.add(panel);
			}	
		}
		return panelList;	
	}
		

	
	
	
	public JPanel getPanel() {
		return this.panel;
	}
			
	}

	

=======

	public JPanel panelList;
	public boolean orientation;
	public JPanel ListCondHorz[];
	public JPanel ListCondVert[];

	public ArrayList<ArrayList<Integer>> listCond;
	public int sizeCond;
	public JPanel panel;

	public LabelPicross(boolean orientation, ArrayList<ArrayList<Integer>> listCond) {

		this.orientation = orientation;
		this.listCond = listCond;
		this.panelList = new JPanel();
		this.sizeCond = listCond.size();

		panel = CreatePanel(this.orientation, this.listCond);

	}

	private JPanel CreatePanel(boolean orientation, ArrayList<ArrayList<Integer>> listCond) {
		int i = 0;
		this.ListCondHorz = new JPanel[listCond.size()];
		this.ListCondVert = new JPanel[listCond.size()];
		if (orientation == true) // Horizontal
		{
			this.panelList.setLayout(new BoxLayout(this.panelList, BoxLayout.X_AXIS));

			for (ArrayList<Integer> numero : listCond) {
				this.panel = new JPanel();
				BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // top to bottom
				panel.setLayout(boxLayout);
				for (int nombre : numero) {
					String str = Integer.toString(nombre);
					panel.add(new JLabel(str + "  "));
					
					
				}
				panelList.add(panel);
				ListCondHorz[i] = panel;
				i++;
			}

			return panelList;
		} else {
			this.panelList.setLayout(new BoxLayout(this.panelList, BoxLayout.Y_AXIS));
			for (ArrayList<Integer> numero : listCond) {
				JPanel panel = new JPanel();
				BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS); // top to bottom
				panel.setLayout(boxLayout);
				for (int nombre : numero) {
					String str = Integer.toString(nombre);
					JLabel jlabel = new JLabel(str + " ");
					panel.add(jlabel);
					//ListCondVert.add(new JLabel(str + " "));
					
					
				}
				panelList.add(panel);
				ListCondVert[i] = panel;
				i++;
			}
		}
		return panelList;
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public JPanel getLabel(boolean orientation, int index) {
		JPanel labelReturn;
		if (orientation == true) {
			labelReturn =  ListCondHorz[index];
		} else {
			labelReturn = ListCondVert[index];
		}
		return labelReturn;
		
	}
}
>>>>>>> origin/master
