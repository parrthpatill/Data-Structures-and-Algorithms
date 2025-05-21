public class Sqrt{
	//brute force
	int sqrtOfIntegerBrute(int n){
		for(int i = 1; i<=n; i++){
			if(i*i == n) return i;
			else if(i*i > n) return i-1;
		}
		return -1;
	}

	// Optimal Solution
	int sqrtOfIntegerOptimal(int n){
		long low = 1;
		long high = n;

		while(low <= high){
			long mid = (low + high)/2;
			if((mid*mid) > n){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return (int)high;
	}
}