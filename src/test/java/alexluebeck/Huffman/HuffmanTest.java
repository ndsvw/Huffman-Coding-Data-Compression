package alexluebeck.Huffman;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.junit.Test;

public class HuffmanTest {

	@Test(expected = AssertionError.class)
	public void testEmptyPQ() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Huffman huffman = new Huffman(pq);
		HashMap<String, String> encodingTable = huffman.createEncodingTable();
	}

	@Test
	public void test1Element() {
		Node n = new Node("a", 20);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(Arrays.asList(n));
		Huffman huffman = new Huffman(pq);
		HashMap<String, String> encodingTable = huffman.createEncodingTable();
		assertEquals(encodingTable.get("a").length(), 1);
	}

	@Test
	public void test2Elements() {
		Node n1 = new Node("a", 20);
		Node n2 = new Node("b", 30);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(Arrays.asList(n1, n2));
		Huffman huffman = new Huffman(pq);
		HashMap<String, String> encodingTable = huffman.createEncodingTable();
		assertEquals(encodingTable.get("a").length(), 1);
		assertEquals(encodingTable.get("b").length(), 1);
	}

	@Test
	public void test3Elements() {
		Node n1 = new Node("a", 20);
		Node n2 = new Node("b", 30);
		Node n3 = new Node("c", 40);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(Arrays.asList(n1, n2, n3));
		Huffman huffman = new Huffman(pq);
		HashMap<String, String> encodingTable = huffman.createEncodingTable();
		assertEquals(encodingTable.get("c").length(), 1);
		assertEquals(encodingTable.get("b").length(), 2);
		assertEquals(encodingTable.get("a").length(), 2);
	}

}
