package alexluebeck.Huffman;

public class Node implements Comparable<Node> {
	private Node leftNode;
	private Node rightNode;
	private double freq;
	private String characterString;

	public Node(Node leftNode, Node rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.freq = leftNode.getFreq() + rightNode.getFreq();
		this.characterString = null;
	}

	public Node(String character, double freq) {
		this.leftNode = null;
		this.rightNode = null;
		this.freq = freq;
		this.characterString = character;
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
			return 0;
		}
	}
}
