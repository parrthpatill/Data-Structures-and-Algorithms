public class Main{
	public static void main(String[] args){
		Sqrt obj1 = new Sqrt();
		// System.out.println(obj1.sqrtOfIntegerOptimal(35));

		NthRootOfM obj2 = new NthRootOfM();
		// System.out.println(obj2.nthRootOfMOptimal(4,16));

		KokoEatingBananas obj3 = new KokoEatingBananas();
		// int[] piles = {3,6,7,11};
		// System.out.println(obj3.kokoEatingBananasOptimal(piles, 8));

		MinimumDaysToMakeMBouquets obj4 = new MinimumDaysToMakeMBouquets();
		// int bloomDay[] = {7,7,7,7,13,11,12,7};
		// System.out.println(obj4.minimumDaysToMakeMBouquetsOptimal(bloomDay, 2, 3));

		FindTheSmallestDivisor obj5 = new FindTheSmallestDivisor();
		int[] arr = {1,2,5,9};
		System.out.println(obj5.findTheSmallestDivisorOptimal(arr, 6));
	}
}