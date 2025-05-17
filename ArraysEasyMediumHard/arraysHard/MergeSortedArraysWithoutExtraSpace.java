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

	// Optimal Solution 2 using Gap Method from Shell Sort
	private void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2){
		if(arr1[ind1] > arr2[ind2]){
			int temp = arr1[ind1];
			arr1[ind1] = arr2[ind2];
			arr2[ind2] = temp;	
		}
		
	}

	List<int[]> mergeSortedArraysOptimal2(int[] arr1, int[] arr2){
		int n = arr1.length;
		int m = arr2.length;
		int len = m+n;
		int gap = (len/2) + (len%2);
		while(gap > 0){
			int l = 0;
			int r = l + gap;
			while(r < len){
				// l in arr1 and r in arr2
				if(l < n && r >= n){
					swapIfGreater(arr1, arr2, l, r-n);
				}
				// both in arr2
				else if(l >= n){
					swapIfGreater(arr2, arr2, l-n, r-n);
					
				}
				else{
					swapIfGreater(arr1, arr1, l, r);
				}
				l++;
				r++;
			}
			if(gap == 1) break;
			gap = (gap/2) + (gap%2);
		}
		List<int[]> ans = new ArrayList<>();
		ans.add(arr1);
		ans.add(arr2);

		return ans;
	}
}