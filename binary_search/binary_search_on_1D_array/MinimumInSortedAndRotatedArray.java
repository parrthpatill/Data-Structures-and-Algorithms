public class MinimumInSortedAndRotatedArray{
	int minimumInSortedAndRotatedArray(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		int ans = Integer.MAX_VALUE;

		while(low <= high){
			int mid = (low + high)/2;

			if(arr[low] <= arr[high]){
				ans = Integer.min(ans, arr[low]);
			}
			if(arr[low] <= arr[mid]){
				ans = Integer.min(ans, arr[low]);
				low = mid + 1;
			} else {
				ans = Integer.min(ans, arr[mid]);
				high = mid - 1;
			}
		}
		return ans;
	}
}