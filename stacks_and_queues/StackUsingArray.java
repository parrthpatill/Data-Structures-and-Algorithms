public class StackUsingArray{
	int size;
	int top = -1;
	int[] stack;

	StackUsingArray(int size){
		this.size = size;
		this.stack = new int[size];
	}

	void push(int x){
		if(top >= size - 1){
			System.out.println("Stack full");
			return;
		}
		top = top + 1;
		stack[top] = x;
	}

	void pop(){
		if(top == -1){
			System.out.println("Stack Empty");
			return;
		}
		top = top - 1;
	}

	int top(){
		if(top == -1){
			System.out.println("Stack Empty");
			return 220905;
		}
		return stack[top];
	}

	int size(){
		return top+1;
	}

}