public class InsertionInDll{
	Node insertBeforeHead(Node head, int val){
		Node newHead = new Node(val, head, null);
		head.back = newHead;
		return newHead;
	}

	Node insertBeforeTail(Node head, int val){
		if(head.next == null){
			return insertBeforeHead(head, val);
		}
		Node tail = head;
		while(tail.next != null){
			tail = tail.next;
		}
		Node prev = tail.back;

		Node newNode = new Node(val, tail, prev);
		tail.back = newNode;
		prev.next = newNode;

		return head;
	}

	Node insertBeforeKthELement(Node head, int val, int k){
		if(k == 1){
			return insertBeforeHead(head, val);
		}
		int cnt = 0;
		Node temp = head;
		while(temp != null){
			cnt++;
			if(cnt == k) break;
			temp = temp.next;
		}
		Node prev = temp.back;
		Node newNode = new Node(val, temp, prev);
		prev.next = newNode;
		temp.back = newNode;

		return head;
	}

	void insertBeforeNode(Node node, int val){
		Node prev = node.back;
		Node newNode = new Node(val, node, prev);
		prev.next = newNode;
		node.back = newNode;
	}
}