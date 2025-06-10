public class QueueUsingStack{
	Stack<Integer> st1;
	Stack<Integer> st2;

	QueueUsingStack(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	void push(int x){
		while(!s1.empty()){
			s2.push(s1.pop());
		}
		s1.push(x);
		while(!s2.empty()){
			s1.push(s2.pop());
		}
	}

	int pop(){
		if(s1.size() == 0) return -1;
		return s1.pop();
	}

	int top(){
		if(s1.size() == 0) return -1;
		return s1.peek();
	}

	int size(){
		return s1.size();
	}
}