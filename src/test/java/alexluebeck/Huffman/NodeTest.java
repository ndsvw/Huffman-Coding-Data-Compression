package alexluebeck.Huffman;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test1() {
		Node n1 = new Node("a", 20);
		Node n2 = new Node("b", 10);
		Node n3 = new Node("c", 30);
		ArrayList<Node> list = new ArrayList<Node>(Arrays.asList(n1, n2, n3));
		Collections.sort(list);

		assertEquals(list.get(0).getCharacter(), "b");
		assertEquals(list.get(1).getCharacter(), "a");
		assertEquals(list.get(2).getCharacter(), "c");
	}

	@Test
	public void test2() {
		Node n1 = new Node("a", 0.5);
		Node n2 = new Node("b", 0.4);
		Node n3 = new Node("c", 0.1);
		ArrayList<Node> list = new ArrayList<Node>(Arrays.asList(n1, n2, n3));
		Collections.sort(list);

		assertEquals(list.get(0).getCharacter(), "c");
		assertEquals(list.get(1).getCharacter(), "b");
		assertEquals(list.get(2).getCharacter(), "a");
	}
	
	@Test
	public void test3() {
		Node n1 = new Node("a", 0.5);
		Node n2 = new Node("b", 0.4);
		Node n3 = new Node("c", 0.1);
		
		Node n4 = new Node(n1, n2);
		Node n5 = new Node(n3, n4);

		assertEquals(n5.getFreq(), 1.0, 0.001);
		assertEquals(n4.getFreq(), 0.9, 0.001);
		assertEquals(n3.getFreq(), 0.1, 0.001);
		assertEquals(n2.getFreq(), 0.4, 0.001);
		assertEquals(n1.getFreq(), 0.5, 0.001);
		
		assertEquals(n5.getCharacter(), null);
		assertEquals(n4.getCharacter(), null);
		assertEquals(n3.getCharacter(), "c");
		assertEquals(n2.getCharacter(), "b");
		assertEquals(n1.getCharacter(), "a");
	}
	
	@Test
	public void test4() {
		Node n1 = new Node("a", 2000);
		Node n2 = new Node("b", 2000);
		Node n3 = new Node("c", 2000);
		Node n4 = new Node("d", 1000);
		Node n5 = new Node("e", 3000);
		
		Node n6 = new Node(n5, n4);
		Node n7 = new Node(n6, n3);
		Node n8 = new Node(n7, n2);
		Node n9 = new Node(n8, n1);

		assertEquals(n9.getFreq(), 10000, 0.001);
		assertEquals(n8.getFreq(), 8000, 0.001);
		assertEquals(n7.getFreq(), 6000, 0.001);
		assertEquals(n6.getFreq(), 4000, 0.001);
		assertEquals(n5.getFreq(), 3000, 0.001);
		assertEquals(n4.getFreq(), 1000, 0.001);
		assertEquals(n3.getFreq(), 2000, 0.001);
		assertEquals(n2.getFreq(), 2000, 0.001);
		assertEquals(n1.getFreq(), 2000, 0.001);
		
		assertEquals(n9.getCharacter(), null);
		assertEquals(n8.getCharacter(), null);
		assertEquals(n7.getCharacter(), null);
		assertEquals(n6.getCharacter(), null);
		assertEquals(n5.getCharacter(), "e");
		assertEquals(n4.getCharacter(), "d");
		assertEquals(n3.getCharacter(), "c");
		assertEquals(n2.getCharacter(), "b");
		assertEquals(n1.getCharacter(), "a");
	}

}
