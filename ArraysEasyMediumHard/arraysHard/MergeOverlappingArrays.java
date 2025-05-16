import java.util.*;

public class MergeOverlappingArrays{

	// brute force solution
	List<List<Integer>> mergeOverlappingArraysBrute(int[][] arr){
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr, (a,b) -> a[0]-b[0]);
		for(int i = 0; i<n; i++){
			int start = arr[i][0];
			int end = arr[i][1];
			if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
				continue;
			}

			for(int j=i+1; j<n; j++){
				if(arr[j][0] <= arr[i][1]){
					end = Integer.max(end, arr[j][1]);
				} else {
					break;
				}
			}

			ans.add(Arrays.asList(start, end));
		}
		return ans;
	}

	// Optimal Solution
	List<List<Integer>> mergeOverlappingArraysOptimal(int[][] arr){
		Arrays.sort(arr, (a,b) -> a[0] - b[0]);
		List<List<Integer>> ans = new ArrayList<>();

		for(int i=0; i<arr.length; i++){
			if(ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)){
				ans.add(Arrays.asList(arr[i][0], arr[i][1]));
			} else {
				ans.get(ans.size()-1).set(1,Integer.max(ans.get(ans.size()-1).get(1), arr[i][1]));
			}
		}
		return ans;
	}

}