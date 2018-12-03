import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import java.util.Iterator;

public class LayoutFactory implements IObserver2 {

	static ArrayList<ArrayList<Integer>> tabVerifRow;
	static ArrayList<ArrayList<Integer>> tabVerifCol;
	static JFrame frame;

	public LayoutFactory(String args) throws FileNotFoundException, IOException, ParseException {

		Layout layoutPanel = create(args);
		layoutPanel.addObserver2((IObserver2) this);
		JPanel panel = layoutPanel.getPanel();
		frame = new JFrame("Picross");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 800);
		frame.setLocationRelativeTo(null); // la fenêtre est centrée à l'écran
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);

	}

	public static  JSONObject readJsonFile(String url) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(url));
		return (JSONObject) obj;
	}

	public static Layout create(String url) throws FileNotFoundException, IOException, ParseException {
		JSONObject jsonObject1 = readJsonFile(url);
		JSONArray col = (JSONArray) jsonObject1.get("col");
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

		JSONArray row = (JSONArray) jsonObject1.get("row");
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
		return new Layout(tabVerifRow, tabVerifCol);
	}
	
	public void updateWin(IObservable2 obseervable) {
		// frame victory 
		//Layout L = (Layout) observable;
		getEcranVictoire(frame);
	}
	
	public void getEcranVictoire(JFrame f) {
		final JPanel glass = (JPanel) f.getGlassPane();
		System.out.println(glass);
		glass.setVisible(true);
		glass.setLayout(new GridBagLayout());
		JLabel victoire = new JLabel("Victoire !");
		Color color = new Color(0, 255, 0);
		victoire.setForeground(color);
		victoire.setFont(new Font("Roboto", Font.PLAIN, 38));
		glass.setOpaque(true);
		glass.add(victoire);
	}
}
