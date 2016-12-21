package Ex2;

public class PartitionList {
	public static Node partition(Node head, int n){
		if(head == null) return null;
		Node temp = head;
		Node less = null;
		Node more = null;
		
		while(temp != null){
			Node nextNode = temp.next;
			temp.next = null;
			if(temp.data < n){
				if(less == null && more == null){
					less = temp;
					more = temp;
				}else if(less != null){
					temp.next = less;
					less = temp;
				}
			}else{
				if(more!=null){
					more.next = temp;
					more = temp;
				}
			}
			temp = nextNode;
		}
		return less;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
        for (int i=9 ; i>= 4 ;i--)
        	head.insert(head, i);
        for (int i=0 ; i<= 6 ;i++)
        	head.insert(head, i);
        
		head.printList(head);
		
		Node result = partition(head,5);
		
		result.printList(result);
		
	}

}
