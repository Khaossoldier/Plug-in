package plugins;

public class PluginTestOne implements Plugin {
	
	private String label;
	
	public PluginTestOne(String s){
		this.label = s;
	}
	
	@Override
	public String transform(String s) {
		return null;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
