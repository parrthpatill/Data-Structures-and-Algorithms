import java.util.*;

public class MergeSortedArraysWithoutExtraSpace{
	// Brute force solution using O(m+n) extra space
	List<int[]> mergeSortedArraysBrute(int[] arr1, int[] arr2){
		int n = arr1.length;
		int m = arr2.length;
		int[] arr3 = new int[m+n];
		int l = 0, r = 0;
		int index = 0;
		while(l < n && r < m){
			if(arr1[l] <= arr2[r]){
				arr3[index] = arr1[l];
				l++;
				index++;
			} else {
				arr3[index] = arr2[r];
				r++;
				index++;
			}
		}
		while(l < n){
			arr3[index++] = arr1[l++];
		}
		while(r < m){
			arr3[index++] = arr2[r++];
		}

		for(int i = 0; i<n+m; i++){
			if(i < n) arr1[i] = arr3[i];
			else arr2[i-n] = arr3[i];
		}

		List<int[]> ans = new ArrayList<>();
		ans.add(arr1);
		ans.add(arr2);

		return ans;
	}

	// Optimal Solution 1
	List<int[]> mergeSortedArraysOptimal1(int[] arr1, int[] arr2){
		int n = arr1.length;
		int m = arr2.length;
		int l = n-1;
		int r = 0;

		while(l >= 0 && r < m){
			if(arr1[l] > arr2[r]){
				int temp = arr1[l];
				arr1[l] = arr2[r];
				arr2[r] = temp;
				l--;
				r++;
			} else {
				break;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		List<int[]> ans = new ArrayList<>();
		ans.add(arr1);
		ans.add(arr2);

		return ans;
	}
}