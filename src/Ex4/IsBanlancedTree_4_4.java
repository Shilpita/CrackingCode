package Ex4;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan22,2017
 * Problem: 4.4 Check Balanced Tree-> Given a binary tree check if its balanced i.e the height of subtree differ only by one.
 * 
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/


public class IsBanlancedTree_4_4 {
	private static TreeNode btree;
	
	/****METHOD 1: O(NlogN) with recursion ****/
	public static int getHeight(TreeNode root){
		if(root == null) return Integer.MIN_VALUE;
		
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	private static boolean isBalanced1(TreeNode root){
		if(root == null)
			return true;
		int max_diff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if(max_diff > 1) {
		//	System.out.println("max_diff" +max_diff+ root.left.data);
			return false;}
		else{
			return isBalanced1(root.left) && isBalanced1(root.right);
		}
	}
	
	/**** METHOD 2: EFFIECIENT METHOD  
	 * Time Complexity :O(N)   Space Complexity : O(N) *****/
	
	public static int checkHeight(TreeNode root){
		if(root == null)
			return  0; ///Integer.MIN_VALUE;
		
		int leftTreeHeight = checkHeight(root.left);
		if(leftTreeHeight ==  -1) ////Integer.MIN_VALUE )
			return  -1;  ///return Integer.MIN_VALUE;
		
		int rightTreeHeight = checkHeight(root.right);
		if(rightTreeHeight ==  -1)   /// Integer.MIN_VALUE )
			return  -1; ///return Integer.MIN_VALUE;
		
		int max_diff =  Math.abs(rightTreeHeight - leftTreeHeight);
		if(max_diff > 1)
			return  -1; ///return  Integer.MIN_VALUE;
		else
			return Math.max(rightTreeHeight, leftTreeHeight)+1;
	}
	
	public static boolean isBalanced2(TreeNode root){
		return (checkHeight(root) != -1 ); ///// Integer.MIN_VALUE);
	}
	
	public static void main(String[] args) {
		/***
		 *      1
		 *     /  \
		 *    2    3
		 *   / \   / \
		 *  4   5  6  7
		 *  	 \    /
		 *  	  8  10
		 *  		  \
		 *             9
		 */
		btree = new TreeNode(1);
		btree.left = new TreeNode(2);
		btree.right = new TreeNode(3);
		btree.left.left = new TreeNode(4);
		btree.left.right = new TreeNode(5);
		btree.left.right.right = new TreeNode(8);
		btree.right.left = new TreeNode(6);
		btree.right.right = new TreeNode(7);
		btree.right.right.left = new TreeNode(10);
		//btree.right.right.left.right = new TreeNode(9);

		System.out.println(isBalanced1(btree));
		
		System.out.println(isBalanced2(btree));
	}

}
