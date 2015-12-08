package plugin;

import static org.junit.Assert.*;

import org.junit.Test;

import graphics.BigPanel;

public class PluginFinderTest {

	@Test
	public void testPluginFinder() {
		BigPanel b = new BigPanel();
		PluginFinder finder = new PluginFinder("C:\\Users\\nicol\\Programmation\\COO\\Plug-in\\bin\\plugins", b);
		assertNotNull(finder);
	}

	@Test
	public void testStartTimer() {
		BigPanel b = new BigPanel();
		PluginFinder finder = new PluginFinder("C:\\Users\\nicol\\Programmation\\COO\\Plug-in\\bin\\plugins", b);
		finder.startTimer();
	}

}
