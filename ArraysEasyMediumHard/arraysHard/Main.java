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
		int[] arr = {-1,0,1,2,-1,-4};
		System.out.println(obj3.threeSumBrute(arr));

	}
}

	