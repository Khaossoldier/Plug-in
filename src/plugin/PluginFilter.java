package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter{

	public boolean accept(File dir, String name) {
		Class<?> c = null;
		Object instance = null;
		//dir exist ?
		if(!dir.exists()){
			/* pas normal */
			System.out.print("Le docier n'existe pas");
			return false;
		}
		//endswith
		if(!name.endsWith(".class")){
			
		}
		try{
		// avoir la class
		c = Class.forName("plugins." + name.substring(0,name.length() - 6));
		}
		catch(Exception e){
			return false;
		}
		return true;
		
	}

}
