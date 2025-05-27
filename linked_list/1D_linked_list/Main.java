public class Main{
	public static void main(String[] args){
		int[] arr = {12,34,25,67};

		Node head = ConvertingArrayToLinkedList.convertArrToLL(arr);
		// System.out.println(head.data);
		// Node temp = head;
		// while(temp != null){
		// 	// System.out.print(temp.data + " ");
		// 	temp = temp.next;
		// }
		// System.out.println(ConvertingArrayToLinkedList.lengthOfLL(head));
		// System.out.println(ConvertingArrayToLinkedList.searchInLL(head, 100));

		DeleteANode obj1 = new DeleteANode();
		InsertionOfNode obj2 = new InsertionOfNode();
		head = obj2.insertNode(head,6,2);
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}


	}
}