package essai;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class FirstTimer {
	
	public static void main(String args[]){
		int delay = 100;
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(java.util.Calendar.getInstance().getTime());
			}	
		};
		Timer t = new Timer(delay, taskPerformer);
		t.start();
		while(true);
	}
	
}
