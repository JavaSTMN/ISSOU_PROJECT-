import javax.swing.*;
import java.awt.*;


class test_of_myClass {
	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(4,4,4,4));	
		box button1 = new box(40,40);
		button1.change_color();
		box button2 = new box(40,40);
		panel.add(button1.getButton());	
		panel.add(button2.getButton());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		System.out.println(button2.getStatus());
	}
}


