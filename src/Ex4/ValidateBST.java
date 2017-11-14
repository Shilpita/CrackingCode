package Ex4;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan22,2017
 * Problem: Validate BST-> Given a binary tree check if its BST.
 *          Cracking the Coding Interview
 *****************************************************************************************************************************/
public class ValidateBST {
	private static TreeNode btree;
	
	private static boolean isBST(TreeNode root , int min, int max){
		if(root == null) return true;
		if(root.data < min || root.data > max) 
			return false;
		else
			return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
	
	public static void main(String[] args) {
		btree = new TreeNode(4);
		btree.left = new TreeNode(2);
		btree.right = new TreeNode(6);
		btree.left.left = new TreeNode(1);
		btree.left.right = new TreeNode(3);
		btree.right.left = new TreeNode(5);
		btree.right.right = new TreeNode(7);

		System.out.println(isBST(btree,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
}
