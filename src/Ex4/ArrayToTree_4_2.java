package Ex4;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan21,2017
 * Problem: 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, 
 * 			write an algorithm to create a binary search tree with minimal height.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class ArrayToTree_4_2 {
	//To build a minimal height BST, the tree has to be balanced.
	//Find the mid of the array and let all element to lower to mid be in left subtree 
	//and all element greater to mid be right subtree. Build subtree recursively
	// Time Complexity = O(N)   Space Complexity = O(N) for recursive stack
	private static TreeNode buildBST(int[] arr ,int start, int end) {
		if(start > end)
		return null;
		
		int mid = start + (end - start)/2; /// get the mid of the array as the root
		
		TreeNode TreeNode = new TreeNode (arr[mid]);
		TreeNode.left = buildBST(arr, start, mid-1);
		TreeNode.right= buildBST(arr,mid+1,end);
		
		return TreeNode;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		
		TreeNode btree = buildBST(arr, 0, arr.length-1);
		
		System.out.println(btree.right.right.right.data);
	}

}
