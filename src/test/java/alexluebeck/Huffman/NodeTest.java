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

}
