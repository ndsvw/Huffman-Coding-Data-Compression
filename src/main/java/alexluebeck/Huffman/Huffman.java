package alexluebeck.Huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Huffman {
	private Node tree;

	public Huffman(PriorityQueue<Node> nodeQueue) {
		assert(nodeQueue.size() >= 1) : "At least 1 node is required";
		while (nodeQueue.size() >= 2) {
			Node node1 = nodeQueue.poll();
			Node node2 = nodeQueue.poll();

			Node parentNode = new Node(node1, node2);
			nodeQueue.add(parentNode);
		}

		Node root = nodeQueue.poll();
		this.tree = root;
	}

	private HashMap<String, String> createEncodingTable(Node node, String encoding, HashMap<String, String> map) {
		if (node.getLeft() != null) {
			createEncodingTable(node.getLeft(), encoding + "0", map);
		} else {
			map.put(node.getCharacter(), encoding);
		}

		if (node.getRight() != null) {
			createEncodingTable(node.getRight(), encoding + "1", map);
		} else {
			map.put(node.getCharacter(), encoding);
		}

		return map;
	}
	
	public HashMap<String, String> createEncodingTable() {
		if(tree.getLeft() == null && tree.getRight() == null) {
			HashMap<String, String> tmpHashMap = new HashMap<String, String>();
			tmpHashMap.put(tree.getCharacter(), "0");
			return tmpHashMap;
		}
		return createEncodingTable(tree, "", new HashMap<String, String>());
	}
	
	public void printCharacterEncoding(HashMap<String, String> encodingTable) {
		for (Entry<String, String> entry : encodingTable.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public void analyseEncodingTable(HashMap<String, String> encodingTable) {
		System.out.println("size: " + encodingTable.size());

		int minLength = Integer.MAX_VALUE;
		int maxLength = 0;
		int sumLength = 0;
		for (Entry<String, String> entry : encodingTable.entrySet()) {
			maxLength = Math.max(entry.getValue().length(), maxLength);
			minLength = Math.min(entry.getValue().length(), minLength);
			sumLength += entry.getValue().length();
		}

		System.out.println("min encoding length: " + minLength);
		System.out.println("max encoding length: " + maxLength);
		System.out.println("avg encoding length: " + (sumLength / (float) encodingTable.size()));
	}
}
