class ArraysEasy{

	int largestElement(int[] nums){
		int largest = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(nums[i] > largest){
				largest = nums[i];
			}
		}
		return largest;
	}

	public static void main(String[] args){

		ArraysEasy obj = new ArraysEasy();
		int[] nums = {13, 2, 4, 7, 16, 2, 8};
		System.out.println(obj.largestElement(nums));
	}
}