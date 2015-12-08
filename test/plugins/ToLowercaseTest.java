package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToLowercaseTest {

	@Test
	public void testToLowercase() {
		Plugin p = new ToLowercase();
		assertNotNull(p);
	}

	@Test
	public void testTransform() {
		Plugin p = new ToLowercase();
		String s = "SALUT";
		s = p.transform(s);
		assertEquals("salut", s);
	}

	@Test
	public void testGetLabel() {
		Plugin p = new ToLowercase();
		assertEquals("To Lowercase", p.getLabel());
	}

}
