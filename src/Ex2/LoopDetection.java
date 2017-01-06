package Ex2;

/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Dec22,2016
 * Problem: Given access to list detect loop in the list.
 *          Cracking the Coding Interview
 * ***************************************************************************************/


import java.util.HashSet;

public class LoopDetection {
	
	public static Node loopDetectionHashSet(Node list){
		if(list == null) return null;
		HashSet<Node> set = new HashSet<Node>();
		while(list != null){
			if(set.contains(list)) return list;
			else
				set.add(list);
			list = list.next;
		}
		return null;
	}
	
	//flyod algorithm
	public static Node loopDetectionFlyod(Node list){
		if(list == null) return null;
		Node slowPointer = list;
		Node fastPointer = list.next;
		
		while(slowPointer!= null && fastPointer!= null){
			if(slowPointer == fastPointer)
				//return slowPointer;
				break;
			else{
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			}
		}
		
		if(slowPointer == null || fastPointer == null) return null;
		
		slowPointer = list;
		while(fastPointer.next != slowPointer){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		return slowPointer;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Node head = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        head.next = a;
        a.next =b;
        b.next =c;
        c.next =d;
        d.next =e;
        e.next =f;
     //   f.next =b;
        		
       // head.printList(head);
        Node result = loopDetectionHashSet(head);
        if(result == null)
            System.out.println("\n loop detected using hashset: NO LOOP" );
        else
            System.out.println("\n loop detected using hashset: " + result.data);
        
        Node result1 = loopDetectionFlyod(head);
        if(result1 == null)
        	System.out.println("\n loop detected using Flyod Algorithm: NO LOOP");
        else
            System.out.println("\n loop detected using Flyod Algorithm:"+result1.data);
	}

}
