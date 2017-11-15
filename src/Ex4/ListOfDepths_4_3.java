package Ex4;

import java.util.*;
/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Nov14,2017
 * Problem: 4.3 Given a binary tree, design an algorithm which creates a linked list of all the nodes at 
 * 			each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/
public class ListOfDepths_4_3{
	private static TreeNode btree;
	
	//Level order traversal of the tree and at each level maintain a separate LinkedList
	// Time Complexity = O(N)   Space Complexity = O(N) for linkedList
	
	public static ArrayList<LinkedList<TreeNode>> levelList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		if(root == null) return null;

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		
		list.add(root);
		
		while(!list.isEmpty()){
			
		   result.add(list);
		   
		   LinkedList<TreeNode> currentList = list;
		   
		   list = new LinkedList<TreeNode>(); //reinitialize the list
		   
		   for(TreeNode i : currentList){
			   if(i.left != null)
				   list.add(i.left);
			   if(i.right != null)
				   list.add(i.right);
		   }	   
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		btree = new TreeNode(4);
		btree.left = new TreeNode(2);
		btree.right = new TreeNode(6);
		btree.left.left = new TreeNode(1);
		btree.left.right = new TreeNode(3);
		btree.right.left = new TreeNode(5);
		btree.right.right = new TreeNode(7);
		
		ArrayList<LinkedList<TreeNode>> result = levelList(btree);
		
		for(LinkedList<TreeNode> i : result){
			System.out.println();
			for(TreeNode j : i)
				System.out.print(j.data+"\t");
		}
		
	}

}
