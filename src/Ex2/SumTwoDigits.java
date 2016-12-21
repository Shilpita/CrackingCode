package Ex2;

import javax.naming.spi.DirStateFactory.Result;

public class SumTwoDigits {
	
	public static Node createReversedDigitList(int a){
		if(a <= 0) return null;
		Node node1 = new Node(a%10);
		Node node2 = new Node((a/10)%10);
		Node node3 = new Node(a/100);
		node1.next = node2;
		node2.next = node3;
		
		return node1;
	}
	
	public static Node createDigitList(int a){
		if(a <= 0) return null;
		Node node1 = new Node(a/100);
		Node node2 = new Node((a/10)%10);
		Node node3 = new Node(a%10);
		node1.next = node2;
		node2.next = node3;
		
		return node1;
	}
	
	public static Node addLinkedListsReversed(Node a, Node b){
		if(a== null || b== null) return null;
		int carry =0;
		Node result = null;
		Node temp = null;
		int sum = 0;
		while(a != null && b!=null){
			sum = a.data + b.data;
			if(result == null){ 
					temp = new Node(sum%10);
					result = temp;
			}else{
				    temp.next = new Node((sum+carry)%10);
				    temp = temp.next;
				}
			if(sum > 9) carry = sum/10;
			a= a.next;
			b= b.next;
		}
		//result.next = new Node(a.data+b.data+carry);	
		return result;
}
		

	
	public static Node reverseList(Node list){
		if(list == null) return null;
		Node prevNode = null;
		Node nextNode = null;
		Node currentNode = list;
		while(currentNode != null){
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		return prevNode;
	}


	public static void main(String[] args) {
		int a = 617;
		int b = 295;
		
		Node first1 = createReversedDigitList(a);
		first1.printList(first1);
		
		Node second1 = createReversedDigitList(b);
		second1.printList(second1);
		System.out.println("\n---------------------");
		Node result1 = addLinkedListsReversed(first1,second1);
		result1.printList(result1);
		
		System.out.println("\n\nSum of non reversed list: ");
		Node third1 = createDigitList(a);
		third1.printList(third1);
		
		Node fourth1 = createDigitList(b);
		fourth1.printList(fourth1);
		System.out.println("\n---------------------");
		Node result2 = reverseList(addLinkedListsReversed(reverseList(third1),reverseList(fourth1)));
		result2.printList(result2);
	}


}
