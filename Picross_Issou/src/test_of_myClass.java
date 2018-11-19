import javax.swing.*;
import java.awt.*;

class test_of_myClass {
	public static void main(String[] args) {

		int colSpec[][] = { { 1, 2 }, { 3 }, { 4, 1, 2 } };

		int lineSpec[][] = { { 1, 2 }, { 2, 3 } };

		Layout picross = new Layout(lineSpec, colSpec);

	}
}
