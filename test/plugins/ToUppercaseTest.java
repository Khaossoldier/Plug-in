package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToUppercaseTest {

	@Test
	public void testToUppercase() {
		Plugin p = new ToUppercase();
		assertNotNull(p);
	}

	@Test
	public void testTransform() {
		Plugin p = new ToUppercase();
		String s = "salut";
		s = p.transform(s);
		assertEquals("SALUT", s);
	}

	@Test
	public void testGetLabel() {
		Plugin p = new ToUppercase();
		assertEquals("To Uppercase", p.getLabel());
	}

}
