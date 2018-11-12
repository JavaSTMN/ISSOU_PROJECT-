import javax.swing.*;
import java.awt.*;


class test_of_myClass {
	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(4,4,4,4));	
		Box button1 = new Box(10,10);
		button1.changeColor();
		Box button2 = new Box(10,10);
		panel.add(button1.getButton());	
		panel.add(button2.getButton());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		System.out.println(button2.getStatus());
	}
}


