public class Node{
	int data;
	Node next;
	Node back;

	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public Node(int data, Node next, Node back){
		this.data = data;
		this.next = next;
		this.back = back;
	}
}