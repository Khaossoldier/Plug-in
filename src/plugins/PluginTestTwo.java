package plugins;

public class PluginTestTwo {
	
private String label; 
	
	public PluginTestTwo(){
		this.label = "To Lowercase";
	}
	
	public String transform(String s) {
		String t = s.toLowerCase();
		return t;
	}

	public String getLabel() {
		return this.label;
	}
}
