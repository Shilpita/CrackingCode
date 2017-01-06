package Ex2;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan5,2017
 * Problem: Given two Linked List find the intersection node.
 *          Cracking the Coding Interview
 *************************************************************************************/
public class IntersectionList {
	public static int getListLength(Node list){
		if(list==null)return 0;
		int length =0;
		while(list!=null){
			length++;
			list = list.next;
		}
		return length;
	}
	
	public static Node intesectionPoint(Node list1,Node list2){
		if(list1 == null || list2 == null) return null;
		int l1 = getListLength(list1);
		int l2 = getListLength(list2);
		//System.out.println(l1+ " "+l2);
		int diff =0;
		
		Node p1 = list1;
		Node p2 = list2;

		if(l1 > l2){
			diff = l1-l2;
			//System.out.println("l1>l2:"+diff);
			int i= 0;
			while(i < diff){
				p1= p1.next;
				i++;
			}
		}else{
			diff = l2-l1;
			//System.out.println("l2>l1:"+diff);
			int i = 0;
			while(i < diff){
				p2= p2.next;
				//System.out.println(p2.data);
				i++;
			}
		}
		
		while(p1 != null && p2!= null){
			if(p1.data == p2.data)
				return p1;
			p1= p1.next;
			p2= p2.next;
		}
		
		return null;
	}

	public static void main(String[] args) {
		Node list1 = new Node(0);
		list1.next = new Node(1);
		for (int i=4 ; i<= 7 ;i++)
			list1.insert(list1, i);
		list1.printList(list1);
		Node list2 = new Node(2);
		for (int i=3 ; i<= 7 ;i++)
			list2.insert(list2, i);
		list2.printList(list2);
		
		Node result = intesectionPoint(list1, list2);
		if(result!=null)
		 System.out.println("\nIntersection at: "+ result.data);
		else
			System.out.println("\nIntersection do not happen");	
	}

}
