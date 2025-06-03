import java.util.Stack;

public class CheckPalindromeLL{
	// brute force solution
	boolean checkPalindromeLLBrute(Node head){
		Node temp = head;
		Stack<Integer> st = new Stack<>();
		while(temp != null){
			st.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while(temp != null){
			if(st.peek().equals(temp.data)) return false;
			temp = temp.next;
			st.pop();
		}
		return true;
	}

	// Optimal solution
	boolean checkPalindromeLLOptimal(Node head){
		if(head == null) return false;
		if(head.next == null) return true;
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node newHead = reverseLL.reverseLLIterative(slow.next);
		Node first = head;
		Node second = newHead;
		while(second != null){
			if(first.data != second.data) return false;
			second = second.next;
			first = first.next;
		}

		return true;

	}
}