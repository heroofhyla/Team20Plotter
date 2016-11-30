package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.main.Colorpanel;

public class ColorPanelTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDecompose() {
		String decompose = Colorpanel.decomposeColor(Color.RED);
		assertEquals("255,0,0",decompose);
	}
	
	@Test
	public void testBuildColor(){
		Color color = Colorpanel.buildColor("0,255,255");
		assertEquals(Color.CYAN, color);
	}

}
