package plugins;

/**
 * @author Delassus Alexandre
 * @author Duflos Nicolas
 *	Define the Plugin interface
 */
public interface Plugin {
	/**
	 * @param s the string to transform
	 * @return the transformed string
	 * Tranform a string
	 */
	public String transform(String s);
	
	/**
	 * @return a label
	 * Getter of the label of the plugin
	 */
	public String getLabel();
}
