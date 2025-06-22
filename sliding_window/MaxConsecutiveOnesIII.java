public class MaxConsecutiveOnesIII{
	//brute force solution
	int maxConsecutiveOnesIIIBrute(int[] arr, int k){
		int n = arr.length, maxLen = 0;
		for(int i = 0; i<n; i++){
			int zeroCnt = 0;
			for(int j = i; j < n; j++){
				if(arr[j] == 0) zeroCnt++;
				if(zeroCnt > k) break;
				maxLen = Integer.max(maxLen, j-i+1);
			}
		}
		return maxLen;
	}

	//optimal solution
	int maxConsecutiveOnesIIIOptimal(int[] arr, int k){
		int l = 0, r = 0, maxLen = 0, zeroCnt = 0;
		while(r < arr.length){
			if(arr[r] == 0) zeroCnt++;
			if(zeroCnt > k){
				if(arr[l] == 0) zeroCnt--;
				l++;
			}
			maxLen = Integer.max(maxLen, r-l+1);
			r++;
		}
		return maxLen;
	}
}