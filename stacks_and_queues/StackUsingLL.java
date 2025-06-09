public class StackUsingLL{
	Node top = null;
	int size = 0;

	void push(int x){
		Node temp = new Node(x);
		temp.next = top;
		top = temp;
		size += 1;
	}

	int pop(){
		if(top == null){
			System.out.println("Stack empty");
			return 220905;
		}
		int el = top.data;
		Node temp = top;
		top = top.next;
		temp.next = null;
		size -= 1;
		return el;
	}

	int top(){
		if(top == null) return null;
		return top.data;
	}

	int size(){
		return size;
	}
}