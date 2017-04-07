package Ex4;

import Ex4.General.TreeNode;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : April4,2017
 * Problem: Binary Tree: Given a Binary tree and two nodes find the first comon ancestor of the two nodes.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class FirstCommonAncestor {
	
	public static boolean v1= false , v2 = false; // flags visted v1 and v2 to track if both nodes are in tree
	
	public static void main(String[] args) {
	    TreeNode a = new TreeNode(20); 
	    TreeNode b = new TreeNode(10); 
	    TreeNode c = new TreeNode(30); 
	    TreeNode d = new TreeNode(5); 
	    TreeNode e = new TreeNode(15); 
	    TreeNode f = new TreeNode(3); 
	    TreeNode g = new TreeNode(7); 
	    TreeNode h = new TreeNode(17); 
	    a.left = b;
	    a.right = c;
	    b.left = d;
	    b.right = e;
	  //  e.right = h;
	    d.left = f;
	    d.right = g;
	    TreeNode ancestor = commonAncestor(a, g, h);
	    
	    if(v1 && v2) 
	    	System.out.println(ancestor.data); // if both nodes are in tree then v1 n v2 set
	    else
	    	System.out.println("One or both nodes not on tree");

	}

	private static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null)
			return null;
		
		if(root == p && root == q){
			v1 = true ;
			v2 = true ;
			return root;
		}
		
		if(root == p){
			v1 = true ;
			return root;
		}
		
		if(root == q){
			v2 = true ;
			return root;
		}
		
		if(p == q){
			v1 = true ;
			v2 = true ;
			return p;
		}
		
		TreeNode left = commonAncestor(root.left , p , q);
		TreeNode right = commonAncestor(root.right , p , q);
		
		if(left != null && right != null) // p & q in different subtree then root is the ancestor
			return root;
		
		return (left!= null) ? left : right; // either left or right subtree has the ancestor
	}

}
