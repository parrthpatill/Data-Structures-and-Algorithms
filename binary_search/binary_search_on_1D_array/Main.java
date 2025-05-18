public class Main{
	
	public static void main(String[] args){
		BinarySearch obj1 = new BinarySearch();
		int arr[] = {3,4,6,7,9,12,16,17};
		System.out.println(obj1.binarySearchRecursive(arr, 0, arr.length - 1, 9));
	}
}