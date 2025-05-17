import java.util.*;
class Main{

	public static void main(String[] args){
		//Pascal's triangle implementation;
		PascalsTriangle obj1 = new PascalsTriangle();
		// System.out.println(obj.nthRowInPascalsTriangle(6));
		// int element = obj.findElementInPascalsTriangle(6,1);
		// System.out.println(element);
		// System.out.println(obj.completePascalsTriangle(6));

		// Majority Element II
		MajorityElementII obj2 = new MajorityElementII();
		// int[] arr = {1,1,1,1,3,2,2,2};
		// System.out.println(obj2.getMajorityElementIIOptimal(arr));

		// 3Sum problem
		ThreeSum obj3 = new ThreeSum();
		// int[] arr = {-1,0,1,2,-1,-4};
		// System.out.println(obj3.threeSumOptimal(arr));

		FourSum obj4 = new FourSum();
		// int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
		// System.out.println(obj4.getFourSumOptimal(arr, 9));

		LargestSubArrayWithSumZero obj5 = new LargestSubArrayWithSumZero();
		// int[] arr = {1,-1,3,2,-2,-8,1,7,10,23};
		// System.out.println(obj5.largestSubArrayWithSumZeroOptimal(arr));

		NumberOfSubarraysWithXorK obj6 = new NumberOfSubarraysWithXorK();
		// int[] arr = {4,2,2,6,4};
		// System.out.println(obj6.numberOfSubarraysWithXorKOptimal(arr, 6));

		MergeOverlappingArrays obj7 = new MergeOverlappingArrays();
		// int[][] arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
		// System.out.println(obj7.mergeOverlappingArraysOptimal(arr));

		MergeSortedArraysWithoutExtraSpace obj8 = new MergeSortedArraysWithoutExtraSpace();
		// int[] arr1 = {1,3,5,7};
		// int[] arr2 = {0,2,6,8,9};
		// List<int[]> result = obj8.mergeSortedArraysOptimal2(arr1, arr2);
		// System.out.println(Arrays.toString(result.get(0)));
		// System.out.println(Arrays.toString(result.get(1)));

		RepeatingAndMissing obj9 = new RepeatingAndMissing();
		// int[] arr = {2,4,3,6,1,1};
		// System.out.println(obj9.repeatingAndMissingOptimal2(arr));

		CountInversions obj10 = new CountInversions();
		// int[] arr = {5,3,2,4,1};
		// System.out.println(obj10.countInversionBrute(arr));

		MaximumProductSubarray obj11 = new MaximumProductSubarray();
		int[] arr = {2,3,-2,4};
		System.out.println(obj11.maximumProductSubarrayOptimal(arr));
	}
}

	