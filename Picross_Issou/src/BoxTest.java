import java.awt.Component;
import java.awt.peer.LabelPeer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

<<<<<<< HEAD




public class BoxTest extends LabelPicross {
	
	
	static ArrayList<ArrayList<Integer>> tabVerifRow;
	static ArrayList<ArrayList<Integer>> tabVerifCol;
	
	
	static JFrame frame;
	static JPanel panel;
	static JPanel panel1;
	static int colSpec[][] = {{1,2},{3},{4,1,2}};
	int lineSpec[][] = {{1,2},{2,3}};
	

  public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame = new JFrame("BoxLayout Test");
    
    panel = new JPanel();
    panel1 = new JPanel();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //LabelVertical(panel);
    //LabelHorizontal(panel1);
    
    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    
    
    
    
    
    
    
    
    
 
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(new FileReader("src/exemple.json"));


	   JSONArray col = (JSONArray) ((JSONObject) obj).get("col");	       	       
       Iterator<JSONArray> cols = col.iterator();
      
       
       tabVerifRow =new ArrayList<ArrayList<Integer>>();
       while (cols.hasNext()) {	            	
       	 JSONArray colTab = cols.next();
       	int sizeCols = colTab.size() ;
       	ArrayList<Integer> tempCol = new ArrayList<Integer>();           	   
       	for(int x =0; x < sizeCols; x++) {
       		Long lcount = (Long) colTab.get(x);
   			int count = lcount.intValue();
   			tempCol.add(count);	            		
       	}
       	
       	tabVerifRow.add(tempCol);
       }
    
      
    
       JSONArray row = (JSONArray)((JSONObject) obj).get("row");	       	       
       Iterator<JSONArray> rows = row.iterator();
       
       
       tabVerifCol =new ArrayList<ArrayList<Integer>>();

       while (rows.hasNext()) {	            	
       	 JSONArray rowTab = rows.next();
       	int sizeRow = rowTab.size() ;
       	ArrayList<Integer> tempRow = new ArrayList<Integer>();           	   
       	for(int x =0; x < sizeRow; x++) {
       		Long lcount = (Long) rowTab.get(x);
   			int count = lcount.intValue();
   			tempRow.add(count);	            		
       	}
       	
       	tabVerifCol.add(tempRow);
       }
    
    
    
    
    
    
    
    
    
    
    
    
    LabelPicross panelList = new LabelPicross(false,tabVerifCol);
  /*  panelList.setLayout(new BoxLayoutLpanelList, BoxLayout.X_AXIS));
    panelList.add(panel);
    panelList.add(panel1);*/
    
    
    JPanel panelIssou = panelList.getPanel();
    
   frame.add(panelIssou);
 
    
    frame.pack();

    frame.setVisible(true);
  }
	
	
  
  
  
  /*public static void LabelVertical(JPanel panel) {
	    panel.add(new JLabel("1"));
	    panel.add(new JLabel("1"));
	    panel.add(new JLabel("1"));
	 	BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // top to bottom 	
	    panel.setLayout(boxLayout);
	    

	    
  }
 
 public static void LabelHorizontal(JPanel panel) {
	    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	    panel.add(new JLabel("2"));
	    panel.add(new JLabel("2"));
	    panel.add(new JLabel("2"));
	    panel.setLayout(boxLayout);
	 
 } */
 
=======
public class BoxTest extends LabelPicross {

	public BoxTest(boolean orientation, ArrayList<ArrayList<Integer>> listCond) {
		super(orientation, listCond);
		// TODO Auto-generated constructor stub
	}

	static ArrayList<ArrayList<Integer>> tabVerifRow;
	static ArrayList<ArrayList<Integer>> tabVerifCol;

	static JFrame frame;
	static JPanel panel;
	static JPanel panel1;
	static int colSpec[][] = { { 1, 2 }, { 3 }, { 4, 1, 2 } };
	int lineSpec[][] = { { 1, 2 }, { 2, 3 } };

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("BoxLayout Test");

		panel = new JPanel();
		panel1 = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// LabelVertical(panel);
		// LabelHorizontal(panel1);

		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("src/exemple.json"));

		JSONArray col = (JSONArray) ((JSONObject) obj).get("col");
		Iterator<JSONArray> cols = col.iterator();

		tabVerifRow = new ArrayList<ArrayList<Integer>>();
		while (cols.hasNext()) {
			JSONArray colTab = cols.next();
			int sizeCols = colTab.size();
			ArrayList<Integer> tempCol = new ArrayList<Integer>();
			for (int x = 0; x < sizeCols; x++) {
				Long lcount = (Long) colTab.get(x);
				int count = lcount.intValue();
				tempCol.add(count);
			}

			tabVerifRow.add(tempCol);
		}

		JSONArray row = (JSONArray) ((JSONObject) obj).get("row");
		Iterator<JSONArray> rows = row.iterator();

		tabVerifCol = new ArrayList<ArrayList<Integer>>();

		while (rows.hasNext()) {
			JSONArray rowTab = rows.next();
			int sizeRow = rowTab.size();
			ArrayList<Integer> tempRow = new ArrayList<Integer>();
			for (int x = 0; x < sizeRow; x++) {
				Long lcount = (Long) rowTab.get(x);
				int count = lcount.intValue();
				tempRow.add(count);
			}

			tabVerifCol.add(tempRow);
		}

		LabelPicross panelList = new LabelPicross(false, tabVerifCol);
		/*
		 * panelList.setLayout(new BoxLayoutLpanelList, BoxLayout.X_AXIS));
		 * panelList.add(panel); panelList.add(panel1);
		 */

		JPanel panelIssou = panelList.getPanel();

		frame.add(panelIssou);

		frame.pack();

		frame.setVisible(true);
	}

	/*
	 * public static void LabelVertical(JPanel panel) { panel.add(new JLabel("1"));
	 * panel.add(new JLabel("1")); panel.add(new JLabel("1")); BoxLayout boxLayout =
	 * new BoxLayout(panel, BoxLayout.Y_AXIS); // top to bottom
	 * panel.setLayout(boxLayout);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * public static void LabelHorizontal(JPanel panel) { BoxLayout boxLayout = new
	 * BoxLayout(panel, BoxLayout.Y_AXIS); panel.add(new JLabel("2")); panel.add(new
	 * JLabel("2")); panel.add(new JLabel("2")); panel.setLayout(boxLayout);
	 * 
	 * }
	 */

>>>>>>> origin/master
}