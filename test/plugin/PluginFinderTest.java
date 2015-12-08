package plugin;

import static org.junit.Assert.*;

import org.junit.Test;

import graphics.BigPanel;

public class PluginFinderTest {

	@Test
	public void testPluginFinder() {
		BigPanel b = new BigPanel();
		PluginFinder finder = new PluginFinder("./bin/plugins", b);
		assertNotNull(finder);
	}

}
