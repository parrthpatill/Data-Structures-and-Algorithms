class ArraysEasy{

//Largets element in an array :
	int largestElement(int[] nums){
		int largest = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(nums[i] > largest){
				largest = nums[i];
			}
		}
		return largest;
	}

// Second largest and second smallest element in an array:
	int secondLargestElement(int [] arr){
		int largest = arr[0];
		int sLargest = Integer.MIN_VALUE;

		for(int i = 0; i < arr.length; i++){
			if(arr[i] > largest){
				sLargest = largest;
				largest = arr[i];
			} else if(arr[i] < largest && arr[i] > sLargest){
				sLargest = arr[i];
			}
		}
		return sLargest;
	}
	int secondSmallestElement(int[] arr){
		int smallest = arr[0];
		int secondSmallest = Integer.MAX_VALUE;

		for(int i =0; i < arr.length; i++){
			if(arr[i] < smallest){
				secondSmallest = smallest;
				smallest = arr[i];
			} else if(arr[i] > smallest && arr[i] < secondSmallest){
				secondSmallest = arr[i];
			}
		}
		return secondSmallest;
	}

// check if the array is sorted
	boolean checkSorted(int[] arr){
		for (int i = 1; i < arr.length; i++){
			if(arr[i-1] < arr[i]){}
			else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){

		ArraysEasy obj = new ArraysEasy();
		int[] nums = {1,2,3,4,5};
		System.out.println(obj.checkSorted(nums));
	}
}