package Ex4;

import java.util.Random;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : April6,2017
 * Problem: Random Node: 
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

class MyTree{
	int data;
	int size = 0 ;
	MyTree left, right;
	
	//contructor
	public MyTree(int d){
		data = d;
		size = 1;
	}
	
	// insert node to the tree
	public void insertNode(int d){
		if(d <= this.data){
			if(left == null){
				left = new MyTree(d);
			}else {
				left.insertNode(d);
			}
		}else{
			if(right == null)
				right = new MyTree(d);
			else
				right.insertNode(d);
		}
		
		size++;	
	}
	
	public int getSize(){
		return size;
	}
	
	public MyTree randomNode(){
		int s = this.getSize();
		Random r = new Random();
		int index = r.nextInt(s);
		int leftsize = left == null ? 0 : left.getSize();
		if(index < leftsize)
			return left.randomNode();
		else if(index == leftsize)
			return this;
		else
			return right.randomNode();
	}
	
}



public class RandomTreeNode {

	public static void main(String[] args) {
		   	MyTree a = new MyTree(8);
		    a.insertNode(4);
		    a.insertNode(2);
		    a.insertNode(14);
		    a.insertNode(6);
		    a.insertNode(7);
		    a.insertNode(17);
		    System.out.println(a.size);
		    
		    System.out.println(a.randomNode().data);
		    System.out.println(a.randomNode().data);
		    System.out.println(a.randomNode().data);
		    System.out.println(a.randomNode().data);
		    System.out.println(a.randomNode().data);

	}

}
