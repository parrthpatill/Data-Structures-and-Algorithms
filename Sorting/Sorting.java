
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
	
	 static void quickSort(int arr[], int low, int high) {
        // code here
        if(low < high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i]<=pivot && i<= high-1){
                i++;
            }
            while(arr[j] >pivot && j>= low+1){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
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