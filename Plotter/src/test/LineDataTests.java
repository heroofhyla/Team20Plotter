package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LineData;

public class LineDataTests {
	LineData data;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		data = new LineData();
		data.addIndex(3);
		data.addIndex(4);
		data.addIndex(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIndex() {
		assertEquals(4, data.getIndex(1));
	}
	
	@Test
	public void testToString(){
		assertEquals("3,4,5", data.toString());
	}
	
	@Test
	public void testEmptyToString(){
		data = new LineData();
		assertEquals("", data.toString());
	}
	
	@Test
	public void testClone(){
		LineData data2 = data.clone();
		for (int i = 0; i < data.size(); i++){
			assertEquals(data.getIndex(i), data2.getIndex(i));
		}
		assertNotSame(data, data2);
	}
	
	@Test
	public void testPositionOfFirst(){
		assertEquals(0, data.positionOf(3));
	}
	
	@Test
	public void testPositionOfMid(){
		assertEquals(1, data.positionOf(4));
	}
	
	@Test
	public void testPositionOfLiast(){
		assertEquals(2, data.positionOf(5));
	}
	
	@Test
	public void testPositionOfNonexistent(){
		assertEquals(-1, data.positionOf(7));
	}
	
	@Test
	public void testAddIndex(){
		data.addIndex(2);
		assertEquals(2, data.getIndex(3));
	}

}
