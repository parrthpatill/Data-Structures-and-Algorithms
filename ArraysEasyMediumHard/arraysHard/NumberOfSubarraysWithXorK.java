import java.util.*;

public class NumberOfSubarraysWithXorK{
	//brute force solution
	int numberOfSubarraysWithXorKBetter(int[] arr, int k){
		int n = arr.length;
		int cnt=0;
		for(int i=0; i<n; i++){
			int xor = 0;
			for(int j = i; j<n; j++){
				xor = xor^arr[j];
				if(xor == k){
					cnt++;
				}
			}
		}
		return cnt;
	}

	//optimal solution
	int numberOfSubarraysWithXorKOptimal(int[] arr, int k){
		int xr = 0;
		// key = xor, value = no. of occurrences
		Map<Integer, Integer> frontXorMap = new HashMap<>();
		frontXorMap.put(0,1);
		int cnt = 0;
		for(int i=0; i<arr.length; i++){
			xr = xr^arr[i];
			int x = xr^k;
			if(frontXorMap.containsKey(x)){
				cnt += frontXorMap.get(x);
			}
			frontXorMap.put(xr, frontXorMap.getOrDefault(xr,0)+1);
			
		}
		return cnt;
	}
}