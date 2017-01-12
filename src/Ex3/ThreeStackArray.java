package Ex3;

import java.util.Scanner;

/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan7,2017
 * Problem: Three in One: Describe how you could use a single array to implement three stacks.
 *          Cracking the Coding Interview
 * ***************************************************************************************/
public class ThreeStackArray {
	private static int[] arr;
	private static int size;
	private static int top1;
	private static int top2;
	private static int top3;
	private static int mid;

	public ThreeStackArray(int size) {
		super();
		this.size = size;
		this.arr = new int[size];	
		this.top1 = -1;
		this.top2 = (size-1)/2;
		this.top3 = size;
		this.mid = (size-1)/2;
	}
	
	private static void push1(int input) {
		if(top1 < mid){
			top1++;
			arr[top1]= input;
		}else{
			System.out.println("stack1 overflow");
		}
	}

	private static void push2(int input) {
		if(top2 < top3){
			top2++;
			arr[top2]= input;
		}else{
			System.out.println("stack2 overflow");
		}
		
	}

	private static void push3(int input) {
		if(top3 > top2){
			top3--;
			arr[top3]= input;
		}else{
			System.out.println("stack3 overflow");
		}
	}

	private static int pop1(){
		if(top1 >= 0){
			int output = arr[top1];
			top1--;
			return output;
		}else{
			System.out.println("stack1 is empty");
			return -9999;
		}
	}
	
	private static int pop2() {
		if(top2 >= mid-1){
			int output = arr[top2];
			top2--;
			return output;
		}else{
			System.out.println("stack2 is empty");
			return -9999;
		}
	}
	
	private static int pop3() {
		if(top3 <= size){
			int output = arr[top3];
			top3++;
			return output;
		}else{
			System.out.println("stack3 is empty");
			return -9999;
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ThreeStackArray t = new ThreeStackArray(scan.nextInt());
		int input = scan.nextInt();
		push1(input);
		input = scan.nextInt();
		push2(input);
		input = scan.nextInt();
		push3(input);
		push1(input);
		input = scan.nextInt();
		push2(input);
		input = scan.nextInt();
		push3(input);
		System.out.println(pop1());
		System.out.println(pop2());
		System.out.println(pop3());
		System.out.println(pop2());
		System.out.println(pop3());
	}

}
