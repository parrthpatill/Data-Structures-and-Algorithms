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
// Sort an array of 0s, 1s, 2s
	void sort012Better(int[] arr){
		int countZero=0, countOne=0;
		int n = arr.length;
		for(int i=0; i<n; i++){
			if(arr[i] == 0) countZero++;
			if(arr[i] == 1) countOne++;
		}
		for(int i=0; i<countZero; i++){
			arr[i]=0;
		}
		for(int i=countZero; i<countZero+countOne; i++){
			arr[i]=1;
		}
		for(int i=countZero+countOne; i<n; i++){
			arr[i]=2;
		}
	}



	public static void main(String[] args){
		ArraysMedium obj = new ArraysMedium();
		int[] arr1 = {1,2,2,2,0,0,1,1,1};
		obj.sort012Better(arr1);
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i]+" ");	
		}
		
	}
}