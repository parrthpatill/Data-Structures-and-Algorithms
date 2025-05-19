public class FloorInArray{
	int floorInArray(int[] arr, int x){
		int n = arr.length;
		int low = 0;
		int high = n-1;
		int ans = -1;

		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] <= x){
				ans = arr[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return ans;
	}
}