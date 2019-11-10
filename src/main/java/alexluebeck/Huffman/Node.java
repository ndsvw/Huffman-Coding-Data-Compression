package alexluebeck.Huffman;

public class Node {
	private Node leftNode;
	private Node rightNode;
	private int freq;
	private String characterString;
	
	public Node(Node leftNode, Node rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.freq = leftNode.getFreq() + rightNode.getFreq();
		this.characterString = null;
	}
	
	public Node(int freq, String character) {
		this.leftNode = null;
		this.rightNode = null;
		this.freq = freq;
		this.characterString = character;
	}
	
	public int getFreq() {
		return this.freq;
	}
}
