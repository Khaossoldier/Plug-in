 package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Timer;

import graphics.BigPanel;

/**
 * @author Delassus Alexandre
 * @author Duflos Nicolas
 * Define the PluginFinder.
 */
public class PluginFinder {
	
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;
	private BigPanel panel;
	
	/**
	 * @param dirPath the path of the dir to check
	 * @param panel the graphic interface
	 */
	public PluginFinder(String dirPath, BigPanel panel){
		this.filter = new PluginFilter();
		this.dir = new File(dirPath);
		this.timer = new Timer(1000, new MyActionListener());
		this.panel = panel;
		this.files = new ArrayList<String>();
	}
	
	/**
	 * Start the timer
	 */
	public void startTimer(){
		this.timer.start();
		while(true);
	}
	
	/**
	 *	Define MyActionListener for the PluginFinder
	 */
	private class MyActionListener implements ActionListener{

		/** 
		 * @param e
		 * Define the action to perform to check if the plugin list changed.
		 */
		public void actionPerformed(ActionEvent e) {
			
			String[] t = PluginFinder.this.dir.list(PluginFinder.this.filter);
			ArrayList<String> change = new ArrayList<String>(Arrays.asList(t));
			for(String s : change){
				if(!PluginFinder.this.files.contains(s)){
					PluginFinder.this.panel.addJMenuItem(s.substring(0,s.length() - 6));
				}
			}
			for(String s : PluginFinder.this.files){
				if(!change.contains(s)){
					PluginFinder.this.panel.removeJMenuItem(s.substring(0,s.length() - 6));
				}
			}
			
			PluginFinder.this.files = change;
			
		}
	}
	
}
