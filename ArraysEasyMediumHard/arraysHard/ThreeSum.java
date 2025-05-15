import java.util.*;

public class ThreeSum{
	List<List<Integer>> threeSumBrute(int[] arr){
		Set<List<Integer>> set = new HashSet<>(); 
		int n = arr.length;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int k=j+1; k<n; k++){
					if(arr[i]+arr[j]+arr[k] == 0){
						List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
						Collections.sort(temp);
						set.add(temp);
					}
				}
			}
		}
		List<List<Integer>> ans = new ArrayList<>(set);
		return ans;
	}

	// Better solution using only two loops and hashset
	List<List<Integer>> threeSumBetter(int[] arr){
		int n = arr.length;
		// for storing the triplets
		Set<List<Integer>> set = new HashSet<>();
		for(int i = 0; i<n; i++){
			Set<Integer> hashset = new HashSet<>();
			for(int j = i+1; j<n; j++){
				// initialising the third element to find
				int third = -(arr[i]+arr[j]);

				if(hashset.contains(third)){
					List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
					temp.sort(null);
					set.add(temp);
				}

				// storing the possible thirds
				hashset.add(arr[j]);
			}
		}
		List<List<Integer>> ans = new ArrayList<>(set);
		return ans;
	}

	// Optimal solution
	List<List<Integer>> threeSumOptimal(int[] arr){
		Arrays.sort(arr);
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<>();
		for(int i = 0; i<n; i++){
			// moving the i to the next unique element
			if(i>0 && arr[i] == arr[i-1]){
				continue;
			}

			int j = i+1;
			int k = n-1;

			while(j<k){
				int sum = arr[i]+arr[j]+arr[k];
				if(sum > 0){
					k--;
				}
				else if(sum < 0){
					j++;
				}
				else{
					List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
					ans.add(triplet);
					j++;
					k--;
					while(j<k && arr[j] == arr[j-1]){
						j++;
					}
					while(j<k && arr[k] == arr[k+1]){
						k--;
					}
				}
			}

		}
		return ans;
	}

}