package graphics;

import java.awt.event.WindowAdapter;

import javax.swing.*;

public class BigPanel {
	
	
	public void creationOfTheBigPannel(){
		JFrame f = new JFrame("The Binding Of Isaac : Afterbirth");
		f.addWindowListener(new FermeWindowEvent());
		f.setLocation(100,200);
	}
	
	
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
}
