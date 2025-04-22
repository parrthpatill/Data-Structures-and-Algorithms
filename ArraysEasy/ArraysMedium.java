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



	public static void main(String[] args){
		ArraysMedium obj = new ArraysMedium();
		int[] arr1 = {2,6,5,1,11};
		boolean ans = obj.twoSumBruteForce(arr1, 14);
		System.out.println(ans);
	}
}