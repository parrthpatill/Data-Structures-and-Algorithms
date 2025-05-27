
public class IntroductionToDll{
	Node convertArrToDll(int[] arr){
		Node head = new Node(arr[0], null, null);
		Node prev = head;
		for(int i = 1; i<arr.length; i++){
			Node temp = new Node(arr[i], null, prev);
			prev.next = temp;
			prev = temp;
		}
		return head;
	}
}