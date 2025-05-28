
public class ConvertingArrayToLinkedList{
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
	static int lengthOfLL(Node head){
		int cnt = 0;
		Node temp = head;
		while(temp != null){
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}
	static boolean searchInLL(Node head, int x){
		Node temp = head;
		while(temp != null){
			if(temp.data == x) return true;
			temp = temp.next;
		}
		return false;
	}

}