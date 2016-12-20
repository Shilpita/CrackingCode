package Ex2;


public class Node {
		int data;
		Node next;
		
		public Node(){
			this.data = 0;
			this.next = null;
		}
		
		public Node(int d){
			this.data = d;
			this.next = null;
		}
		
	    public static  Node insert(Node head,int data) {
	        Node temp = head;
	        if(head == null)
	            head = new Node(data);
	        else if(head.next == null)
	            head.next = new Node(data);
	        else{
	            while(temp.next!= null)
	                temp = temp.next;
	            temp.next = new Node(data);
	        }
	        return head;
	    }
	    
	    public static  Node delete(Node head,int d) {
	        Node temp = head;
	        if(head.data == d)
	            return head.next;
	        else{
	            while(temp.next!= null)
	            	if(temp.data == d)
	                 return temp.next;
	            	else
	            		temp = temp.next;
	        }
	        return head;
	    }

		
		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		protected void setData(int data) {
			this.data = data;
		}
		
		public void printList(Node head){
			Node n = head;
			System.out.println();
			while(n!= null){
				System.out.print(n.getData() +"\t");
				n = n.next;
			}
		}

}
