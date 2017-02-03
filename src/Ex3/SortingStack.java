package Ex3;

import java.util.Stack;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan11,2017
 * Problem: Sorting Stack-> Write a program to sort a stack such that the smallest items are on the top.
 * 		    You can use an additional temporary stack, but you may not copy the elements into any other data structure
 * 			METHOD 2: RECURSION USING ONLY THE GIVEN STACK WITH O(N*N) TIME COMPLEXITY.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class SortingStack {
	private static Stack<Integer> stack;

	public SortingStack(){
		this.stack = new Stack<Integer>();
	}
	
	public static void sortStack(){ //Stack<Integer> st){
		if(stack==null) System.out.println("Stack is empty");
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()){
			int current = stack.pop();
			if(temp.isEmpty() || temp.peek() >= current){
				System.out.println("added to temp:"+ current);
				temp.push(current);
			}else{
				while(current > temp.peek()){
					stack.push(temp.pop());
					System.out.println("added to stack:"+ stack.peek());
				}
				temp.push(current);
			}
		}
		stack = temp;
		
	}
	
	public static void main(String[] args) {
		SortingStack ss = new SortingStack();
		ss.stack.push(8);
		ss.stack.push(0);
		ss.stack.push(3);
		ss.stack.push(5);
		ss.stack.push(9);
		ss.stack.push(10);
		ss.sortStack();
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}

}
