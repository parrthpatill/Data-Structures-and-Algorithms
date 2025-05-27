public class DeletionInDll{
	// delete head
	Node deleteHead(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node prev = head;
		head = head.next;
		head.back = null;
		prev.next = null;

		return head;
	}

	// delete tail
	Node deleteTail(Node head){
		if(head == null || head.next == null) return null;
		Node tail = head;
		while(tail.next != null){
			tail = tail.next;
		}
		Node prev = tail.back;
		prev.next = null;
		tail.back = null;

		return head;
	}

	// delete Kth element
	Node deleteKthElement(Node head, int k){
		if(head == null) return null;

		// arriving at the kth node
		int cnt = 0;
		Node kNode = head;
		while(kNode != null){
			cnt++;
			if(cnt == k) break;
			kNode = kNode.next;
		}
		Node prev = kNode.back;
		Node front = kNode.next;

		// edge cases
		if(prev == null && front == null){
			return null;
		} else if(prev == null){
			return deleteHead(head);
		} else if(front == null){
			return deleteTail(head);
		}

		// when node is in the middle
		prev.next = front;
		front.back = prev;

		kNode.back = null;
		kNode.next = null;

		return head;
	}

	// Delete particular node, node won't be head
	void deleteNode(Node x){
		Node prev = x.back;
		if(x.next == null){
			prev.next = null;
			x.back = null;
			return;
		}
		Node front = x.next;

		prev.next = front;
		front.back = prev;

		x.next = null;
		x.back = null;
	}
}