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

	// Better approach(using HashMap)
	List<Integer> getMajorityElementIIBetter(int[] arr){
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> mpp = new HashMap<>();
		for(int i=0; i<n; i++){
			int value = mpp.getOrDefault(arr[i], 0);
			mpp.put(arr[i], value+1);

			if(mpp.get(arr[i]) == n/3 +1){
				ans.add(arr[i]);
			}

			if(ans.size() == 2) break;
		}
		return ans;
	}

	// Optimal approach derived using moore's voting algorithm
	List<Integer> getMajorityElementIIOptimal(int[] arr){
		int n = arr.length;
		int el1=Integer.MIN_VALUE, cnt1=0, el2=Integer.MIN_VALUE, cnt2=0;
		for(int i = 0; i<n; i++){
			if(cnt1==0 && el2!=arr[i]){
				cnt1=1;
				el1=arr[i];
			} else if(cnt2==0 && el1!=arr[i]){
				cnt2=1;
				el2=arr[i];
			} else if(el1==arr[i]){
				cnt1++;
			} else if(el2==arr[i]){
				cnt2++;
			} else{
				cnt1--;
				cnt2--;
			}
		}
		List<Integer> ans = new ArrayList<>();
		int el1Cnt=0, el2Cnt=0;
		for(int i = 0; i<n; i++){
			if(arr[i] == el1) el1Cnt++;
			if(arr[i] == el2) el2Cnt++;
		}
		if(el1Cnt > n/3) ans.add(el1);
		if(el2Cnt > n/3) ans.add(el2);

		return ans;
	}
}