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

	@Test
	public void test10Elements() {
		Node n1 = new Node("a", 74);
		Node n2 = new Node("b", 46);
		Node n3 = new Node("c", 25);
		Node n4 = new Node("d", 48);
		Node n5 = new Node("e", 13);
		Node n6 = new Node("f", 37);
		Node n7 = new Node("g", 97);
		Node n8 = new Node("h", 77);
		Node n9 = new Node("i", 45);
		Node n10 = new Node("j", 96);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10));
		Huffman huffman = new Huffman(pq);
		HashMap<String, String> encodingTable = huffman.createEncodingTable();
		assertEquals(encodingTable.get("a").length(), 3);
		assertEquals(encodingTable.get("b").length(), 4);
		assertEquals(encodingTable.get("c").length(), 5);
		assertEquals(encodingTable.get("d").length(), 3);
		assertEquals(encodingTable.get("e").length(), 5);
		assertEquals(encodingTable.get("f").length(), 4);
		assertEquals(encodingTable.get("g").length(), 2);
		assertEquals(encodingTable.get("h").length(), 3);
		assertEquals(encodingTable.get("i").length(), 4);
		assertEquals(encodingTable.get("j").length(), 3);
	}

}
