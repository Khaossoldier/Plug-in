package plugins;

/**
 * @author Delassus Alexandre
 * @author Duflos Nicolas
 *	Define the ToLowercase Plugin
 */
public class ToLowercase implements Plugin {
	
	private String label; 
	
	/**
	 * Constructor of ToLowercase
	 */
	public ToLowercase(){
		this.label = "To Lowercase";
	}
	
	/**
	 * @param s the string to transform
	 * @return the transformed string
	 * Tranform a string in lowercase
	 */
	@Override
	public String transform(String s) {
		String t = s.toLowerCase();
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
