import javax.swing.*;
import java.awt.*;


class test_of_myClass {
	static int taille;
	public static void main(String[] args) {
		taille = 20;	
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Box button1 = new Box(taille,taille);
		button1.change_color();
		Box button2 = new Box(taille,taille);
		panel.add(button1.getButton());	
		panel.add(button2.getButton());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		System.out.println(button2.getStatus());
	}
}
