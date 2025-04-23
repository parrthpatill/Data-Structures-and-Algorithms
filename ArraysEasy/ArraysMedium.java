import java.util.*;

class ArraysMedium{

// 2Sum Problem
	boolean twoSumBruteForce(int[] arr, int target) {
		int n = arr.length;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(arr[i] + arr[j] == target){
					return true;
				}
			}
		}
		return false;
	}

	boolean twoSumBetter(int[] arr, int target){
		int req;
		Map<Integer, Integer> elementMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			req = target - arr[i];
			if(elementMap.containsKey(req)){
				return true;
			}
			elementMap.put(arr[i], i);
		}
		return false;
	}
	boolean twoSumOptimal(int[] arr, int target){
		int left = 0;
		int right = arr.length -1;
		int sum = 0;
		while(left < right){
			sum = arr[left] + arr[right];
			if(sum == target){
				return true;
			}
			if(sum > target){
				right--;
			} else {
				left++; 
			}
		}
		return false;

	}




	public static void main(String[] args){
		ArraysMedium obj = new ArraysMedium();
		int[] arr1 = {2,6,5,7,11};
		boolean ans = obj.twoSumBruteForce(arr1, 14);
		System.out.println(ans);
	}
}