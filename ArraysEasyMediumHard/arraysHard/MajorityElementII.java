import java.util.*;

// finding all elements appearing more than n/3 times
public class MajorityElementII{
	// brute force approach
	List<Integer> getMajorityElementIIBruteForce(int[] arr){
		int n=arr.length;
		List<Integer> ans = new ArrayList<>();
		for(int i=0; i<n; i++){
			if(ans.isEmpty() || ans.get(0)!=arr[i]){
				int cnt = 0;
				for(int j=0; j<n; j++){
					if(arr[i]==arr[j]){
						cnt+=1;
					}
				}
				if(cnt>n/3){
					ans.add(arr[i]);
				}
			}
			if(ans.size()==2) break;
		}
		return ans;
	}
}