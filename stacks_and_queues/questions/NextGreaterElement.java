import java.util.Stack;

public class NextGreaterElement{
	// brute force
	int[] nextGreaterElementBrute(int[] arr){
		int n = arr.length;
		int[] ans = new int[n];
		for(int i = 0; i<n; i++){
			int mini = -1;
			for(int j = i+1; j<n; j++){
				if(arr[j] > arr[i]){
					mini = arr[j];
					break;
				}
			}
			ans[i] = mini;
		}
		return ans;
	}

	//optimal solution
	int[] nextGreaterElementOptimal(int[] arr){
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = n-1; i>=0; i--){
			while(!st.empty() && arr[i] > st.peek()){
				st.pop();
			}
			nge[i] = st.empty() ? -1 : st.peek();
			st.push(arr[i]);
		}
		return nge;
	}
	
}