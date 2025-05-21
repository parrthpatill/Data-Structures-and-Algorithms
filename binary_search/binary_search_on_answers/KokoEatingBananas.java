import java.lang.Math;

public class KokoEatingBananas{

	// Finding the max element for figuring out max value of K
	int maxElement(int[] arr, int n){
		int maxi = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			maxi = Integer.max(maxi, arr[i]);
		}
		return maxi;
	}

	// Calculating time required
	int timeTaken(int[] arr, int n, int k){
		int time = 0;
		for(int i = 0; i<n; i++){
			time += Math.ceil((double)arr[i]/(double)k);
		}
		return time;
	}

	//Brute force solution
	int kokoEatingBananasBrute(int[] piles, int h){
		int n = piles.length;
		int maxEl = maxElement(piles, n);
		for(int k = 1; k<=maxEl; k++){
			int time = timeTaken(piles, n, k);
			if(time <= h) return k;
		}
		return -1;
	}

	int kokoEatingBananasOptimal(int[] piles, int h){
		int n = piles.length;
		int low = 1;
		int high = maxElement(piles, n);

		while(low <= high){
			int mid = (low+high)/2;
			int time = timeTaken(piles, n, mid);
			if(time > h){
				low = mid + 1;
			} else{
				high = mid - 1;
			}
		}
		return low;
	}
}