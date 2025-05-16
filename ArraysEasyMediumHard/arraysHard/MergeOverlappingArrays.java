import java.util.*;

public class MergeOverlappingArrays{

	// brute force solution
	List<List<Integer>> mergeOverlappingArrays(int[][] arr){
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
}