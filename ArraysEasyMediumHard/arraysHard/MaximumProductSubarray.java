public class MaximumProductSubarray{
	
	// brute force solution

	int maximumProductSubarrayBrute(int[] arr){
		int n = arr.length;
		int maxi = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			int product = 1;
			for(int j = i; j<n; j++){
				product *= arr[j];
				maxi = Integer.max(product, maxi);
			}
		}
		return maxi;
	}

	// Optimal solution

	int maximumProductSubarrayOptimal(int[] arr){
		int n = arr.length;
		int maxi = Integer.MIN_VALUE;

		int prefix = 1;
		int suffix = 1;

		for(int i=0; i<n; i++){
			if(prefix == 0) prefix = 1;
			if(suffix == 0) suffix = 1;

			prefix *= arr[i];
			suffix *= arr[n-i-1];

			maxi = Integer.max(maxi, Integer.max(prefix, suffix));
		}
		return maxi;
	}
}