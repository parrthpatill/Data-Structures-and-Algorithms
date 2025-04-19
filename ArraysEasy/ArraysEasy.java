import java.util.Arrays;
import java.util.ArrayList;

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

// rotate array right by d element brute force
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

// rotate array by d elements to the left/right(optimal approach)
	void reverseArrayForRotation(int[] arr, int start, int end){
		while(start<=end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	int[] rotateArrayLeftByDElementsOptimal(int arr[], int d){
		int n = arr.length;
		reverseArrayForRotation(arr, 0, d-1);
		reverseArrayForRotation(arr, d, n-1);
		reverseArrayForRotation(arr, 0, n-1);
		return arr;
	}
	int[] rotateArrayRightByDElementsOptimal(int arr[], int d){
		int n = arr.length;
		reverseArrayForRotation(arr, 0, n-1);
		reverseArrayForRotation(arr, 0, d-1);
		reverseArrayForRotation(arr, d, n-1);
		return arr;
	}

// move zeros to the end of the array

	int[] moveZerosToTheEndOfTheArrayBruteForce(int[] arr){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int n = arr.length;
		for(int i = 0; i < n; i++){
			if(arr[i] != 0){
				temp.add(arr[i]);
			}
		}
		for(int i = 0; i < temp.size(); i++){
			arr[i] = temp.get(i);
		}
		for(int i = temp.size(); i < n; i++){
			arr[i] = 0;
		}
		return arr;
	}

	int[] moveZerosToTheEndOfTheArrayOptimal(int[] arr){
		int j = -1, temp;
		int n = arr.length;
		for(int i = 0; i < n; i++){
			if(arr[i] == 0){
				j = i;
				break;
			}
		}
		if(j == -1) return arr;
		for(int i = j+1; i < n; i++){
			if(arr[i] != 0){
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return arr;
	}

	public static void main(String[] args){

		ArraysEasy obj = new ArraysEasy();
		int[] nums = {1,2,3,3,4,5,6,1};
		obj.moveZerosToTheEndOfTheArrayOptimal(nums);
		System.out.println(Arrays.toString(nums));
	}
}