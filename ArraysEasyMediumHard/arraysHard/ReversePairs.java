public class ReversePairs{
	//i > j && a[i] > 2*a[j]

	// Brute force approach

	int reversePairsBrute(int[] arr){
		int n = arr.length;
		int cnt = 0;
		for(int i = 0; i<n; i++){
			for(int j = i; j<n; j++){
				if(arr[i] > 2*arr[j]){
					cnt++;
				}
			}
		}
		return cnt;
	}

	//Optimal solution


	void merge(int[] arr, int low, int mid, int high){
		int right, left;
		int index = 0;
		int[] temp = new int[high - low + 1];
		left = low;
		right = mid+1;
		while(left <= mid && right <= high){
			if(arr[left] < arr[right]){
				temp[index] = arr[left];
				left++;
				index++;
			} else{
				temp[index] = arr[right];
				right++;
				index++;
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
	}

	int getCount(int[] arr, int low, int mid, int high){
		int cnt = 0;
		int right = mid+1;
		for(int i = low; i<=mid; i++){
			while(right <= high && arr[i] > 2*arr[right]){
				right++;
			}
			cnt += right - (mid +1);
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
		cnt += getCount(arr, low, mid, high);
		merge(arr, low, mid, high);

		return cnt;
	}


	int reversePairsOptimal(int[] arr){
		int cnt = mergeSort(arr, 0, arr.length - 1);
		return cnt;
	}

}