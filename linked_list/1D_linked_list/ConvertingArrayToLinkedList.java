class Node{
	int data;
	Node next;

	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}

public class ConvertingArrayToLinkedList{
	private static Node convertArrToLL(int[] arr){
		Node head = new Node(arr[0], null);
		Node mover = head;
		for(int i = 1; i<arr.length; i++){
			Node temp = new Node(arr[i], null);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}
	private static int lengthOfLL(Node head){
		int cnt = 0;
		Node temp = head;
		while(temp != null){
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}
	private static boolean searchInLL(Node head, int x){
		Node temp = head;
		while(temp != null){
			if(temp.data == x) return true;
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args){
		int[] arr = {12,34,56,32};
		Node head = convertArrToLL(arr);
		System.out.println(head.data);
		Node temp = head;
		while(temp != null){
			// System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println(lengthOfLL(head));
		System.out.println(searchInLL(head, 100));

	}
}