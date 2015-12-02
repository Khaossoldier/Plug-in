package plugins;

public class ToLowercase implements Plugin {
	
	private String label; 
	
	public ToLowercase(){
		this.label = "To Lowercase";
	}
	
	@Override
	public String Transform(String s) {
		s.toLowerCase();
		return s;
	}

	@Override
	public String getLabel() {
		return this.label;
	}
	
	
	
}
