package plugins;

public class ToLowercase implements Plugin {
	
	private String label; 
	
	public ToLowercase(){
		this.label = "To Lowercase";
	}
	
	@Override
	public String transform(String s) {
		String t = s.toLowerCase();
		return t;
	}

	@Override
	public String getLabel() {
		return this.label;
	}
	
	
	
}
