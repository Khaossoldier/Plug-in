package plugins;

public class ToUppercase implements Plugin {
	
	private String label; 
	
	public ToUppercase(){
		this.label = "To Uppercase";
	}
	
	@Override
	public String Transform(String s) {
		s.toUpperCase();
		return s;
	}

	@Override
	public String getLabel() {
		return this.label;
	}
	
	
	
}
