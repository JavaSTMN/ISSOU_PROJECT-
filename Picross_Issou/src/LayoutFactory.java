import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import java.util.Iterator;

public class LayoutFactory {

	static ArrayList<ArrayList<Integer>> tabVerifRow;
	static ArrayList<ArrayList<Integer>> tabVerifCol;
	static JFrame frame;

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException  {

		Layout layoutPanel = create("src/exemple.json");
		JPanel panel = layoutPanel.getPanel();
		frame = new JFrame("Picross");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	// "src/exemple.json"
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
}
