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
}