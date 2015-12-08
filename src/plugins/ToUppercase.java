package plugins;

/**
 * @author Delassus Alexandre
 * @author Duflos Nicolas
 *	Define the ToUppercase Plugin
 */
public class ToUppercase implements Plugin {
	
	private String label; 
	
	/**
	 * Constructor of ToUppercase
	 */
	public ToUppercase(){
		this.label = "To Uppercase";
	}
	
	/**
	 * @param s the string to transform
	 * @return the transformed string
	 * Tranform a string in uppercase
	 */
	@Override
	public String transform(String s) {
		String t = s.toUpperCase();
		return t;
	}
	
	/**
	 * @return a label
	 * Getter of the label of the plugin
	 */
	@Override
	public String getLabel() {
		return this.label;
	}
	
	
	
}
