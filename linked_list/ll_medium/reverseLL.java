public class reverseLL{
	// iterative 
	Node reverseLLIterative(Node head){
		if(head == null || head.next == null) return head;
		Node current = head;
		Node prev = null;
		while(current != null){
			Node front = current.next;
			current.next = prev;
			prev = current;
			current = front;
		}
		return prev;
	}

	// recurrsive
	Node reverseLLRecursive(Node head){
		if(head == null || head.next == null) return head;
		Node temp = head;
		Node newHead = reverseLLRecursive(temp.next);

		Node front = head.next;
		front.next = head;
		head.next = null;
		return newHead;
	}
}