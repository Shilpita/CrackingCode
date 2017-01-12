package Ex3;

import java.util.Stack;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan11,2017
 * Problem: Queue via Stacks-> Implement a MyQueue class which implements a queue using two stacks
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class QueueStack {
	private static Stack<Integer> stack1 ;
	private static Stack<Integer> stack2 ;
	
	public QueueStack() {
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
	}
	
	public static void add(int input){
		System.out.println("Added to queue :"+ input);
		stack1.push(input);
	}
	
	public static void moveStackData(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}
	
	public static int remove(){
		moveStackData();
		return stack2.pop();
	}
	
	public static int peek(){
		moveStackData();
		return stack2.peek();
	}
	
	public static int size(){
		return stack1.size()+stack2.size();
	}
	public static void main(String[] args) {
		QueueStack qs = new QueueStack();
		qs.add(1);
		qs.add(2);
		System.out.println("peek first element "+qs.peek());
		System.out.println("remove first element "+qs.remove());
		System.out.println("peek next element "+qs.peek());
		qs.add(3);
		qs.add(4);
		System.out.println("remove next element "+qs.remove());
	}



}
