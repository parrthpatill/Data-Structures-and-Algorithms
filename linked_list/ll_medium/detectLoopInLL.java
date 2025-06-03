import java.util.*;
public class detectLoopInLL{
	// using hasing
	boolean detectLoopBrute(Node head){
		if(head == null || head.next == null) return false;
		Node temp = head;
		Map<Node, Integer> mpp = new HashMap<>();
		while(temp != null){
			if(mpp.containsKey(temp)){
				return true;
			} else {
				mpp.put(temp, 1);
			}
			temp = temp.next;
		}
		return false;
	}

	boolean detectLoopOptimal(Node head){
		Node fast = head;
		Node slow = head;
		while(fast != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
}