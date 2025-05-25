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
}