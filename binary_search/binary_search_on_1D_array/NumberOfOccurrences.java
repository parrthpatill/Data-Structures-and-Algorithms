public class NumberOfOccurrences{
	int numberOfOccurrences(int[] arr, int x){
		int lb = LowerBoundAndUpperBound.lowerBound(arr, x);
		int ub = LowerBoundAndUpperBound.upperBound(arr, x) - 1;

		if(lb == arr.length || arr[lb] != x) return 0;

		return ub - lb + 1;

	}
}