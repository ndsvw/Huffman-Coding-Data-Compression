package alexluebeck.Huffman;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Huffman {
	private Node tree;

	public Huffman(PriorityQueue<Node> nodeQueue) {
		while (nodeQueue.size() >= 2) {
			Node node1 = nodeQueue.poll();
			Node node2 = nodeQueue.poll();

			Node parentNode = new Node(node1, node2);
			nodeQueue.add(parentNode);
		}

		Node root = nodeQueue.poll();
		this.tree = root;
	}
}
