package Ex2;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Dec16,2016
 * Problem: Remove all duplicate node from list.
 *          Cracking the Coding Interview
 * ***************************************************************************************/


import java.util.HashSet;

public class RemoveDuplicateNodes {
	public RemoveDuplicateNodes(){}
	
	//METHOD 1 :Using hashset to store all seen values
	public Node removeNodeHash(Node head){
		if(head == null) return null;
		HashSet<Integer> hs = new HashSet<Integer>();
		Node previous = null;
		while(head.next!= null){
		   if(hs.contains(head.data)){
			   previous.next = head.next;
		   }  
		   else{
			   hs.add(head.data);
			   previous = head;
			   //System.out.println(previous.data);
		   }
		   head = head.next;
		}
		return head;
	}
	
	//METHOD 2 :Without using any buffer and running two loops
	public Node removeNodeBrute(Node head){
		if(head == null) return null;
		Node current = head;
		//System.out.println(head +" ------"+ current);
		while(current.next != null){
			Node running = current;
			while(running.next != null){
				if(running.next.data == current.data){
					running.next = running.next.next; // always checks the next node with the current and advances one node
				}
				else{
					running = running.next;
				}
			}
			current = current.next;
		}
		return head;
		
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Node head = new Node(1);
		head.insert(head, 2);
		head.insert(head, 3);
		head.insert(head, 2);
		head.insert(head, 4);
		head.insert(head, 5);
		
		head.printList(head);
		
		RemoveDuplicateNodes rm = new RemoveDuplicateNodes();
		@SuppressWarnings("unused")
		
		//Node result = rm.removeNodeHash(head);
		
		Node result = rm.removeNodeBrute(head);
		head.printList(head);
		
	}
}
