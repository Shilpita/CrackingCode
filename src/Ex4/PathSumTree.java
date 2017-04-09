package Ex4;

import java.util.HashMap;

import Ex4.General.TreeNode;

/*********************************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : April6,2017
 * Problem: Path Sum count: Given Binary tree and sum ,find number of paths that equal to the sum.
 *          Cracking the Coding Interview
 * ******************************************************************************************************************************************/

public class PathSumTree {
	
	public static int pathSum(TreeNode node , int target){
		System.out.println("Target sum :"+ target);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, 1); // default sum =0 has count 1
		return getPathSum(node,0,target,map);
	}
	/**
	 * 			   10
	 * 			 /    \
	 * 			5	   -3
	 * 		  /  \		 \
	 *       3    2       11
	 *      / \    \
	 *     3   -2   1
	 *       
	 */
	private static int getPathSum(TreeNode node, int sum, int target, HashMap<Integer, Integer> map) {
		if(node == null)
			return 0; // if tree empty return count 0
		
		sum+= node.data; // add present node data to current sum
		int result = map.getOrDefault(sum-target, 0); // get the count of the paths which have the target result
		map.put(sum, map.getOrDefault(sum, 0)+1); // add the count for the current sum
		
		System.out.println("Current Node value: "+ node.data
							+"\tCurrent Sum: "+ sum
							+"\t Current sum-target: "+ (sum-target)
							+"\t Before recurring result :"+ result
							+"\tBefore recurring : "+ map.toString());
		
		// recursively call to get the count on left and right subtree
		result+= getPathSum(node.left, sum, target, map) +getPathSum(node.right, sum, target, map); 
		
		map.put(sum, map.get(sum)-1); // Remove the count from the current node so other paths are not affected
		System.out.println("\nResult : " +result +"\tAfter recurring : "+map.toString());
		return result;
		
	}

	public static void main(String[] args) {
		/**
		 * 			   10
		 * 			 /     \
		 * 			5	    -3
		 * 		  /  \		  \
		 *       3    2        11
		 *      / \    \
		 *     3   -2   1
		 *       
		 */
		
	    TreeNode a = new TreeNode(10);
	    TreeNode b = new TreeNode(5);
	    TreeNode c = new TreeNode(-3);
	    TreeNode d = new TreeNode(3);
	    TreeNode e = new TreeNode(2);
	    TreeNode f = new TreeNode(11);
	    TreeNode g = new TreeNode(3);
	    TreeNode h = new TreeNode(-2);
	    TreeNode i = new TreeNode(1);
	    a.left = b;
	    a.right = c;
	    b.left = d;
	    b.right = e;
	    c.right = f;
	    d.left = g;
	    d.right = h;
	    e.right = i;

	    System.out.println(pathSum(a, 8));
	    
	}

}
