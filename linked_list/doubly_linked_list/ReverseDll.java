import java.util.Stack;

public class ReverseDll{
	//brute force
	Node reverseDllBrute(Node head){

		Stack<Integer> st = new Stack<>();
		Node temp = head;
		while(temp != null){
			st.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while(temp != null){
			temp.data = st.pop();
			temp = temp.next;
		}

		return head;
	}

	//Optimal solution

	Node reverseDllOptimal(Node head){
		if(head == null || head.next == null) return head;
		Node current = head;
		Node last = null;
		while(current != null){
			last = current.back;
			current.back = current.next;
			current.next = last;

			current = current.back;
		}
		return last.back;
	}
}