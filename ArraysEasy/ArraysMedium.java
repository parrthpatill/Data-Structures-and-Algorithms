import java.util.*;

class ArraysMedium{

// 2Sum Problem
	boolean twoSumBruteForce(int[] arr, int target) {
		int n = arr.length;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(arr[i] + arr[j] == target){
					return true;
				}
			}
		}
		return false;
	}

	boolean twoSumBetter(int[] arr, int target){
		int req;
		Map<Integer, Integer> elementMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			req = target - arr[i];
			if(elementMap.containsKey(req)){
				return true;
			}
			elementMap.put(arr[i], i);
		}
		return false;
	}
	boolean twoSumOptimal(int[] arr, int target){
		int left = 0;
		int right = arr.length -1;
		int sum = 0;
		while(left < right){
			sum = arr[left] + arr[right];
			if(sum == target){
				return true;
			}
			if(sum > target){
				right--;
			} else {
				left++; 
			}
		}
		return false;

	}
// Sort an array of 0s, 1s, 2s
	void sort012Better(int[] arr){
		int countZero=0, countOne=0;
		int n = arr.length;
		for(int i=0; i<n; i++){
			if(arr[i] == 0) countZero++;
			if(arr[i] == 1) countOne++;
		}
		for(int i=0; i<countZero; i++){
			arr[i]=0;
		}
		for(int i=countZero; i<countZero+countOne; i++){
			arr[i]=1;
		}
		for(int i=countZero+countOne; i<n; i++){
			arr[i]=2;
		}
	}
	void swap(int[] arr, int x, int y){
		int temp = arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	void sort012Optimal(int[] arr){
		int low=0, high=arr.length-1, mid=0;
		while(mid<=high){
			if(arr[mid]==0){
				swap(arr, mid, low);
				low++;
				mid++;
			} else if(arr[mid]==1){
				mid++;
			} else{
				swap(arr, mid, high);
				high--;
			}
		}
	}

// Majority Element
	int majorityElementBruteForce(int[] arr){
		int n=arr.length;
		for(int i =0; i<n; i++){
			int cnt =0;
			for(int j=0; j<n; j++){
				if(arr[j]==arr[i]){
					cnt++;
				}
			}
			if(cnt>n/2) return arr[i];
		}
		return -1;
	}

	int majorityElementBetterSolution(int[] arr){
		int n = arr.length;
		HashMap<Integer, Integer> mpp = new HashMap<>();
		for(int i=0; i<n; i++){
			int value = mpp.getOrDefault(arr[i], 0);
			mpp.put(arr[i], value+1);
		}
		for(Map.Entry<Integer,Integer> it : mpp.entrySet()){
			if(it.getValue() > n/2){
				return it.getKey();
			}
		}
		return -1;
	}

	int majorityElementOptimal(int[] arr){
		//Moore'a voting algorithm
		int n = arr.length;
		int el = 0;
		int cnt = 0;
		for(int i=0; i<n; i++){
			if(cnt == 0){
				el = arr[i];
				cnt++;
			} else if(arr[i] == el){
				cnt++;
			} else{
				cnt--;
			}
		}
		int elCnt=0;
		for(int i=0; i<n; i++){
			if(arr[i]==el){
				elCnt++;
			}
			if(elCnt>n/2) return arr[i];
		}
		return -1;
	}

	public static void main(String[] args){
		ArraysMedium obj = new ArraysMedium();
		int[] arr1 = {1,2,2,2,2,2,3,3,1,1,1,1};
		System.out.println(obj.majorityElementOptimal(arr1));
		// for(int i=0; i<arr1.length; i++){
		// 	System.out.print(arr1[i]+" ");	
		// }
		
	}
}