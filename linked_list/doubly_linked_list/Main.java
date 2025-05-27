public class Main{
	public static void main(String[] args){
		IntroductionToDll obj1 = new IntroductionToDll();
		int[] arr = {1,2,3,4,5};
		// Node head = obj1.convertArrToDll(arr);
		// Node temp = head;
		// for(int i = 0; i<arr.length; i++){
		// 	System.out.print(temp.data + " ");
		// 	temp = temp.next;
		// }

		DeletionInDll obj2 = new DeletionInDll();
		Node head = obj1.convertArrToDll(arr);
		// head = obj2.deleteKthElement(head,4);
		obj2.deleteNode(head.next.next);
		Node temp = head;
		for(int i = 0; i<arr.length -1; i++){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}
}