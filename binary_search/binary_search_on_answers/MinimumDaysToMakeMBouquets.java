public class MinimumDaysToMakeMBouquets{
	//Brute force Solution

	int minimumDaysToMakeMBouquetsBrute(int[] arr, int m, int k){
		//m = no of bouquets
		//k = adj bouquets required
		int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
		int n = arr.length;
		for(int i = 0; i<n; i++){
			maxi = Integer.max(arr[i], maxi);
			mini = Integer.min(arr[i], mini);
		}
		int cnt = 0;
		int bouquets = 0;
		for(int i = mini; i<=maxi; i++){
			for(int j = 0; j<n; j++){
				if(arr[j] <= i){
					cnt++;
				} else {
					bouquets = cnt/k;
					cnt = 0;
				}
			}
			bouquets += cnt/k;
			if(bouquets >= m) return i;
		}
		return -1;
	}

	// Optimal solution
	int bouquetCnt(int[] arr, int n, int mid, int k){
		int totalCnt = 0, cnt = 0;
		for(int i = 0; i<n; i++){
			if(arr[i] <= mid){
				cnt++;
			} else {
				totalCnt += cnt/k;
				cnt = 0;
			}
		}
		totalCnt += cnt/k;
		return totalCnt;
	}
	int minimumDaysToMakeMBouquetsOptimal(int[] arr, int m, int k){
		int n = arr.length;
		int high = Integer.MIN_VALUE, low = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++){
			low = Integer.min(arr[i], low);
			high = Integer.max(arr[i], high);
		}
		while(low <= high){
			int mid = (low + high)/2;
			int cnt = bouquetCnt(arr, n, mid, k);
			if(cnt >= m){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;

	}
}