import java.util.*;

public class RepeatingAndMissing{
	//brute force solution
	List<Integer> repeatingAndMissing(int[] arr){
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		int repeating = Integer.MIN_VALUE;
		int missing = Integer.MIN_VALUE;

		for(int i = 1; i<=n; i++){
			int cnt = 0;
			for(int j = 0; j<n; j++){
				if(arr[j] == i){
					cnt++;
				}
			}
			if(cnt == 2){
				ans.add(repeating = i);
			} else if(cnt == 0){
				ans.add(missing = i);
			}
			if(repeating!=Integer.MIN_VALUE && missing != Integer.MIN_VALUE){
				break;
			}
		}
		return ans;
	}
}