public class DeleteANode{
	Node deleteNode(Node head, int k){
		//Length == 0
		if(head == null) return head;
		if(k == 1){
			head = head.next;
			return head;
		}
		int cnt = 0;
		Node temp = head;
		Node prev = null;
		while(temp != null){
			cnt++;
			if(cnt == k){
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}
}