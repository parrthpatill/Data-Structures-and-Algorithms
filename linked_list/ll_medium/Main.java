public class Main{
	public static Node convertArrToLL(int[] arr){
		Node head = new Node(arr[0], null);
		Node mover = head;
		for(int i = 1; i<arr.length; i++){
			Node temp = new Node(arr[i], null);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}

	public static void main(String[] args){
		Main obj = new Main();
		MiddleNodeLL obj1 = new MiddleNodeLL();
		reverseLL obj2 = new reverseLL();
		detectLoopInLL obj3 = new detectLoopInLL();

		int[] arr = {1,2,3,5,6,4};
		Node head = obj.convertArrToLL(arr);
		// Node temp = obj3.detectLoopBrute(head);
		System.out.print(obj3.detectLoopBrute(head));
		// while(temp != null){
		// 	System.out.print(temp.data+" ");
		// 	temp = temp.next;
		// }
	}
}