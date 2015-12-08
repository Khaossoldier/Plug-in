package plugin;

import java.io.File;

import java.io.FilenameFilter;

import plugins.Plugin;

/**
 * @author Delassus Alexandre
 * @author Duflos Nicolas
 * Define the PluginFilter.
 */
public class PluginFilter implements FilenameFilter{

	/** 
	 * @param dir the directory to check, name the name of the file to check
	 * Check if the dir exist, if the file is a plugin, if the constructor doesn't get parameter and if it come from the interface Plugin.
	 */
	public boolean accept(File dir, String name) {
		Class<?> c = null;
		@SuppressWarnings("unused")
		Object instance = null;
		//dir exist ?
		if(!dir.exists()){
			System.out.print("Le dossier n'existe pas");
			return false;
		}
		//endswith
		if(!name.endsWith(".class")){
			System.out.print("Le fichier n'est pas un .class");
			return false;
		}
		try{
		// avoir la class
		c = Class.forName("plugins." + name.substring(0,name.length() - 6));
		instance = c.getConstructor().newInstance();
		}
		catch(Exception e){
			return false;
		}
		return Plugin.class.isAssignableFrom(c);
		
	}

}
