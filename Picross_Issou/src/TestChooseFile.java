import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import org.json.simple.parser.ParseException;
import java.awt.event.*;
import javax.swing.*;

public class TestChooseFile {
	static JFrame frame;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		/*
		 * int returnValue = jfc.showOpenDialog(null); // int returnValue =
		 * jfc.showSaveDialog(null);
		 * 
		 * if (returnValue == JFileChooser.APPROVE_OPTION) { File selectedFile =
		 * jfc.getSelectedFile(); System.out.println(selectedFile.getAbsolutePath()); }
		 */
		JFrame f = new JFrame();
		f.setTitle("Picross Issou");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setLocationRelativeTo(null); // la fenêtre est centrée à l'écran
		f.setLayout(new FlowLayout());

		chrono(f);

		JButton b = new JButton("Nouvelle partie");
		b.setPreferredSize(new Dimension(200, 100));

		JButton bquit = new JButton("Quitter");
		bquit.setPreferredSize(new Dimension(200, 100));

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc.showOpenDialog(null);
				File file = jfc.getSelectedFile();

				try {
					LayoutFactory.main(file.getName());
					f.dispose();
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		bquit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEcranVictoire(f);
				// System.exit(0);
			}
		});

		f.add(b);
		f.add(bquit);
		// f.pack();
		f.setVisible(true);
	}

	public static void getEcranVictoire(JFrame f) {

		final JPanel glass = (JPanel) f.getGlassPane();
		System.out.println(glass);
		glass.setVisible(true);
		glass.setLayout(new GridBagLayout());
		JLabel victoire = new JLabel("Victoire!");
		Color color = new Color(0, 255, 0);
		victoire.setForeground(color);
		victoire.setFont(new Font("Roboto", Font.PLAIN, 38));
		glass.setOpaque(true);
		glass.add(victoire);
	}

	public static void chrono(JFrame f) {

		Timer timer1;
		int delais = 1000;
		ActionListener tache_timer;

		JLabel label = new JLabel("0:0:0");
		f.getContentPane().add(label);
		tache_timer = new ActionListener() {

			int heure = 0;
			int minute = 0;
			int seconde = 0;

			public void actionPerformed(ActionEvent e1) {
				seconde++;
				if (seconde == 60) {
					seconde = 0;
					minute++;
				}
				if (minute == 60) {
					minute = 0;
					heure++;
				}
				// Afficher le chrono dans un JLabel
				label.setText(heure + ":" + minute + ":" + seconde);

			}
		};
		timer1 = new Timer(delais, tache_timer);
		// Demarrer le chrono
		timer1.start();
	}

}
