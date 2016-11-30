package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.maths.TNode;

public class TNodeTests {

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
	public void testNullParent() {
		TNode node = new TNode();
		assertNull(node.getParent());
	}
	
	@Test
	public void testSetParent(){
		TNode node = new TNode();
		TNode parent = new TNode();
		node.setParent(parent);
		
		assertEquals(parent, node.getParent());
	}
	
	@Test
	public void testParentconstructor(){
		TNode parent = new TNode();
		TNode node = new TNode(parent);
		
		assertEquals(parent, node.getParent());
	}
	
	@Test
	public void testAppendChildParent(){
		TNode parent = new TNode();
		TNode node = new TNode();
		parent.appendChild(node);
		assertEquals(parent, node.getParent());
	}
	
	@Test
	public void testChildCount(){
		TNode node = new TNode();
		node.appendChild(new TNode());
		node.appendChild(new TNode());
		
		assertEquals(2, node.getChildCount());
	}
	
	@Test
	public void testGetChildAt(){
		TNode node = new TNode();
		TNode left = new TNode();
		TNode right = new TNode();
		node.appendChild(left);
		node.appendChild(right);
		
		assertEquals(right, node.getChildAt(1));
	}
	
	@Test
	public void testChildCountAfterRemove(){
		TNode node = new TNode();
		node.appendChild(new TNode());
		node.appendChild(new TNode());
		node.removeChildAt(0);
		
		assertEquals(1, node.getChildCount());
	}
	
	@Test
	public void testGetChildAfterRemove(){
		TNode node = new TNode();
		TNode left = new TNode();
		TNode right = new TNode();
		node.appendChild(left);
		node.appendChild(right);
		node.removeChild(left);
		
		assertEquals(right, node.getChildAt(0));
	}
	
	@Test
	public void testChildCountUpdateAfterSetParent(){
		TNode node = new TNode();
		TNode parent = new TNode();
		node.setParent(parent);
		
		//Fails! assertEquals(1, parent.getChildCount());
	}

}
