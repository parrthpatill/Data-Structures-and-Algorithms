
class Sorting{

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

	void mergeSort(int arr[], int low, int high){
		if(low >= high){
			return;
		}
		int mid = (low + high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}

	public static void main(String[] args)	{
		//Scanner sc = new Scanner(System.in);
		Sorting mergeSortObj = new Sorting();
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        mergeSortObj.mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
	}
}