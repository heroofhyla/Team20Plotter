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
	
	@Test
	public void testInvertY(){
		int[] x = {2,0,0};
		int[] y = {0,2,0};
		int[] z = {0, 0, 0};
		poly = new Polygon3D(3,x,y,z);
		
		poly.invertY(0);
		
		assertEquals(-2, poly.ypoints[1]);
	}
	
	@Test
	public void testFindCentroid(){
		int[] x = {2,0,0};
		int[] y = {0,2,0};
		int[] z = {0, 0, 0};
		poly = new Polygon3D(3,x,y,z);
		
		Point3D point = Polygon3D.findCentroid(poly);
		
		assertEquals(2.0/3, point.x, 0.001);
		assertEquals(2.0/3, point.y, 0.001);
		assertEquals(0, point.z, 0.001);
	}
	
	@Test
	public void testDivideIntoTriangles(){
		int[] x = {0,1,1,0};
		int[] y = {0,0,1,1};
		int[] z = {0,0,0,0};
		Point3D[] normals = {new Point3D(), new Point3D(), new Point3D(), new Point3D()};
		poly = new Polygon3D(4,x,y,z, normals);
		
		Polygon3D[] tris = Polygon3D.divideIntoTriangles(poly);
		assertEquals(2, tris.length);
		int[][] xExpected = {{0,1,1},{0,1,0}};
		int[][] yExpected = {{0,0,1},{0,1,1}};
		int[][] zExpected = {{0,0,0},{0,0,0}};
		
		for (int i = 0; i < tris.length; i++){
			for (int k = 0; k < 3; k++){
				assertEquals(xExpected[i][k], tris[i].xpoints[k]);
				assertEquals(yExpected[i][k], tris[i].ypoints[k]);
				assertEquals(zExpected[i][k], tris[i].zpoints[k]);
			}
		}
	}
	
	@Test
	public void testDivideIntoTrianglesWithTwoPoints(){
		int[] x = {0,1};
		int[] y = {1,2};
		int[] z = {0,0};
		
		Point3D[] normals = {new Point3D(), new Point3D()};
		
		poly = new Polygon3D(2,x,y,z,normals);
		
		Polygon3D[] tris = Polygon3D.divideIntoTriangles(poly);
		assertEquals(0, tris.length);
		
	}
	
	@Test
	public void testExtractSubPolygon3D(){
		int[] x = {0,1,1,0};
		int[] y = {0,0,1,1};
		int[] z = {0,0,0,0};
		Point3D[] normals = {new Point3D(), new Point3D(), new Point3D(), new Point3D()};
		poly = new Polygon3D(4,x,y,z, normals);
		
		Polygon3D sub = Polygon3D.extractSubPolygon3D(poly, 3, 1);
		int[] xExpected = {1,1,0};
		int[] yExpected = {0,1,1};
		int[] zExpected = {0,0,0};
		
		for (int i = 0; i < 3; i++){
			assertEquals(xExpected[i], sub.xpoints[i]);
			assertEquals(yExpected[i], sub.ypoints[i]);
			assertEquals(zExpected[i], sub.zpoints[i]);
		}
	}
	@Test
	public void testExtractSubPolygon3DWithDifferentStart(){
		int[] x = {0,1,1,0};
		int[] y = {0,0,1,1};
		int[] z = {0,0,0,0};
		Point3D[] normals = {new Point3D(), new Point3D(), new Point3D(), new Point3D()};
		poly = new Polygon3D(4,x,y,z, normals);
		
		Polygon3D sub = Polygon3D.extractSubPolygon3D(poly, 3, 3);
		int[] xExpected = {0,0,1};
		int[] yExpected = {1,0,0};
		int[] zExpected = {0,0,0};
		
		for (int i = 0; i < 3; i++){
			assertEquals(xExpected[i], sub.xpoints[i]);
			assertEquals(yExpected[i], sub.ypoints[i]);
			assertEquals(zExpected[i], sub.zpoints[i]);
		}
	}
}
