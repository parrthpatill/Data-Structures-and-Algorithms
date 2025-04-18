import java.util.Arrays;
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

// check if the array is sorted and rotated
	boolean checkSortedAndRotated(int[] arr){
		int count = 0;
		for (int i = 0; i < arr.length; i++){
			if(arr[i] >arr[(i+1)%arr.length]){
				count++;
			}
			if(count > 1){
				return false;
			}
		}
		return true;
	}

// remove duplicate from a sorted array and return the length
	int removedDuplicates(int[] arr){
		int i = 0;
		for (int j = 0; j < arr.length; j++){
			if(arr[j] != arr[i]){
				arr[i+1] = arr[j];
				i++;
			}
		}
		return i+1;
	}

//rotate array left by 1 element
	int[] rotateArrayLeftByOneElement(int[] arr){
		int temp = arr[0];
		int n = arr.length;
		for(int i = 1; i < n; i++){
			arr[i-1] = arr[i];
		}
		arr[n-1] = temp;
		return arr;
	}

//rotate right by one element
	int[] rotateArrayRightByOneElement(int[] arr){
		int n = arr.length;
		int temp = arr[n-1];
		for(int i = n-1; i > 0; i--){
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		return arr;
	}

// rotate array left by d element brute force
	int[] rotateArrayLeftByDElementsBruteForce(int arr[], int d){
		int[] temp = new int[d];
		int n = arr.length;
		for(int i =0; i<d; i++){
			temp[i] = arr[i];
		}
		for(int i =d; i<n; i++){
			arr[i-d] = arr[i];
		}
		for(int i =n-d; i<n; i++){
			arr[i] = temp[i-(n-d)];
		}
		return arr;
	}

int[] rotateArrayRightByDElementsBruteForce(int arr[], int d){
		int[] temp = new int[d];
		int n = arr.length;
		for(int i =n-d; i<n; i++){
			temp[i-(n-d)] = arr[i];
		}
		for(int i =d-1; i>=0; i--){
			arr[i+d] = arr[i];
		}
		for(int i =0; i<d; i++){
			arr[i] = temp[i];
		}
		return arr;
	}	

	public static void main(String[] args){

		ArraysEasy obj = new ArraysEasy();
		int[] nums = {1,2,3,4,5,6};
		obj.rotateArrayLeftByDElementsBruteForce(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
}