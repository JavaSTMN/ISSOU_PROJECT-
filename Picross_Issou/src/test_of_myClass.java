import javax.swing.*;
import java.awt.*;

	class test_of_myClass {
		public static void main(String[] args) {
			//test Box 
			JFrame frame = new JFrame("test");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			JPanel panel = new JPanel(new GridBagLayout());	
			Box button1 = new Box(0,0);
			Box button2 = new Box(1,1);
			panel.add(button1.getButton());	
			panel.add(button2.getButton());
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			System.out.println(button2.getStatus());
			
			
			// test layout 
			//int colSpec[][] = { { 1, 2 }, { 3 }, { 4, 1, 2 } };
			//int lineSpec[][] = { { 1, 2 }, { 2, 3 } };

			//Layout picross = new Layout(lineSpec, colSpec);
			
			
		}
	}

