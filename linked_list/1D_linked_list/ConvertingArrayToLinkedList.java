class Node{
	int data;
	Node next;

	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}

public class ConvertingArrayToLinkedList{
	private static Node convertArrToLL(int[] arr){
		Node head = new Node(arr[0], null);
		Node mover = head;
		for(int i = 1; i<arr.length; i++){
			Node temp = new Node(arr[i], null);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}

	public static void main(String[] args){
		int[] arr = {12,34,56,32};
		Node head = convertArrToLL(arr);
		System.out.println(head.data);
	}
}