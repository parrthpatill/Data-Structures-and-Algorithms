public class CapacityToShipPackagesWithinDDays {
	//Brute force solution
	int capacityToShipPackagesWithinDDaysBrute(int[] arr, int days){
		int totalWt = 0;
		int maxWt = -1;
		int n = arr.length;
		for(int i = 0; i<n; i++){
			maxWt = Integer.max(arr[i], maxWt);
			totalWt += arr[i];
		}
		for(int i = maxWt; i<=totalWt; i++){
			int daysReq = 1, load = arr[0];
			for(int j = 1; j<n; j++){
				if((load + arr[j]) <= i){
					load += arr[j];
				} else {
					daysReq++;
					load = arr[j];
				}
			}
			if(daysReq <= days) return i;
		}
		return -1;
	}

	//Optimal solution
	int dayCnt(int[] arr, int n, int mid){
		int daysReq = 1, load = arr[0];
			for(int j = 1; j<n; j++){
				if((load + arr[j]) <= mid){
					load += arr[j];
				} else {
					daysReq++;
					load = arr[j];
				}
			}
		return daysReq;
	}
	int capacityToShipPackagesWithinDDaysOptimal(int[] arr, int days){
		int n = arr.length;
		int low = Integer.MIN_VALUE, high = 0;
		for(int i = 0; i<n; i++){
			low = Integer.max(arr[i], low);
			high += arr[i];
		}
		while(low <= high){
			int mid = (low + high)/2;
			int daysReq = dayCnt(arr, n, mid);
			if(daysReq <= days){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}