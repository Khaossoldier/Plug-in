package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;

import javax.swing.*;

import editor.listener.PluginActionListener;

import plugin.PluginFinder;
import plugins.Plugin;

public class BigPanel {
	
	
	public void creationOfTheBigPannel(PluginFinder finder){
		JFrame f = new JFrame("Welcome To The Big Panel");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(100,200);
		f.setSize(640, 480);
		
		f.setLayout(new BorderLayout());
		
		JMenuBar bar  = new JMenuBar();
		JMenu menu = new JMenu("Tools");
		for(String s: finder.getFiles()){
			
		}
		//JMenuItem lower = new JMenuItem("ToLowercase");
		//lower.addPluginListener(new LowerEvent());
		menu.add(lower);
		bar.add(menu);
		bar.setPreferredSize(new Dimension(640, 20));
		
		f.add(bar, BorderLayout.NORTH);
		JTextArea ta = new JTextArea(); 
		f.add(ta, BorderLayout.SOUTH);
		ta.setPreferredSize(new Dimension(640,460));
		
		f.pack();
		f.setVisible(true);
		
	}
	
	
	public static void main(String[] args){
		BigPanel b = new BigPanel();
		PluginFinder finder = new PluginFinder("dropins/plugins");
		b.creationOfTheBigPannel(finder);
	}
	
	
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
	
}
