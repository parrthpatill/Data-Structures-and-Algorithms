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

	List<Integer> repeatingAndMissingOptimal1(int[] arr){
		List<Integer> ans = new ArrayList<>();
		// s - sn = x-y
		// s2 - sn2 = (x+y)(x-y)
		long n = (long)arr.length;
		long sn = (n*(n+1))/2;
		long sn2 = (n*(n+1)*(2*n+1))/6;
		long s = 0;
		long s2 = 0;
		for(int i=0; i<n; i++){
			s += (long)arr[i];
			s2 += (long)arr[i] * (long)arr[i];
		}
		//x-y
		long eq1 = s - sn;
		//x+y
		long eq2 = (s2 - sn2)/eq1;

		long x = (eq1 + eq2)/2;
		long y = x - eq1;

		ans.add((int)x);
		ans.add((int)y);
		return ans;
	}

	List<Integer> repeatingAndMissingOptimal2(int[] arr){
		int n = arr.length;
		int xor = 0;
		for(int i=0; i<n; i++){
			xor = xor ^ arr[i];
			xor = xor ^ (i+1);
		}
		int bitNo = 0;
		while(true){
			if((xor & 1<<bitNo) != 0){
				break;
			}
			bitNo++;
		}
		int zero = 0;
		int one = 0;
		for(int i=0; i<n; i++){
			if((arr[i] & 1<<bitNo) != 0){
				one = one ^ arr[i];
			} else {
				zero = zero ^ arr[i];
			}
		}
		for(int i=0; i<n; i++){
			if((i+1 & 1<<bitNo) != 0){
				one = one ^ (i+1);
			} else {
				zero = zero ^ (i+1);
			}
		}
		int cnt = 0;
		for(int i =0; i<n; i++){
			if(arr[i] == one){
				cnt++;
			}
		}
		List<Integer> ans = new ArrayList<>();
		if(cnt == 2){
			ans.add(one);
			ans.add(zero);
		} else {
			ans.add(zero);
			ans.add(one);
		}
		return ans;
	}
}