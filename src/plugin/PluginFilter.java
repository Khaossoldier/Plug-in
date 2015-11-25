package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if (name.length() > 6){
			if (name.substring(name.length() - 6).equals(".class"))
				return true;
		}
		return false;
	}

}
