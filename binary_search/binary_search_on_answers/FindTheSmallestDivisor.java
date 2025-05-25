import java.lang.Math;

public class FindTheSmallestDivisor{
	//Brute force Solution
	int findTheSmallestDivisorBrute(int[] arr, int threshold){
		int n = arr.length;
		int maxi = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			maxi = Integer.max(arr[i], maxi);
		}
		for(int i = 1; i<=maxi; i++){
			int sum = 0;
			for(int j = 0; j<n; j++){
				sum += Math.ceil((double)arr[j]/(double)i);
			}
			if(sum <= threshold) return i;
		}
		return -1;
	}
	
	// Optimal solution
	int sumOfVal(int[] arr, int n, int mid){
		int sum = 0;
		for(int i=0; i<n; i++){
			sum += Math.ceil((double)arr[i]/(double)mid);
		}
		return sum;
	}
	int findTheSmallestDivisorOptimal(int[] arr, int threshold){
		int n = arr.length;
		int high = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			high = Integer.max(arr[i], high);
		}
		int low = 1;
		while(low <= high){
			int mid = (low + high)/2;
			int sum = sumOfVal(arr, n, mid);
			if(sum <= threshold){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}