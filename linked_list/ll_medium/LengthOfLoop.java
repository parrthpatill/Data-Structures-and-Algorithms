public class LengthOfLoop{
	int lengthOfLoopBrute(Node head){
		if(head == null || head.next == null) return 0;
		Node temp = head;
		Map<Node, Integer> mpp = new HashMap<>();
		int lengthCnt = 0;
		while(temp != null){
			if(mpp.containsKey(temp)){
				return lengthCnt - mpp.get(temp);
			} 

			lengthCnt++;
			mpp.put(temp, lengthCnt);
			temp = temp.next;
		}
		return 0;
	}

	// optimal solution
	int lengthOfLoopOptimal(Node head){
		if(head == null || head.next == null) return 0;
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				fast = fast.next;
				int cnt = 1;
				while(slow != fast){
					cnt++;
					fast = fast.next;
				}
				return cnt;
			}
		}
		return 0;
	}
}