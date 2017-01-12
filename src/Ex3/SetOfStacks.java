package Ex3;

import java.util.*;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan9,2017
 * Problem: Stack of Plates-> Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * 			Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
 * 			Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks
 * 			and should create a new stack once the previous one exceeds capacity. 
 * 			SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack (that is, pop ( )
 * 			should return the same values as it would if there were just a single stack).
 * 			FOLLOW UP
 *			Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class SetOfStacks {
	private static ArrayList<Stack<Integer>> stackPlates ;
	private int threshold ;
	
	public SetOfStacks(){
		this.stackPlates = new ArrayList<Stack<Integer>>();
		this.threshold = 3;
	}
	
	public static Stack<Integer> getLastStack(){
		int size = stackPlates.size();
		if(size <= 0) return null;
		else return stackPlates.get(size-1);		
	}
	
	public static void push(int input){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack == null){
			Stack<Integer> st = new Stack<Integer>();
			st.push(input);
			stackPlates.add(st);
			System.out.println("\nStack Plates empty.New Stack added. Stack num: "+ stackPlates.size() +" Stack size :"+ st.size());
		}else{
			if(lastStack.size() < 3){
				lastStack.push(input);
				System.out.println("\nAdded to old Stack. Stack num: "+ stackPlates.size() +" Stack size :"+ lastStack.size());
			}else{
				Stack<Integer> st = new Stack<Integer>();
				st.push(input);
				stackPlates.add(st);
				System.out.println("\nThreshold crossed.New Stack added. Stack num: "+ stackPlates.size() +" Stack size :"+ st.size());
			}
		}
	}
	
	public static int pop(){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack == null){
			System.out.println("Stack of Plates empty");
			return Integer.MIN_VALUE;
		}
			int output = lastStack.pop();
			if(lastStack.isEmpty()){
				System.out.println("\nStack emptied. Removed from Set");
				stackPlates.remove(stackPlates.size()-1);
			}
		return output;
	}
	
	public static int popAt(int index){
		if(stackPlates.get(index)==null || stackPlates.size() < index || stackPlates.size() == 0){
			System.out.println("INVALID INDEX");
			return Integer.MIN_VALUE;
		}
		int output = stackPlates.get(index).pop();
		for(int i = index ; i<stackPlates.size()-1;i++){
			Stack<Integer> curr = stackPlates.get(i);
			Stack<Integer> next = stackPlates.get(i+1);
			curr.push(next.remove(0));
		}
		if(stackPlates.get(stackPlates.size()-1).isEmpty())
			stackPlates.remove(stackPlates.size()-1);
		
		return output;	
	}

	public static void main(String[] args) {
		SetOfStacks s = new SetOfStacks();
		System.out.println(s.pop());
		s.push(1);
		s.push(1);
		s.push(1);
		s.push(2);
		s.push(2);
		s.push(2);
		s.push(3);
		s.push(3);
		s.push(3);
		s.push(4);
		s.push(4);
		s.push(4);
		System.out.println(s.pop());
		//System.out.println(s.pop());
		System.out.println(s.popAt(1));
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}

}
