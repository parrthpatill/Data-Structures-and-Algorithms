public class MiddleNodeLL{
	// brute force solution
	int middleNodeLLBrute(Node head){
		if(head == null && head.next == null) return -1;
		int n = 0;
		Node temp = head;
		while(temp != null){
			n++;
			temp = temp.next;
		}
		int mid = n/2 + 1;
		temp = head;
		while(mid > 1){
			mid--;
			temp = temp.next;
		}
		return temp.data;
	}

	//Optimal solution
	int middleNodeLLOptimal(Node head){
		if(head == null && head.next == null) return -1;
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
}