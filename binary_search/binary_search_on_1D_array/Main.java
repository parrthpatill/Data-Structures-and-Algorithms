public class Main{
	
	public static void main(String[] args){
		BinarySearch obj1 = new BinarySearch();
		// int arr[] = {3,4,6,7,9,12,16,17};
		// System.out.println(obj1.binarySearchRecursive(arr, 0, arr.length - 1, 9));

		LowerBound obj2 = new LowerBound();
		int arr[] = {1,2,3,3,4,8,9,9,9,11};
		System.out.println(obj2.lowerBound(arr, 3939));
	}
}