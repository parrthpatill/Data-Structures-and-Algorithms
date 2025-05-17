public class CountInversions{



	// Optimal Solution using merge sort
	int merge(int[] arr, int low, int mid, int high){
		int right, left;
		int index = 0;
		int[] temp = new int[high - low + 1];
		left = low;
		right = mid+1;
		int cnt = 0;
		while(left <= mid && right <= high){
			if(arr[left] <= arr[right]){
				temp[index] = arr[left];
				left++;
				index++;
			} else{
				temp[index] = arr[right];
				right++;
				index++;
				cnt += mid - left + 1;
			}
		}
		while(left <= mid){
			temp[index] = arr[left];
			left++;
			index++;	
		}
		while(right <= high){
			temp[index] = arr[right];
			right++;
			index++;	
		}
		for(int i=low; i<=high; i++){
			arr[i] = temp[i-low];
		}
		return cnt;
	}

	int mergeSort(int arr[], int low, int high){
		int cnt = 0;
		if(low >= high){
			return cnt;
		}
		int mid = (low + high)/2;
		cnt += mergeSort(arr, low, mid);
		cnt += mergeSort(arr, mid+1, high);
		cnt += merge(arr, low, mid, high);

		return cnt;
	}

	int countInversionsOptimal(int[] arr){
		int cnt = mergeSort(arr, 0, arr.length-1);
		return cnt;
	}
}