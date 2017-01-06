package Ex2;

/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Dec18,2016
 * Problem: Given a Linked List find the Kth node from the End.
 *          Cracking the Coding Interview
 * ***************************************************************************************/

public class FindKNodeFromEnd {
	
	public static Node getListLength(Node head,int k){
		if(head == null) return null;
		int count = 0;
		Node temp = head;
		while(temp.next != null){
			count++;
			temp= temp.next;
		}
		temp = head;
		for(int i =0 ; i<= count-k ; i++){
			temp = temp.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.insert(head, 2);
		head.insert(head, 3);
		head.insert(head, 2);
		head.insert(head, 4);
		head.insert(head, 5);
		
		head.printList(head);
		
		Node result = getListLength(head,4);
		System.out.println("\n"+result.data);

	}

}
