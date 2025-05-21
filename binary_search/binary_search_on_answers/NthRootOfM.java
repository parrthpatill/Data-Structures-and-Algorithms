public class NthRootOfM{
	int func(int i, int n){
		int prod = 1;
		for(int j = 1; j<=n; j++){
			prod = prod * i;
		}
		return prod;
	}
	// brute force solution
	int nthRootOfMBrute(int n, int m){
		for(int i=1; i<=m; i++){
			int prod = func(i, n);
			if(prod == m) return i;
			else if(prod > m) break;
		}
		return -1;
	}

	//optimal solution
	int nthRootOfMOptimal(int n, int m){
		int low = 1;
		int high = m;
		while(low <= high){
			int mid = (low+high)/2;
			int prod = func(mid, n);

			if(prod == m) return mid;

			else if(prod < m) low = mid + 1;
			
			else high = mid - 1;
		}
		return -1;
	}
}