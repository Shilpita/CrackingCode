package Ex2;

import javax.naming.spi.DirStateFactory.Result;

public class SumTwoDigits {
	
	public static Node addLinkedLists(Node a, Node b){
		if(a== null || b== null) return null;
		int carry =0;
		Node result = null;
		Node temp = null;
		int sum = 0;
		while(a != null && b!=null){
			sum = a.data + b.data;
			//System.out.println(sum);
			if(result == null){ 
					//System.out.println("sd"+sum%10);
					temp = new Node (sum%10);
					result = temp;
			}else{
					
					while(temp.next != null) {
						temp = temp.next;
					}
					temp.next = new Node((sum+carry)%10);
				}
			if(sum > 9) carry = sum/10;
			
			a= a.next;
			b= b.next;
		}
		//result.next = new Node(a.data+b.data+carry);
		
		return result;
}
		
	

	public static void main(String[] args) {
		int a = 295;
		int b = 513;
		
		Node first1 = new Node(a%10);
		Node first2 = new Node((a/10)%10);
		Node first3 = new Node(a/100);
		
		first1.next = first2;
		first2.next = first3;
		
		first1.printList(first1);
		
		Node second1 = new Node(b%10);
		Node second2 = new Node((b/10)%10);
		Node second3 = new Node(b/100);
		
		second1.next = second2;
		second2.next = second3;
		
		second1.printList(second1);

		Node result = addLinkedLists(first1,second1);
		result.printList(result);
	}

}
