 package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.Timer;

public class PluginFinder {
	
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;
	
	public PluginFinder(String dirPath){
		this.filter = new PluginFilter();
		this.dir = new File(dirPath);
		this.timer = new Timer(1000, new MyActionListener());
	}
	
	public void startTimer(){
		this.timer.start();
		while(true);
	}
	
	public List<String> getFiles(){
		return this.files;
	}
	
	private class MyActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String[] t = PluginFinder.this.dir.list(PluginFinder.this.filter);
			List<String> change = Arrays.asList(t);
			if (change.size() < PluginFinder.this.files.size()) {
				//PluginFinder.this.addPlugin(change);
			} else if (change.size() > PluginFinder.this.files.size()) {
				//PluginFinder.this.removePlugin(change);
			}
			
			PluginFinder.this.files = change;
			
		}
	}
	
}
