package Ex4;

import Ex4.General.TreeNode;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan22,2017
 * Problem: Check Balanced Tree-> Given a binary tree check if its balanced i.e the height of subtree differ only by one.
 * 
 * 1) get height of each subtree recursively and check the difference O(NlogN)
 * 2) check height and if height is less thzn pass error message O(n)
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/
/*class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}*/

public class IsBanlancedTree {
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
	
	/**** METHOD 2: EFFIECIENT METHOD *****/
	public static int checkHeight(TreeNode root){
		if(root == null)
			return Integer.MIN_VALUE;
		
		int leftTreeHeight = checkHeight(root.left);
		if(leftTreeHeight == Integer.MIN_VALUE )
			return Integer.MIN_VALUE;
		
		int rightTreeHeight = checkHeight(root.right);
		if(rightTreeHeight == Integer.MIN_VALUE )
			return Integer.MIN_VALUE;
		
		int max_diff =  Math.abs(rightTreeHeight - leftTreeHeight);
		if(max_diff > 1)
			return  Integer.MIN_VALUE;
		else
			return Math.max(rightTreeHeight, leftTreeHeight)+1;
	}
	
	public static boolean isBalanced2(TreeNode root){
		return (checkHeight(root) != Integer.MIN_VALUE);
	}
	
	public static void main(String[] args) {
		btree = new TreeNode(1);
		btree.left = new TreeNode(2);
		btree.right = new TreeNode(3);
		btree.left.left = new TreeNode(4);
		btree.left.right = new TreeNode(5);
		btree.left.right.right = new TreeNode(8);
		btree.right.left = new TreeNode(6);
		btree.right.right = new TreeNode(7);
		btree.right.right.left = new TreeNode(10);
		btree.right.right.left.right = new TreeNode(9);

		System.out.println(isBalanced1(btree));
		
		System.out.println(isBalanced2(btree));
	}

}
