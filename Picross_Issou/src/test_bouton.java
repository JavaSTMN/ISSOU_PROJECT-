import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class test_bouton {

   public static void main(String[] args) {
		JFrame f = new JFrame("Formulaire");
		JLayeredPane l = new JLayeredPane(); 
		l.setPreferredSize(new Dimension(150,150));
		JPanel pi = new JPanel() {
			public void paint(Graphics g) {
				try {
					URL ImageWB = new URL("http://upload.wikimedia.org/wikipedia/commons/6/64/Wikibooks-logo-fr.png");
					BufferedImage image1 = ImageIO.read(ImageWB);
					g.drawImage(image1, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		pi.setBounds(10,10,150,150);	// Fenêtre 150*150 placée à aux coordonnées 10,10 
		l.add(pi,new Integer(0));	// Déposée sur la couche zéro
		
		JPanel pb = new JPanel();
		JButton b1 = new JButton();
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clic bouton 1");
			}
		});
		pb.add(b1);
		JButton b2 = new JButton("Bouton 2");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clic bouton 2");
			}
		});		
		pb.add(b2);
		pb.setBounds(30,30,100,60);
		l.add(pb,new Integer(1));
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);	// Ou show(); deprecated
   }
}