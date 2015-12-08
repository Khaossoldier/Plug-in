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

public class BigPanel {
	
	private JMenuBar bar;
	private JMenu menu;
	private JTextArea text;
	
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
	
	
	public static void main(String[] args){
		BigPanel b = new BigPanel();
		PluginFinder finder = new PluginFinder("C:\\Users\\nicol\\Programmation\\COO\\Plug-in\\bin\\plugins", b);
		finder.startTimer();
	}
	
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
	
	public void removeJMenuItem(String s){
		for(int i=0; i < this.menu.getItemCount(); i++){
			if (this.menu.getItem(i).getComponent().getName().equals(s)){
				this.menu.remove(i);
			}
		}
	}
	
	
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
	private class MyMouseListener implements MouseListener{
		
		private String s;
		
		public MyMouseListener(String s){
			this.s = s;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
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

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
		
	}
	
}
