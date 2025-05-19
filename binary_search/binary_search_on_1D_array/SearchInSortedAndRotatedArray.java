public class SearchInSortedAndRotatedArray{

	// UNIQUE ELEMENTS
	int searchInSortedAndRotatedArray(int[] arr, int x){
		int low = 0;
		int high = arr.length - 1;

		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] == x){
				return mid;
			}
			if(arr[low] <= arr[mid]){
				if(arr[low] <= x && x <= arr[mid]){
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if(arr[mid] <= x && x <= arr[high]){
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	// WITH DUPLICATES
	boolean searchInSortedAndRotatedArrayII(int[] arr, int x){
		int low = 0;
		int high = arr.length - 1;

		while(low <= high){
			int mid = (low + high)/2;

			if(arr[mid] == x) return true;
			if(arr[low] == arr[mid] && arr[mid] == arr[low]){
				low++;
				high--;
				continue;
			}
			if(arr[low] <= arr[mid]){
				if(arr[low] <= x && x <= arr[mid]){
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if(arr[mid] <= x && x <= arr[high]){
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return false;
	}
}