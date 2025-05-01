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

// Maximum subarray sum (Kadane's Algorithm)
	int maximumSubarraySumBetter(int arr[]){
		int n=arr.length;
		int maximum=Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			int sum=0;
			for(int j=i; j<n; j++){
				sum+=arr[j];
				maximum = Integer.max(maximum,sum);
			}
		}
		return maximum;
	}
	//Kadane's Algorithm
	int maximumSubarraySumOptimal(int[] arr){
		int maximum=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0; i<arr.length; i++){
			sum+=arr[i];
			if(sum>maximum){
				maximum=sum;
			}
			if(sum<0){
				sum=0;
			}
		}
		return maximum;
	}
	//Printing the subarrays
	ArrayList<Integer> printingMaximumSubarraySum(int[] arr){
		ArrayList<Integer> maxSumArray = new ArrayList<Integer>();
		int maximum=Integer.MIN_VALUE;
		int sum=0;
		int start=0;
		int ansStart =0, ansEnd=0;
		for(int i=0; i<arr.length; i++){
			if(sum==0){
				start = i;
			}
			sum+=arr[i];
			if(sum>maximum){
				maximum=sum;
				ansStart=start;
				ansEnd=i;
			}
			if(sum<0){
				sum=0;
			}
		}
		for(int i=ansStart; i<=ansEnd; i++){
			maxSumArray.add(arr[i]);
		}
		return maxSumArray;
	}

// Buy and sell stocks
	int buyAndSellStocks(int[] arr){
		int minimum = arr[0];
		int profit = 0;
		int maxProfit = 0;
		for(int i=1; i<arr.length; i++){
			profit = arr[i]-minimum;
			maxProfit = Integer.max(maxProfit, profit);
			minimum = Integer.min(minimum, arr[i]);
		}
		return maxProfit;
	}

//Rearrange the array in alternating positive and negative items
	void posAndNegBruteForce(int[] arr){
		int n=arr.length;
		ArrayList<Integer> pos = new ArrayList<>(n/2);
		ArrayList<Integer> neg = new ArrayList<>(n/2);
		for(int i=0; i<n; i++){
			if(arr[i] < 0){
				neg.add(arr[i]);
			} else{
				pos.add(arr[i]);
			}
		}
		for(int i=0; i<n/2; i++){
			arr[i*2] = pos.get(i);
			arr[i*2+1] = neg.get(i);
		}

	}
	int[] posAndNegOptimal(int[] arr){
		int n = arr.length;
		int[] ans = new int[n];
		int pos = 0;
		int neg = 1;
		for(int i = 0; i<n; i++){
			if(arr[i]<0){
				ans[neg]=arr[i];
				neg+=2;
			} else{
				ans[pos]=arr[i];
				pos+=2;
			}
		}
		return ans;
	}
	// variety2: when number of pos and negs aren't equal

	int[] posAndNegUnequal(int[] arr){
		int n = arr.length;
		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();
		for(int i=0; i<n; i++){
			if(arr[i]<0){
				neg.add(arr[i]);
			} else{
				pos.add(arr[i]);
			}
		}
		int posSize=pos.size(), negSize=neg.size();
		if(posSize>negSize){
			for(int i=0; i<negSize; i++){
				arr[i*2]=pos.get(i);
				arr[i*2+1]=neg.get(i);
			}
			int index=negSize*2;
			for(int i=negSize; i<posSize; i++){
				arr[index] = pos.get(i);
				index++;
			}
		} else{
			for(int i=0; i<posSize; i++){
				arr[i*2]=pos.get(i);
				arr[i*2+1]=neg.get(i);
			}
			int index=posSize*2;
			for(int i=posSize; i<negSize; i++){
				arr[index] = neg.get(i);
				index++;
			}
		}
		return arr;
	}

	public static void main(String[] args){
		ArraysMedium obj = new ArraysMedium();
		int[] arr1 = {1,2,3,-1,-4,-6,2,3,4,5,2,5,-9,-4};
		int[] ans = obj.posAndNegUnequal(arr1);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");	
		}
		
	}
}