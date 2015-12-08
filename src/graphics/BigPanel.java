package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.lang.reflect.Constructor;

import javax.swing.*;

import plugin.PluginFinder;
import plugins.Plugin;

/**
 * @author Delassus Alexandre
 * @author Duflos Nicolas
 * Define the BigPanel and the main function.
 * The Big Panel is the default panel.
 */
public class BigPanel {
	
	private JMenuBar bar;
	private JMenu menu;
	private JTextArea text;
	
	/**
	 * Constructor of BigPanel.
	 */
	public BigPanel(){
		JFrame f = new JFrame("Welcome To The Big Panel");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(100,200);
		f.setSize(640, 480);
		
		f.setLayout(new BorderLayout());
		
		bar  = new JMenuBar();
		menu = new JMenu("Tools");
		bar.add(menu);
		bar.setPreferredSize(new Dimension(640, 20));
		
		f.add(bar, BorderLayout.NORTH);
		text = new JTextArea(); 
		f.add(text, BorderLayout.SOUTH);
		text.setPreferredSize(new Dimension(640,460));
		
		f.pack();
		f.setVisible(true);
		
	}
	
	
	/**
	 * @param args the command line.
	 * Main function, create the BigPanel, the PluginFinder and start the timer.
	 */
	public static void main(String[] args){
		BigPanel b = new BigPanel();
		PluginFinder finder = new PluginFinder("./bin/plugins", b);
		finder.startTimer();
	}
	
	/**
	 * @param s the name of the plugin.
	 * Add the JMenuItem to the tool bar.
	 */
	public void addJMenuItem(String s){
		
		try{
			Class<?> classe = Class.forName("plugins." + s);
			Constructor<?> cons = classe.getConstructor();
			Plugin p = (Plugin) cons.newInstance();
			JMenuItem item = new JMenuItem(p.getLabel());
			MyMouseListener mouse = new MyMouseListener(s);
			item.addMouseListener(mouse);
			this.menu.add(item);
			}
			catch(Exception e){
				System.out.println("Ca marche pas !");
			}
	}
	
	/**
	 * @param s the name of the plugin.
	 * Remove the JMenuItem from the tool bar.
	 */
	public void removeJMenuItem(String s){
		for(int i=0; i < this.menu.getItemCount(); i++){
			try{
				Class<?> classe = Class.forName("plugins." + s);
				Constructor<?> cons = classe.getConstructor();
				Plugin p = (Plugin) cons.newInstance();
				if (this.menu.getItem(i).getText().equals(p.getLabel())){
					this.menu.remove(i);
				}
				}
				catch(Exception e){
					System.out.println("Ca marche pas !");
				}
			
		}
	}
	
	
	/**
	 *	Define the Close Event.
	 */
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
	/**
	 *	Define the Mouse Listener
	 */
	private class MyMouseListener implements MouseListener{
		
		private String s;
		
		/**
		 * @param s the name of the plugin.
		 * Constructor of MyMouseListener.
		 */
		public MyMouseListener(String s){
			this.s = s;
		}
		
		public void mouseClicked(MouseEvent arg0) {
			
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		
		public void mouseExited(MouseEvent arg0) {
		}
		
		/** 
		 * Define the Event when the mouse click on the item.
		 * Change the text in the TextArea with the transform of the plugin.
		 */
		public void mousePressed(MouseEvent arg0) {
			try{
				Class<?> classe = Class.forName("plugins." + s);
				Constructor<?> cons = classe.getConstructor();
				Plugin p = (Plugin) cons.newInstance();
				BigPanel.this.text.setText(p.transform(BigPanel.this.text.getText()));
				}
				catch(Exception e){
					System.out.println("Ca marche pas !");
				}
		}

		public void mouseReleased(MouseEvent arg0) {
		}
		
	}
	
}
