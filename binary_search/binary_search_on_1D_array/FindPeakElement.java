public class FindPeakElement{
	int peakElementOptimal(int[] arr){
		int n = arr.length;
		if(n == 1) return arr[0];
		if(arr[0] > arr[1]) return arr[0];
		if(arr[n-1] > arr[n-2]) return arr[n-1];

		int low = 1, high = n-2;

		while(low <= high){
			int mid = (low + high)/2;
			//increasing scope
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
				return arr[mid];
			} else if(arr[mid] > arr[mid-1]){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}