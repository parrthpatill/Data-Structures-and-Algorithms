class Main{

	public static void main(String[] args){
		PascalsTriangle obj = new PascalsTriangle();
		System.out.println(obj.nthRowInPascalsTriangle(6));
		int element = obj.findElementInPascalsTriangle(6,1);
		System.out.println(element);
		System.out.println(obj.completePascalsTriangle(6));
	}
}

	