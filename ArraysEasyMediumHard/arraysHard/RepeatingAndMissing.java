import java.util.*;

public class RepeatingAndMissing{
	//brute force solution
	List<Integer> repeatingAndMissingBrute(int[] arr){
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		int repeating = -1;
		int missing = -1;

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
			if(repeating !=-1 && missing != -1){
				break;
			}
		}
		return ans;
	}

	//Better solution using hash array
	List<Integer> repeatingAndMissingBetter(int[] arr){
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		int[] hash = new int[n+1];
		for(int i = 0; i<n; i++){
			hash[arr[i]] += 1;
		}
		for(int i = 1; i<n; i++){
			if(hash[i] == 2){
				ans.add(i);
			}
			else if(hash[i] == 0){
				ans.add(i);
			}
			if(ans.size() == 2) break;
		}
		return ans;
	}
}