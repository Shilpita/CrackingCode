package Ex4;

import java.util.*;
/*
class TreeNode{
	int data;
	TreeNode left, right;
	
	TreeNode(int d){
		this.data = d;
		left = null;
		right = null;
	}
}
*/
public class ListOfDepths {
	private static TreeNode btree;
	
	public static ArrayList<LinkedList<TreeNode>> levelList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		if(root == null) return null;
		
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		while(!list.isEmpty()){
		   result.add(list);
		   LinkedList<TreeNode> parentList = list;
		   list = new LinkedList<TreeNode>();
		   for(TreeNode i : parentList){
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
