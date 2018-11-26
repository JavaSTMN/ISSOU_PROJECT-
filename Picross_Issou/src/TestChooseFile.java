import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.json.simple.parser.ParseException;


import java.awt.event.*;  
import javax.swing.*;   

public class TestChooseFile {
	static JFrame frame;

	
	public static void main(String[] args) throws FileNotFoundException, IOException  {

		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
/*
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}*/
		   JFrame f = new JFrame();
		      f.setTitle("le titre");
		      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      f.setSize(300, 300);
		      f.setLocationRelativeTo(null); // la fenêtre est centrée à l'écran
		      f.setLayout(new FlowLayout());
		      
		      JButton b=new JButton("Click Here");  		 
		      b.setPreferredSize(new Dimension(100, 100));
		   
		   
		      b.addActionListener(new ActionListener(){  
		    	  public void actionPerformed(ActionEvent e){  
		    		  	jfc.showOpenDialog(null);
		    	          }  
		    	      });  
		      
		      
		      f.add(b);
		    //  f.pack();
		      f.setVisible(true);
	}
}
