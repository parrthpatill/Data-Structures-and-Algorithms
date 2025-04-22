import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

import java.util.*;


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

// union of two sorted arrays:

	int[] unionOfSortedArraysBruteForce(int[] arr1, int[] arr2){
		int n1 = arr1.length;
		int n2 = arr2.length;
		Set<Integer> s = new TreeSet<>();
		for(int i = 0; i < n1; i++){
			s.add(arr1[i]);
		}
		for(int i = 0; i < n2; i++){
			s.add(arr2[i]);
		}
		int i = 0;
		int[] arr = new int[s.size()];
		Iterator<Integer> itr = s.iterator();
		while(itr.hasNext()){
			arr[i++] = itr.next();
		}
		return arr;
	}

	ArrayList<Integer> unionOfSortedArraysOptimal(int[] arr1, int[] arr2){
		int n1 = arr1.length;
		int n2 = arr2.length;
		ArrayList<Integer> unionArr = new ArrayList<Integer>();
		int i = 0, j = 0;
		while(i < n1 && j < n2){
			if(arr1[i] <= arr2[j]){
				if(unionArr.size() == 0 ||
				unionArr.get(unionArr.size() - 1) != arr1[i]){
					unionArr.add(arr1[i]);
				}
				i++;
			} else{
				if(unionArr.size() == 0 ||
				unionArr.get(unionArr.size() - 1) != arr2[j]){
					unionArr.add(arr2[j]);
				}
				j++;
			}
		}
		while(i < n1){
			if(unionArr.size() == 0 ||
				unionArr.get(unionArr.size() - 1) != arr1[i]){
					unionArr.add(arr1[i]);
				}
				i++;
		}
		while(j < n2){
			if(unionArr.size() == 0 ||
				unionArr.get(unionArr.size() - 1) != arr2[j]){
					unionArr.add(arr2[j]);
				}
				j++;
		}
		return unionArr;
	}

// intersection of two sorted arrays:
	ArrayList<Integer> intersectionOfSortedArraysBruteForce(int[] arr1, int[] arr2){
		int n1 = arr1.length;
		int n2 = arr2.length;
		ArrayList<Integer> ansArr = new ArrayList<Integer>();
		int[] vis = new int[n2];
		for(int i = 0; i < n2; i++){
			vis[i] = 0;
		}
		for(int i = 0; i < n1; i++){
			for(int j = 0;  j < n2; j++){
				if(arr1[i] == arr2[j] && vis[j] == 0){
					ansArr.add(arr1[i]);
					vis[j] = 1;
					break;
				}
				if(arr2[j] > arr1[i]) break;
			}
		}
		return ansArr;
	}

	ArrayList<Integer> intersectionOfSortedArraysOptimal(int[] arr1, int[] arr2){
		int n1 = arr1.length;
		int n2 = arr2.length;
		int i = 0, j = 0;
		ArrayList<Integer> ansArr = new ArrayList<Integer>();
		while(i <n1 && j <n2){
			if(arr1[i] < arr2[j]){
			i++;
		}else if(arr1[j] < arr1[i]){
			j++;
		}else{
			ansArr.add(arr1[i]);
			i++;
			j++;
		}
		}
		return ansArr;
	}

// single Element In Doubles Optimal
	int missingNumberBruteForce(int[] arr, int n){
		for(int i = 1; i <= n; i++){
			int flag = 0;
			for(int j = 0; j < n-2; j++){
				if(arr[j] == i){
					flag++;
					break;
				}
			}
			if(flag == 0){
				return i;
			}
		}
		return -1;
	}

	int missingNumberBetter(int[] arr, int n){
		int[] hash = new int[n+1];
		Arrays.fill(hash, 0);
		for(int i = 0; i <= n-2; i++){
			hash[arr[i]]++;
		}
		for(int i = 1; i <= n; i++){
			if(hash[i] == 0){
				return i;
			}
		}
		return -1;
	}

	int missingNumberOptimalSum(int[] arr, int n){
		int sum =0;
		for(int i = 0; i < n-1; i++){
			sum += arr[i];
		}
		return n*(n-1)/2 -sum;
	}

	int missingNumberOptimalXOR(int[] arr, int n){
		int xor1 = 0;
		int xor2 = 0;
		for(int i = 0; i< n-1; i++){
			xor1 = xor1^arr[i];
			xor2 = xor2^(i+1);
		}
		xor2 = xor2^n;
		return xor1^xor2;
	}

// maximum consecutive ones
	int maximumConsecutiveOnes(int[] arr){
		int count = 0;
		int maximum = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1){
				count++;
				maximum = Integer.max(maximum, count);
			} else{
				count = 0;
			}
		}
		return maximum;
	}

// element that appears once among doubles
	int singleElementInDoublesBruteForce(int[] arr){
		int n = arr.length;
		int num, count;
		for(int i = 0; i < n; i++){
			num = arr[i];
			count = 0;
			for(int j = 0; j < n; j++){
				if(arr[j] == num){
					count++;
				}
			}
			if(count == 1) return arr[i];
		}
		return -1;
	}

	int singleElementInDoublesOptimal(int[] arr){
		int xor = 0;
		for(int i = 0; i < arr.length; i++){
			xor = xor^arr[i];
		}
		return xor;
	}

// Longest subarray with given sum K(positives)

	int lengthOfLongestSubarrayWithSumKBruteForce(int[] arr, int k){
		int n = arr.length;
		int maxLen = 0;
		for(int i = 0; i < n; i++){
			int sum = 0;
			for(int j = i; j < n; j++){
				sum += arr[j];
				if(sum == k){
					maxLen = Integer.max(maxLen, j-i+1);
				}
			}
		}
		if(maxLen == 0) return -1;
		return maxLen;
	}

	int lengthOfLongestSubarrayWithSumKOptimal(int[] arr, int k){
		int n = arr.length;
		int maxLen = 0;
		int left = 0;
		int right = 0;
		int sum = arr[0];
		while(right < n){

			while(left < n && sum > k){
				sum -= arr[left];
				left++;
			}
			if(sum == k){
				maxLen = Integer.max(maxLen, right - left +1);
			}
			right++;
			if(right < n) sum += arr[right];
		}
		return maxLen;
	}

// Longest subarray with sum K (Positives + Negatives)
	int longestSubarrayWithSumKPositivesAndNegatives(int[] arr, int k){
		long preSum = 0;
		int maxLen = 0;
		Map<Long, Integer> sumMap = new HashMap<Long, Integer>();

		for(int i = 0; i < arr.length; i++){
			preSum += arr[i];

			if(preSum == k){
				maxLen = Integer.max(maxLen, i + 1);
			}

			long rem = preSum - k;
			if(sumMap.containsKey(rem)){
				maxLen = Integer.max(maxLen, i - sumMap.get(rem));
			}
			if(!sumMap.containsKey(preSum)){
				sumMap.put(preSum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args){

		ArraysEasy obj = new ArraysEasy();
		int[] arr1 = {1,2,3,1,1,1};
		int[] arr2 = {1,2,3,3,4,6,7,8,9,100};
		// ArrayList<Integer> ans =  new ArrayList<Integer>();
		int maxOnes = obj.longestSubarrayWithSumKPositivesAndNegatives(arr1, 3);
		System.out.println(maxOnes);
	}
}