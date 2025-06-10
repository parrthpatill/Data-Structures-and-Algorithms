public class QueueUsingArray{
	int size;
	int currSize = 0;
	int start = -1;
	int end = -1;
	int[] queue;

	QueueUsingArray(int size){
		this.size = size;
		queue = new int[size];
	}

	void push(int x){
		if(size == currSize){
			System.out.println("Queue full");
			return;	
		} 
		if(currSize == 0){
			start += 1;
			end += 1;
		} else {
			end = (end+1) % size;
		}
		queue[end] = x;
		currSize += 1;
	}

	int pop(){
		if(currSize == 0){
			System.out.println("Stack empty");
			return 220905;
		}
		int element = queue[start];
		if(currSize == 1){
			start = -1;
			end = -1;
		} else {
			start = (start + 1) % size;
		}
		currSize -= 1;
		return element;
	}

	int front(){
		if(currSize == 0) {
			System.out.println("Queue Empty");
			return 220905;
		}
		return queue[start];
	}

	int size(){
		return currSize;
	}
}