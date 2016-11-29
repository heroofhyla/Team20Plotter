package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Point3D;
import com.Polygon3D;

public class Polygon3DTests {
	Polygon3D poly;
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
	public void testClone(){
		int[] x = {1, 2};
		int[] y = {1, 2};
		int[] z = {1, 2};
		poly = new Polygon3D(2, x, y, z);
		
		Polygon3D poly2 = poly.clone();
		
		for (int i = 0; i < 1; i++){
			assertEquals(poly.xpoints[i], poly2.xpoints[i]);
			assertEquals(poly.ypoints[i], poly2.ypoints[i]);
			assertEquals(poly.zpoints[i], poly2.zpoints[i]);
		}
		
		assertNotSame(poly2, poly);
	}
	
	@Test
	public void testToStringWithZ(){
		int[] x = {1, 2, 3};
		int[] y = {2, 3, 4};
		int[] z = {0, 1, 2};
		poly = new Polygon3D(3, x, y, z);
		assertEquals("1,2,0_2,3,1_3,4,2_",poly.toString());
		//TODO: underscore at end seems bad
	}
	
	@Test
	public void testToStringWithoutZ(){
		int[] x = {4,6,7};
		int[] y = {1,4,9};
		poly = new Polygon3D(3,x,y);
		assertEquals("4,1_6,4_7,9_", poly.toString());
	}
	
	@Test
	public void testIsFacing(){
		int[] x = {2,0,0};
		int[] y = {0,2,0};
		int[] z = {0, 0, 0};
		poly = new Polygon3D(3,x,y,z);
		Point3D point = new Point3D(1,1,1);
		assertTrue(Polygon3D.isFacing(poly, point));
	}
	
	@Test
	public void testIsNotFacing(){
		int[] x = {0,2,0};
		int[] y = {2,0,0};
		int[] z = {0, 0, 0};
		poly = new Polygon3D(3,x,y,z);
		Point3D point = new Point3D(1,1,1);
		assertFalse(Polygon3D.isFacing(poly, point));
	}
	
	@Test
	public void testTranslate(){
		//TODO:It really bothers me that the Polygon3D constructor
		//doesn't make a copy of the input arrays - it just keeps the
		//reference. This breaks encapsulation
		int[] x = {2,0,0};
		int[] xcopy = x.clone();
		int[] y = {0,2,0};
		int[] ycopy = y.clone();
		int[] z = {0, 0, 0};
		int[] zcopy = z.clone();
		poly = new Polygon3D(3,x,y,z);
		
		poly.translate(1,1,1);
		
		for (int i = 0; i < 3; i++){
			assertEquals(xcopy[i]+1, poly.xpoints[i]);
			assertEquals(ycopy[i]+1, poly.ypoints[i]);
			assertEquals(zcopy[i]+1, poly.zpoints[i]);
		}
	}
}
