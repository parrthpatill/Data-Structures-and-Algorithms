class Main{

	public static void main(String[] args){
		//Pascal's triangle implementation;
		PascalsTriangle obj = new PascalsTriangle();
		// System.out.println(obj.nthRowInPascalsTriangle(6));
		// int element = obj.findElementInPascalsTriangle(6,1);
		// System.out.println(element);
		// System.out.println(obj.completePascalsTriangle(6));

		// Majority Element II
		MajorityElementII obj1 = new MajorityElementII();
		int[] arr = {1,1,1,3,3,2,2,2,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5};
		System.out.println(obj1.getMajorityElementIIBruteForce(arr));

	}
}

	