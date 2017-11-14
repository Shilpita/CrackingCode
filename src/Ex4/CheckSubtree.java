 package Ex4;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : April6,2017
 * Problem: CheckSubtree: Given two Binary tree check if one is subtree of the larger one. Assume first tree is always the larger tree.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class CheckSubtree {
	
	public static boolean isSubTree(TreeNode t1, TreeNode t2){
		if(t1 == null) return false;
		if(t2 == null) return true ;
		
		if(t1.data == t2.data && matchFullTree(t1,t2))
			return true;
		else
			return isSubTree(t1.left , t2) || isSubTree(t1.right , t2);
	}
	
	
	
	

	private static boolean matchFullTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return true;
		else if(t1 ==null || t2== null)
			return false;
		else if(t1.data != t2.data)
			return false;
		else
			return matchFullTree(t1.left, t2.left) && matchFullTree(t1.right , t2.right);
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
		    
		   /*         
		    *         20  
		    *        / \     
		    *       10  25    
		    *      /  \       
		    *     5    15    
		    */
		    
		    TreeNode p = new TreeNode(20);
		    TreeNode q = new TreeNode(10);
		    TreeNode r = new TreeNode(5);
		    TreeNode s = new TreeNode(15);
		    TreeNode t = new TreeNode(35);
		    
		    p.left = q;
		    q.left = r;
		    q.right= s;
		    p.right= t;
		    
		    System.out.println(isSubTree(a, p));

	}

}
