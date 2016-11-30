package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LineData;
import com.Point3D;

public class Point3DTests {
	
	Point3D pointA, pointB;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		pointA = new Point3D(3,4,5);
		pointA.texture_x = 1;
		pointA.texture_y = 1;
		pointA.normal = new Point3D(6,7,8);
		pointA.p_x = 6;
		pointA.p_y = 7;
		pointA.p_z = 8;
		
		
		pointB = new Point3D(6,7,8);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testClone(){
		Point3D point2 = pointA.clone();
		
		assertEquals(pointA.x, point2.x, 0.001);
		assertEquals(pointA.y, point2.y, 0.001);
		assertEquals(pointA.z, point2.z, 0.001);
		assertEquals(pointA.p_x, point2.p_x, 0.001);
		assertEquals(pointA.p_y, point2.p_y, 0.001);
		assertEquals(pointA.p_z, point2.p_z, 0.001);
		assertEquals(pointA.texture_x, point2.texture_x, 0.001);
		assertEquals(pointA.texture_y, point2.texture_y, 0.001);
		assertEquals(pointA.normal, point2.normal);
		
		assertNotSame(pointA, point2);
		
	}
	
	@Test
	public void testEquals(){
		
		assertFalse(pointA.equals(pointB));
		
		pointB = new Point3D(3,4,5);
		
		assertTrue(pointA.equals(pointB));
		
		pointB = new Point3D(3,4,5);
		
	}
	
	@Test
	public void testIsSelected(){
		
		assertFalse(pointA.isSelected);
		
		pointA.setSelected(true);
		assertTrue(pointA.isSelected);
		
		pointA.setSelected(false);
		
	}
	
	@Test
	public void testCalculateCos(){
		
		double cos = Point3D.calculateCosin(pointA,pointB);
		
		double trueCosRad = 0.99;
		
		assertEquals(trueCosRad, cos, 0.01);
		
	}
	
	@Test
	public void testDotProduct(){
		
		double dot = Point3D.calculateDotProduct(pointA, pointB);
		double trueDot = 86.0;
		
		assertEquals(trueDot, dot, 0.01);
		
	}
	
	@Test
	public void testCalculateNorm(){
		
		double norm = Point3D.calculateNorm(pointA);
		double trueNorm = 7.07;
		
		assertEquals(trueNorm, norm, 0.01);
	}
	
	@Test
	public void testCalculateSquareNorm(){
		
		double squareNorm = Point3D.calculateSquareNorm(pointA);
		double trueSquareNorm = 50.0;
		
		assertEquals(trueSquareNorm, squareNorm, 0.01);
	}
	

	@Test
	public void testDistance(){
		
		double dis = Point3D.distance(pointB, pointA);
		double trueDis = 5.196;
		
		assertEquals(trueDis, dis, 0.01);
	}
	
	@Test
	public void testCalculateOrthogonal(){
		
		Point3D test = Point3D.calculateOrthogonal(pointA);
		Point3D expected = new Point3D(-4,3,0);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
		
	}
	
	@Test
	public void testCalculateVersor(){
		
		Point3D test = pointA.calculateVersor();
		Point3D expected = new Point3D(0.424, 0.566, 0.707);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
		
		//Test for zero conditions
		expected = new Point3D(0, 0, 0);
		test = expected.calculateVersor();
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
	}
	
	@Test
	public void testCalculateCrossProduct(){
		
		Point3D test = Point3D.calculateCrossProduct(pointA, pointB);
		Point3D expected = new Point3D(-3.0, 6.0, -3.0);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
	}
	
	@Test
	public void testSubtract(){
		
		Point3D test = pointB.substract(pointA);
		Point3D expected = new Point3D(3,3,3);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
	}
	
	@Test
	public void testMinus() throws Exception{
		
		pointB.p_x = 9;
		pointB.p_y = 10;
		pointB.p_z = 11;
		
		Point3D test = pointB.minus(pointA);
		Point3D expected = new Point3D(3,3,3);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
		
		assertEquals(9.0, test.p_x, 0.1);
		assertEquals(10.0, test.p_y, 0.1);
		assertEquals(11.0, test.p_z, 0.1);
		
		assertSame(pointB, test);
		
		setUp();
	}
	
	@Test
	public void testSum(){
		
		Point3D test = pointB.sum(pointA);
		Point3D expected = new Point3D(9,11,13);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
	}
	
	@Test
	public void testMultiply(){
		
		Point3D test = pointA.multiply(2.0);
		Point3D expected = new Point3D(6,8,10);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
	}
	
	@Test
	public void testGetX(){
		
		double test = pointA.getX();
		double expected = 3.0;
		
		assertEquals(expected, test, 0.1);
	}
	
	@Test
	public void testGetY(){
		
		double test = pointA.getY();
		double expected = 4.0;
		
		assertEquals(expected, test, 0.1);
	}
	
	@Test
	public void testGetZ(){
		
		double test = pointA.getZ();
		double expected = 5.0;
		
		assertEquals(expected, test, 0.1);
	}
	
	@Test
	public void testSetX() throws Exception{
		
		pointA.setX(2);
		double expected = 2.0;
		
		assertEquals(expected, pointA.x, 0.1);
		
		setUp();
	}
	
	@Test
	public void testSetY() throws Exception{
		
		pointA.setY(2);
		double expected = 2.0;
		
		assertEquals(expected, pointA.y, 0.1);
		
		setUp();
	}
	
	@Test
	public void testSetZ() throws Exception{
		
		pointA.setZ(2);
		double expected = 2.0;
		
		assertEquals(expected, pointA.z, 0.1);
		
		setUp();
	}
	
	@Test
	public void testFoundXIntersection(){
		
		double test = Point3D.foundXIntersection(pointA, pointB, 10.0);
		double expected = 9.0;
		
		assertEquals(expected, test, 0.1);

	}
	
	@Test
	public void testFoundZIntersection(){
		
		double test = Point3D.foundZIntersection(pointA, pointB, 10.0);
		double expected = 11.0;
		
		assertEquals(expected, test, 0.1);

	}
	
	@Test
	public void testFoundPX_PY_PZIntersection() throws Exception{
		
		pointA.p_x = 3;
		pointA.p_y = 4;
		pointA.p_z = 5;
		
		pointB.p_x = 6;
		pointB.p_y = 7;
		pointB.p_z = 8;
		
		Point3D test = Point3D.foundPX_PY_PZ_Intersection(pointA, pointB, 10.0);
		Point3D expected = new Point3D(314.25, 27.933, 8.00);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);
		
		setUp();

	}
	
	@Test
	public void testFoundPX_PY_PZ_TEXTURE_Intersection() throws Exception{
		
		pointA.p_x = 3;
		pointA.p_y = 4;
		pointA.p_z = 5;
		
		pointB.p_x = 6;
		pointB.p_y = 7;
		pointB.p_z = 8;
		
		Point3D test = Point3D.foundPX_PY_PZ_TEXTURE_Intersection(pointA, pointB, 10.0);
		Point3D expected = new Point3D(314.25, 27.933, 8.00);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);

		setUp();
	}
	
	@Test
	public void testFoundPXIntersection() throws Exception{
		
		pointA.p_x = 3;
		pointA.p_y = 4;
		pointA.p_z = 5;
		
		pointB.p_x = 6;
		pointB.p_y = 7;
		pointB.p_z = 8;
		
		double test = Point3D.foundPXIntersection(pointA, pointB, 10.0);
		double expected = 314.25;
		
		assertEquals(expected, test, 0.1);
		
		setUp();
		

	}
	
	@Test
	public void testFoundPYIntersection() throws Exception{
		
		pointA.p_x = 3;
		pointA.p_y = 4;
		pointA.p_z = 5;
		
		pointB.p_x = 6;
		pointB.p_y = 7;
		pointB.p_z = 8;
		
		double test = Point3D.foundPYIntersection(pointA, pointB, 10.0);
		double expected = 27.933;
		
		assertEquals(expected, test, 0.1);
		
		setUp();

	}
	
	@Test
	public void testFoundPZIntersection() throws Exception{
		
		pointA.p_x = 3;
		pointA.p_y = 4;
		pointA.p_z = 5;
		
		pointB.p_x = 6;
		pointB.p_y = 7;
		pointB.p_z = 8;
		
		double test = Point3D.foundPZIntersection(pointA, pointB, 10.0);
		double expected = 8.00;
		
		assertEquals(expected, test, 0.1);
		
		setUp();

	}
	
	@Test
	public void testRotate() throws Exception{
		
		pointA.rotate(6,7,1,1);
		
		Point3D expected = new Point3D(6,1,5);
		
		assertEquals(expected.x, pointA.x, 0.1);
		assertEquals(expected.y, pointA.y, 0.1);
		assertEquals(expected.z, pointA.z, 0.1);
		
		setUp();

	}
	
	@Test
	public void testBuildTranslatedPoint(){
		
		Point3D test = pointA.buildTranslatedPoint(2, 2, 2);
		Point3D expected = new Point3D(5,6,7);
		
		assertEquals(expected.x, test.x, 0.1);
		assertEquals(expected.y, test.y, 0.1);
		assertEquals(expected.z, test.z, 0.1);

	}
	
	@Test
	public void testTranslate() throws Exception{
		
		pointA.translate(2, 2, 2);
		Point3D expected = new Point3D(5,6,7);
		
		assertEquals(expected.x, pointA.x, 0.1);
		assertEquals(expected.y, pointA.y, 0.1);
		assertEquals(expected.z, pointA.z, 0.1);
		
		setUp();

	}
	
	@Test
	public void setTexturePositions() throws Exception{
		
		pointA.setTexurePositions(3.0, 3.0);
		
		assertEquals(3.0, pointA.texture_x, 0.1);
		assertEquals(3.0, pointA.texture_y, 0.1);
		
		setUp();

	}
	
	@Test
	public void testToString(){
		
		assertEquals("3.0 4.0 5.0", pointA.toString());
	}
	
	@Test
	public void testGetNormal() throws Exception{
		
		pointA.normal = pointB;
		
		assertEquals(pointB, pointA.normal);
		
		setUp();
	}
	
	@Test
	public void testSetNormal() throws Exception{
		
		pointA.setNormal(pointB);
		
		assertEquals(pointB, pointA.normal);
		
		setUp();
	}
	
	
	
	
	
	
	
}
