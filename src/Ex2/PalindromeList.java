package Ex2;

/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Dec22,2016
 * Problem: Given a Linked List Detect if it is palindrome list.
 *          Cracking the Coding Interview
 * ***************************************************************************************/

public class PalindromeList {
	public static boolean isPalindrome(Node head){
		if(head==null)return false;
		Node fastPnt = head;
		Node slowPnt = head;
		Node secHalf = null;
		Node mid = null;
		Node prevSlowPnt = null;
		while(fastPnt!=null && fastPnt.next != null){
			fastPnt = fastPnt.next.next;
			prevSlowPnt = slowPnt;
			slowPnt = slowPnt.next;
		}
		if(fastPnt != null){
			mid = slowPnt;
			slowPnt = slowPnt.next;
		}
		
		secHalf = slowPnt;
		prevSlowPnt.next = null;
		secHalf = reverseList(secHalf);
		boolean isPalindromeList = compareList(head,secHalf);
		
		secHalf = reverseList(secHalf);
		if(mid != null){
			prevSlowPnt.next = mid;
			mid.next = secHalf;
		}else
			prevSlowPnt.next = secHalf;
			
		return isPalindromeList;
	}
	
	public static Node reverseList(Node list){
		if(list == null) return null;
		Node previous = null;
		Node current = list;
		
		while(current != null){
			Node nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		
		return previous;
	}
	
	public static boolean compareList(Node list , Node reverse){
		if(list == null || reverse == null) return false;
		Node temp1 = list;
		Node temp2 = reverse;
		while(temp1 != null && temp2 != null){
			if(temp1.data == temp2.data){
				//System.out.println(temp1.data +" "+ temp2.data);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else{
			//	System.out.println("not equal");
				return false;
			}
		}
		
		if(temp1 == null && temp2 ==null) 
			return true;
	//	System.out.println("\none of list not empty"+ temp2.data);
		return false;
	}

	public static void main(String[] args) {
		Node head = new Node(0);
        for (int i=1 ; i<= 6 ;i++)
        	head.insert(head, i);
//        for (int i=5 ; i>= 0 ;i--)
//        	head.insert(head, i);
        head.printList(head);
        
      //  Node reverse = reverseList(head);
       // reverse.printList(reverse);
        
        System.out.println(isPalindrome(head));     //compareList(head,reverse));
	}

}
