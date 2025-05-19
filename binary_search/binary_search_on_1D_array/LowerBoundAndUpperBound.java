public class LowerBoundAndUpperBound {

	// Lower Bound
	// Search insert position
	// Ceil in an array
	static int lowerBound(int[] arr, int x){
		int n = arr.length;
		int low = 0;
		int high = n-1;
		int ans = n;

		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] >= x){
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	// Upper Bound
	static int upperBound(int[] arr, int x){
		int n = arr.length;
		int low = 0;
		int high = n-1;
		int ans = n;

		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] > x){
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
}