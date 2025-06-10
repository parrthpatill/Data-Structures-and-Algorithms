import java.util.Queue;
import java.util.LinkedList;

public class StackUsingQueue{
	Queue<Integer> q = new LinkedList<>();

	void push(int x){
		q.offer(x);
		for(int i = 1; i<q.size(); i++){
			q.add(q.poll());
		}
	}

	int pop(){
		return q.poll();
	}

	int top(){
		return q.peek();
	}

	int size(){
		return q.size();
	}

}