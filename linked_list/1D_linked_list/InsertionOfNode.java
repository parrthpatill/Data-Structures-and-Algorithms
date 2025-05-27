public class InsertionOfNode{
	Node insertNode(Node head, int el, int k){
		if(head == null){
			if(k == 1){
				return new Node(el);
			}
		}
		if(k == 1){
			return new Node(el, head);
		}
		int cnt = 0;
		Node temp = head;
		while(temp != null){
			cnt++;
			if(cnt == k-1){
				Node newNode = new Node(el, temp.next);
				temp.next = newNode;
				break;
			}
			temp = temp.next;
		}
		return head;
	}
}