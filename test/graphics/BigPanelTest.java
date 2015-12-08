package graphics;

import static org.junit.Assert.*;

import org.junit.Test;

public class BigPanelTest {

	@Test
	public void testBigPanel() {
		BigPanel b = new BigPanel();
		assertNotNull(b);
	}
	
	public void testAddAndRemoveJMenuItem() throws InterruptedException{
		BigPanel b = new BigPanel();
		String s = "New Item";
		b.addJMenuItem(s);
		b.removeJMenuItem(s);
	}

}
