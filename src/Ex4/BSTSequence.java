package Ex4;

import java.util.*;
/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : April5,2017
 * Problem: Binary Search Tree Sequence: Given a Binary tree find all possible array that create the BST.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class BSTSequence {
	
	private static ArrayList<LinkedList<Integer>> bstSequences(TreeNode root) {
		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>> ();
		if(root == null){
			LinkedList<Integer> l = new LinkedList<Integer>();
			list.add(l);
			return list;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.addFirst(root.data);
		
		ArrayList<LinkedList<Integer>> left = bstSequences(root.left);
		ArrayList<LinkedList<Integer>> right= bstSequences(root.right);
		
		for(LinkedList<Integer> i : left){
			for(LinkedList<Integer> j : right){
				ArrayList<LinkedList<Integer>> weaveList = new ArrayList<LinkedList<Integer>>();
				weaveFunc(i,j,weaveList, prefix);
				list.addAll(weaveList);
			}
		}
		
		return list;
	}


	private static void weaveFunc(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> weaveList, LinkedList<Integer> prefix) {
		
		
		if(first.isEmpty() || second.isEmpty()){
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			result.addAll(first);
			result.addAll(second);
			weaveList.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveFunc(first,second,weaveList , prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveFunc(first,second,weaveList , prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
		
		return;
	}


	public static void main(String[] args) {
		   /*           50
		    *          /  \
		    *         20   60
		    *        / \     \
		    *       10  25    70
		    *      /  \       / \
		    *     5    15    65  80
		    */
		    TreeNode a = new TreeNode(50);
		    TreeNode b = new TreeNode(20);
		    TreeNode c = new TreeNode(60);
		    TreeNode d = new TreeNode(10);
		    TreeNode e = new TreeNode(25);
		    TreeNode f = new TreeNode(70);
		    TreeNode g = new TreeNode(5);
		    TreeNode h = new TreeNode(15);
		    TreeNode i = new TreeNode(65);
		    TreeNode j = new TreeNode(80);
		    a.left = b;
		    a.right = c;
		    b.left = d;
		    b.right = e;
		    c.right = f;
		    d.left = g;
		    d.right = h;
		    f.left = i;
		    f.right = j;
		    ArrayList<LinkedList<Integer>> lists = bstSequences(a);
		    for (LinkedList sequence : lists)
		      System.out.println(sequence);

		   /*           2
		    *          / \
		    *         1   3
		    *         	/
		    *         4
		    */
		    a = new TreeNode(2);
		    b = new TreeNode(1);
		    c = new TreeNode(3);
		    a.left = b;
		    a.right = c;
		    c.left = new TreeNode(4);
		    lists = bstSequences(a);
		    
		    for (LinkedList sequence : lists)
		      System.out.println(sequence);

	}


}
