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
		this.timer.start();
	}
	
	private class MyActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String[] t = PluginFinder.this.dir.list(PluginFinder.this.filter);
			PluginFinder.this.files = Arrays.asList(t);
			
		}
	}
	
}
