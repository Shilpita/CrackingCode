package Ex3;

import java.util.Stack;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan7,2017
 * Problem: Stack Min-> How would you design a stack which, in addition to push and pop,
 * 		    has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/

public class StackMinValue extends Stack<Integer> {
	private static Stack<Integer> s;
	private static Integer minValue;
	public StackMinValue(){
		this.s= new Stack<Integer>();
		this.minValue = Integer.MAX_VALUE;
	}
	public static int getMin(){
		if(s.isEmpty()){
			System.out.println("Stack empty");
			return Integer.MAX_VALUE;
		}else
			return minValue;
	}
	
	public static void push(int input){
		if(s.isEmpty()){
			minValue = input;
			s.push(input);
			System.out.println("Inserted to stack :"+ s.peek()+" ----stack minimum : "+ getMin());
		}else{
			if(getMin() > input){
				s.push(2*input -getMin());
				minValue = input;	
				System.out.println("Inserted to stack :"+ s.peek()+" ----stack minimum : "+ getMin());
			}else{
				s.push(input);
				System.out.println("Inserted to stack :"+ s.peek()+" ----stack minimum : "+ getMin());
			}
		}
	}
	
	public Integer pop(){
		if(s.isEmpty()){
			System.out.println("\n stack empty");
			return Integer.MAX_VALUE;
		}else{
			int i = s.pop();
			if(i < getMin()){
				int x = getMin();
				minValue = 2*getMin() - i;
				System.out.println("Removed from stack :"+ x+ "----new Minimum : "+ getMin());
				return x;
			}else{
				System.out.println("Removed from stack :"+ i+ "----new Minimum : "+ getMin());
				return i;
			}
		}
	}
	
	public static void main(String[] args) {
		
		StackMinValue s = new StackMinValue();
		s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
       // s.peek();
	}

}
