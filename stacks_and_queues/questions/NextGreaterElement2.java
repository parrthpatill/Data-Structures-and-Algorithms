import java.util.Stack;

public class NextGreaterElement2{
	// brute force
	int[] nextGreaterElement2Brute(int[] arr){
		int n = arr.length;
		int nge2[] = new int[n];
		for(int i = 0; i<n; i++){
			int mini = -1;
			for(int j = i+1; j < n+i; j++){
				int ind = j % n;
				if(arr[ind] > arr[i]){
					mini = arr[ind];
					break;
				}
			}
			nge2[i] = mini;
		}
		return nge2;
	}

	//optimal solution
	int[] nextGreaterElement2Optimal(int[] arr){
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int[] nge2 = new int[n];
		for(int i = 2*n - 1; i>=0; i--){
			int ind = i % n;
			while(!st.empty() && arr[ind] >= st.peek()){
				st.pop();
			}
			if(i < n){
				nge2[i] = st.empty() ? -1 : st.peek();
			}
			st.push(arr[ind]);
		}
		return nge2;
	}
	
}