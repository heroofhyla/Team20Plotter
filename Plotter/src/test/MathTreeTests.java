package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.maths.MathTree;
import com.maths.TNode;

public class MathTreeTests {

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
	public void testEvaluateLiteral() {
		TNode node = new TNode();
		node.setValue("17");
		MathTree tree = new MathTree();
		assertEquals(17,tree.evaluate(node, 10, 5),.001);
	}
	
	@Test
	public void TestEvaluateX(){
		TNode node = new TNode();
		node.setValue("X");
		MathTree tree = new MathTree();
		assertEquals(10, tree.evaluate(node, 10,5),0.001);
	}
	
	@Test
	public void TestEvaluateY(){
		TNode node = new TNode();
		node.setValue("Y");
		MathTree tree = new MathTree();
		assertEquals(5, tree.evaluate(node, 10,5),0.001);
	}
	
	@Test
	public void TestEvaluateSum(){
		TNode node = new TNode();
		node.setLabel("+");
		TNode left = new TNode();
		left.setValue("3");
		TNode right = new TNode();
		right.setValue("X");
		
		node.appendChild(left);
		node.appendChild(right);
		MathTree tree = new MathTree();
		assertEquals(13, tree.evaluate(node, 10,5), 0.001);
	}

}
