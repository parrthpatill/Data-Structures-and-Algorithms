public class QueueUsingLL{
	int size;
	Node start;
	Node end;

	QueueUsingLL(){
		start = null;
		end = null;
		size = 0;
	}

	void push(int x){
		Node temp = new Node(x);
		if(start == null && end == null){
			start = temp;
			end = temp;
		} else {
			end.next = temp;
			end = temp;
		}
		size += 1;
	}

	int pop(){
		if(start == null && end == null){
			System.out.println("Queue Empty");
			return 220905;
		}
		int el = start.data;
		Node temp = start;
		start = start.next;
		temp.next = null;
		if(start == null){
			end = null;
		}
		size -= 1;
		return el;
	}

	int front(){
		if(start == null){
			System.out.println("Queue Empty");
			return 220905;
		}
		return start.data;
	}

	int size(){
		return size;
	}

}