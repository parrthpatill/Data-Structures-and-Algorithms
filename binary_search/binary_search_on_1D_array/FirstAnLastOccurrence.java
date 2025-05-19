import java.util.*;
public class FirstAnLastOccurrence{
	//Using lb and ub

	ArrayList<Integer> firstAndLastOccurrenceUsingLbAndUb(int[] arr, int x){
		ArrayList<Integer> ans = new ArrayList<>();

		int lb = LowerBoundAndUpperBound.lowerBound(arr, x);
		int ub = LowerBoundAndUpperBound.upperBound(arr, x) - 1;

		if(lb == arr.length || arr[lb] != x){
			lb = -1;
			ub = -1;
		}

		ans.add(lb);
		ans.add(ub);

		return ans;
	}
}