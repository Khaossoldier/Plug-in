package plugins;

public class ToUppercase implements Plugin {
	
	private String label; 
	
	public ToUppercase(){
		this.label = "To Uppercase";
	}
	
	@Override
	public String transform(String s) {
		String t = s.toUpperCase();
		return t;
	}

	@Override
	public String getLabel() {
		return this.label;
	}
	
	
	
}
