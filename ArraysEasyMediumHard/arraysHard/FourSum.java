import java.util.*;

public class FourSum{
	
	List<List<Integer>> getFourSumBrute(int[] arr, int target){
		int n = arr.length;
		Set<List<Integer>> set = new HashSet<>();
		for(int i=0; i<n; i++){
			for(int j = i+1; j<n; j++){
				for(int k = j+1; k<n; k++){
					for(int l = k+1; l<n; l++){
						// initialising sum like this so as to now pass the integer limit 
						// which will cause the type casting to fail
						long sum = arr[i]+arr[j];
						sum += arr[k];
						sum += arr[l];
						if(sum == target){
							List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
							Collections.sort(quad);
							set.add(quad);
						}
					}
				}
			}
		}
		List<List<Integer>> ans = new ArrayList<>(set);
		return ans;
	}
}