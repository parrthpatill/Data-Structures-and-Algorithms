import java.util.*;
public class startingPointOfLoop{
	// using hashing
	Node startingPointOfLoopBrute(Node head){
		if(head == null || head.next == null) return null;
		Node temp = head;
		Map<Node, Integer> mpp = new HashMap<>();
		while(temp != null){
			if(mpp.containsKey(temp)){
				return temp;
			} else {
				mpp.put(temp, 1);
			}
			temp = temp.next;
		}
		return null;
	}

	// optimal solution
	Node startingPointOfLoopOptimal(Node head){
		if(head == null || head.next == null) return head;
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}