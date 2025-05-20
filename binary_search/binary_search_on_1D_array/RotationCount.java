public class RotationCount{
	//Only Uniques
	int rotationCount(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		int ans = Integer.MAX_VALUE;
		int index = -1;

		while(low <= high){
			int mid = (low + high)/2;

			if(arr[low] <= arr[high]){
				if(arr[low] < ans){
					ans = arr[low];
					index = low;
				}
				break;
			}
			if(arr[low] <= arr[mid]){
				if(arr[low] < ans){
					ans = arr[low];
					index = low;
				}
				low = mid + 1;
			} else {
				if(arr[mid] < ans){
					ans = arr[mid];
					index = mid;
				}
				high = mid - 1;
			}
		}
		return index;
	}

	// With Duplicates
	int rotationCountII(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		int ans = Integer.MAX_VALUE;
		int index = -1;

		while(low <= high){
			int mid = (low + high)/2;

			if(arr[low] == arr[mid] && arr[mid] == arr[high]){
				low++;
				high--;
				continue;
			}
			
			if(arr[low] <= arr[mid]){
				if(arr[low] < ans){
					ans = arr[low];
					index = low;
				}
				low = mid + 1;
			} else {
				if(arr[mid] < ans){
					ans = arr[mid];
					index = mid;
				}
				high = mid - 1;
			}
		}
		return index;
	}
}