import java.util.*;

public class LargestSubArrayWithSumZero{
	//brute force solution
	int largestSubArrayWithSumZeroBrute(int[] arr){
		int n = arr.length;
		int max = -1;
		for(int i=0; i<n; i++){
			int sum = 0;
			for(int j=i; j<n; j++){
				sum+=arr[j];

				if(sum == 0){
					max = Integer.max(max,(j-i)+1);
				}
			}
		}
		return max;
	}

	//Optimal solution using prefixSum and hashing

	int largestSubArrayWithSumZeroOptimal(int[] arr){
		int n = arr.length;
		// for storing the presums and indices
		Map<Integer, Integer> preSumMap = new HashMap<>();
		int max = -1;
		int preSum = 0;
		for(int i = 0; i<n; i++){
			// incrementing the presum
			preSum+=arr[i];

			if(!preSumMap.containsKey(preSum)){
				preSumMap.put(preSum, i);
			} else{
				max = Integer.max(max, i - preSumMap.get(preSum));
			}
		}
		return max;

	}
}