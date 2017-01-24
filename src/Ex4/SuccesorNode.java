package Ex4;

class Node{
	int data;
	Node left;
	Node right;
	Node parent;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
public class SuccesorNode {
	private static Node btree;
	
	private static Node getSuccesor(Node root){
		if(root == null) return null;
		
		Node node = root;
		
		if(node.right != null){
			Node next = getLeftmostChild(node.right);
			return next;
		}else{
			Node next = node;
			Node nextParent = node.parent;
			while(nextParent != null && nextParent.left != next){
				next = nextParent;
				nextParent = nextParent.parent;		
			}
			return next;
		}
	}

	private static Node getLeftmostChild(Node node) {
		if(node == null)
		return null;
		
		while(node!= null)
			node = node.left;
		
		return node;
	}

	public static void main(String[] args) {
		btree = new Node(1);
		btree.left = new Node(2);
		btree.left.parent = btree;
		btree.right = new Node(3);
		btree.right.parent = btree;
		
		btree.left.left = new Node(4);
		btree.left.right = new Node(5);
		btree.left.left.parent = btree.left;
		btree.left.right.parent = btree.left;
		
		btree.right.left = new Node(6);
		btree.right.right = new Node(7);
		btree.right.left.parent = btree.right;
		btree.right.right.parent = btree.right;
		
		btree.left.right.right = new Node(8);
		btree.left.right.right.parent = btree.left.right;
		
		btree.right.right.left = new Node(10);
		btree.right.right.left.parent = btree.right.right;
		btree.right.right.left.right = new Node(9);
		btree.right.right.left.right.parent = btree.right.right.left;

		System.out.println(getSuccesor(btree.right.right.left.right).data);
		
	}
}
