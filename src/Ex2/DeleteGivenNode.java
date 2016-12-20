package Ex2;

public class DeleteGivenNode {
	public static void deleteGivenNode(Node n){
		if(n== null) return ;

			n.data = n.next.data;
			n.next = n.next.next;

	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		head.printList(head);
		deleteGivenNode(third);
		head.printList(head);
	}

}
