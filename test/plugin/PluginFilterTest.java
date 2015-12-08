package plugin;

import static org.junit.Assert.*;
import java.io.File;

import org.junit.Test;
public class PluginFilterTest {

	@Test
	public void testAcceptIfDirNotExist() {
		PluginFilter f = new PluginFilter();
		File dir = new File("JeNExistePas");
		assertFalse(f.accept(dir, "name"));
	}
	
	@Test
	public void testAcceptIfNotClass(){
		PluginFilter f = new PluginFilter();
		File dir = new File("./src/plugins");
		assertFalse(f.accept(dir, "ToLowercase.java"));
	}
	
	@Test
	public void testAcceptIfConstructorHaveArguments(){
		PluginFilter f = new PluginFilter();
		File dir = new File("./bin/plugins");
		assertFalse(f.accept(dir, "PluginTestOne.class"));
	}
	
	@Test
	public void testAcceptIfNotImplementing(){
		PluginFilter f = new PluginFilter();
		File dir = new File("./bin/plugins");
		assertFalse(f.accept(dir, "PluginTestTwo.class"));
	}
	
	@Test
	public void testAcceptWithAGoodFile(){
		PluginFilter f = new PluginFilter();
		File dir = new File("./bin/plugins");
		assertTrue(f.accept(dir, "ToLowercase.class"));
	}

}
