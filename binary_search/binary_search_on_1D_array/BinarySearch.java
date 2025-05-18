public class BinarySearch{

	//Iterative approach
	int binarySearchIterative(int[] arr, int k){
		int low = 0;
		int high = arr.length - 1;

		while(low <= high){
			int mid = (low+high) / 2;
			if(arr[mid] == k) return mid;
			else if (arr[mid] > k) high = mid-1;
			else low = mid + 1;
		}
		return -1;
	}

	//Recursive approach

	int binarySearchRecursive(int[] arr, int low, int high, int k){
		if(low > high) return -1;
		int mid = (low+high)/2;

		if(arr[mid] == k) return mid;
		else if(arr[mid] > k){
			return binarySearchRecursive(arr, low, mid - 1, k);
		} else {
			return binarySearchRecursive(arr, mid + 1, high, k);
		}
	}
}