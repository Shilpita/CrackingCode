package Ex2;

public class PartitionList {
	public static Node partition(Node head, int n){
		if(head == null) return null;
		Node temp = head;
		Node less = null;
		Node more = null;
		Node lessHead = null;
		Node moreHead = null;
		while(temp.next != null){
			//System.out.println("\n"+head.data);
			if(temp.data < n){
				System.out.println("\n"+temp.data);
				if(less == null){
					less = temp;
					lessHead = less;
				}else{
					while(less.next!= null) less = less.next;
					System.out.println(less.data);
					less.next = temp;
				}
			}else{
				System.out.println("more:"+ temp.data);
				if(more == null){
					more = temp;
			        moreHead = more;
				}else{
					while(more!= null) more = more.next;
					more.next = temp;
				}
			}	
			temp = temp.next;
		}
		

		return lessHead;
		
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.insert(head, 2);
		head.insert(head, 3);
		head.insert(head, 2);
		head.insert(head, 4);
		head.insert(head, 5);
		head.insert(head, 6);
		
		head.printList(head);
		
		Node result = partition(head,3);
		
		//result.printList(result);
		
	}

}
