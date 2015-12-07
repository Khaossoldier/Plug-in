package plugin;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter{

	public boolean accept(File dir, String name) {
		Class<?> c = null;
		boolean test = false;
		//dir exist ?
		if(!dir.exists()){
			/* pas normal */
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
		test = c.getConstructor().getTypeParameters().length == 0;
		}
		catch(Exception e){
			return false;
		}
		return Plugin.class.isAssignableFrom(c) && test;
		
	}

}
