package alexluebeck.Huffman;

public class Node implements Comparable<Node> {
	private Node leftNode;
	private Node rightNode;
	private double freq;
	private String characterString;
	private int treeHeight;

	public Node(Node leftNode, Node rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.freq = leftNode.getFreq() + rightNode.getFreq();
		this.characterString = null;
		this.treeHeight = Math.max(leftNode != null ? leftNode.treeHeight : 0, rightNode != null ? rightNode.treeHeight : 0) + 1;
	}

	public Node(String character, double freq) {
		this.leftNode = null;
		this.rightNode = null;
		this.freq = freq;
		this.characterString = character;
		this.treeHeight = 0;
	}

	public double getFreq() {
		return this.freq;
	}

	public Node getLeft() {
		return this.leftNode;
	}

	public Node getRight() {
		return this.rightNode;
	}
	
	public String getCharacter() {
		return this.characterString;
	}

	public int compareTo(Node o) {
		if(this.getFreq() < o.getFreq()) {
			return -1;
		} else if (this.getFreq() > o.getFreq()) {
			return 1;
		} else {
			return this.treeHeight - o.treeHeight;
		}
	}
}
