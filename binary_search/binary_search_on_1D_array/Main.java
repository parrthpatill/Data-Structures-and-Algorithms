public class Main{
	
	public static void main(String[] args){
		BinarySearch obj1 = new BinarySearch();
		// int arr[] = {3,4,6,7,9,12,16,17};
		// System.out.println(obj1.binarySearchRecursive(arr, 0, arr.length - 1, 9));

		LowerBoundAndUpperBound obj2 = new LowerBoundAndUpperBound();
		// int arr[] = {1,2,3,3,4,8,9,9,9,11};
		// System.out.println(obj2.lowerBound(arr, 3939));
		// System.out.println(obj2.upperBound(arr, 3));

		FloorInArray obj3 = new FloorInArray();
		// int[] arr = {1,2,3,4,4,5,6,8,8,9};
		// System.out.println(obj3.floorInArray(arr, 7));

		FirstAnLastOccurrence obj4 = new FirstAnLastOccurrence();
		// int[] arr = {1,2,3,4,4,5,6,8,8,9};
		// System.out.println(obj4.firstAndLastOccurrenceUsingLbAndUb(arr, 34));

		NumberOfOccurrences obj5 = new NumberOfOccurrences();
		// int[] arr = {1,2,3,4,4,4,4,4,5,6,8,8,9};
		// System.out.println(obj5.numberOfOccurrences(arr, 4));

		SearchInSortedAndRotatedArray obj6 = new SearchInSortedAndRotatedArray();
		// int[] arr = {2,2,7,8,9,2,2,2,2,2,2};
		// System.out.println(obj6.searchInSortedAndRotatedArrayII(arr, 11));

		MinimumInSortedAndRotatedArray obj7 = new MinimumInSortedAndRotatedArray();
		// int[] arr = {4,1,2,3,4,4,4,4,4};
		// System.out.println(obj7.minimumInSortedAndRotatedArrayII(arr));

		RotationCount obj8 = new RotationCount();
		int arr[] = {4,4,4,1,2,3,4,4,4,4,4};
		System.out.println(obj8.rotationCountII(arr));


	}
}