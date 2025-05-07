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

// Next Permutation in place
	void reverse(int[] arr, int start, int end){
		while(end>=start){
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	int[] nextPermutation(int[] arr){
		int n = arr.length;
		int reqInd = -1;
		for(int i=n-2; i>=0; i--){
			if(arr[i+1]>arr[i]){
				reqInd = i;
				break;
			}
		}
		if(reqInd == -1){
			reverse(arr, 0, n-1);
			return arr;
		}
		for(int i = n-1; i>=reqInd; i--){
			if(arr[i]>arr[reqInd]){
				int temp = arr[i];
				arr[i]=arr[reqInd];
				arr[reqInd]=temp;
				break;
			}
		}
		reverse(arr, reqInd+1, n-1);
		return arr;
	}

// Leaders In An Array
	ArrayList<Integer> leadersInAnArrayBrute(int[] arr){
		int n = arr.length;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<n; i++){
			boolean leader = true;
			for(int j=i+1; j<n; j++){
				if(arr[j]>arr[i]){
					leader = false;
					break;
				}
			}
			if(leader==true){
				ans.add(arr[i]);
			}
		}
		return ans;
	}

	ArrayList<Integer> leadersInAnArrayOptimal(int[] arr){
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=n-1; i>=0; i--){
			if(arr[i]>=max){
				ans.add(arr[i]);
				max = arr[i];
			}
		}
		int left = 0, right = ans.size()-1;
		while(left<=right){
			int temp = ans.get(left);
			ans.set(left, ans.get(right));
			ans.set(right, temp);
			left++;
			right--;
		}
		return ans;
	}

// LONGEST CONSEQUTIVE SUBSEQUENCE

	boolean linearSearch(int[] arr, int searchElement){
		for(int i=0; i<arr.length; i++){
			if(arr[i] == searchElement){
				return true;
			}
		}
		return false;
	}
	int longestConsequtiveSubsequenceBrute(int[] arr){
		int n=arr.length;
		int longest = 0;
		for(int i=0; i<n; i++){
			int count = 1;
			int x = arr[i]+1;
			while(linearSearch(arr, x)){
				count += 1;
				x += 1;
			}
			longest=Integer.max(count, longest);
		}
		return longest;
	}

	int longestConsequtiveSubsequenceBetter(int[] arr){
		int n = arr.length;
		int currentCount=0;
		int longest = 1;
		int lastSmallest = Integer.MIN_VALUE;
		Arrays.sort(arr);
		for(int i=0; i<n; i++){
			if(arr[i]-1 == lastSmallest){
				lastSmallest=arr[i];
				currentCount += 1;

			} else if(arr[i] != lastSmallest){
				lastSmallest=arr[i];
				currentCount = 1;
			}
			longest = Integer.max(longest, currentCount);
		}
		return longest;
	}

	int longestConsequtiveSubsequenceOptimal(int[] arr){
		int n=arr.length;
		int longest=0;
		if(n==0) return longest;
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<n; i++){
			set.add(arr[i]);
		}
		for(int it : set){
			int cnt=1;
			int x=it;
			if(!set.contains(it - 1)){
				while(set.contains(x+1)){
					cnt++;
					x++;
				}
			}
			longest = Integer.max(longest, cnt);
		}
		return longest;
	}

// SET MATRIX ZEROS

	void markRow(int[][] arr, int row, int colSize){
		for(int j=0; j<colSize; j++){
			if(arr[row][j]!=0) arr[row][j] = -1;
		}
	}
	void markCol(int[][] arr, int col, int rowSize){
		for(int i=0; i<rowSize; i++){
			if(arr[i][col]!=0) arr[i][col] = -1;
		}
	}
	void setMatrixZerosBrute(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j]==0){
					markRow(arr,i,m);
					markCol(arr,j,n);
				}
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j]==-1){
					arr[i][j] = 0;
				}
			}
		}
	}
	void setMatrixZerosBetter(int[][] arr){
		int n=arr.length;
		int m=arr[0].length;
		int[] row = new int[n];
		int[] col = new int[m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j]==0){
					row[i]=1;
					col[j]=1;
				}
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(row[i]==1 || col[j]==1){
					arr[i][j]=0;
				}
			}
		}
	}

	void setMatrixZerosOptimal(int[][] arr){
		// for marking row = arr[i][0]
		// for marking col = arr[0][j]
		int n = arr.length;
		int m = arr[0].length;
		int col0 = 1;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j] == 0){
					arr[i][0] = 0;
					if(j!=0){
						arr[0][j] = 0;
					} else{
						col0 = 0;
					}
				}
			}
		}
		for(int i = 1; i<n; i++){
			for(int j = 1; j<m; j++){
				if(arr[i][0] == 0 || arr[0][j] == 0){
					arr[i][j] = 0;
				}
			}
		}
		if(arr[0][0] == 0){
			for(int j = 0; j<m; j++){
				arr[0][j] = 0;
			}
		}
		if(col0 == 0){
			for(int i = 0; i<n; i++){
				arr[i][0] = 0;
			}
		}
	}

// ROTATE IMAGE/ ROTATE MATRIX BY 90deg(n x n)
	int[][] rotateImageBrute(int[][] arr){
		int n = arr.length;
		int[][] ans = new int[n][n];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				ans[j][(n-1)-i] = arr[i][j];
			}
		}
		return ans;
	}
	void rotateImageOptimal(int[][] arr){
		int n = arr.length;
		for(int i = 0; i<n-1; i++){
			for(int j = i+1; j<n; j++){
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		for(int i = 0; i<n; i++){
			int left = 0, right = n-1;
			while(left <= right){
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				left++;
				right--;
			}
		}
	}

	public static void main(String[] args){
		ArraysMedium obj = new ArraysMedium();
		int[] arr1 = {102,4,100,1,101,3,2,1,1};
		int[][] arr2 = { {1,2,3,4},
						 {5,6,7,8},
						 {9,10,11,12},
						 {13,14,15,16} };
		obj.rotateImageOptimal(arr2);
		// int[][] ans = obj.rotateImageBrute(arr2);
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(arr2[i][j]);
				System.out.print(",");

			}
			System.out.println();
		}
		//System.out.print(obj.longestConsequtiveSubsequenceOptimal(arr1));
		//int[] ans = obj.leadersInAnArrayBrute(arr1);
		// for(int i=0; i<ans.length; i++){
		// 	System.out.print(ans[i]+" ");	
		// }
		
	}
}