package Ex1;

import java.util.Arrays;
import java.util.Scanner;

/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan5,2017
 * Problem: Check Permutation-> Given two strings, write a method to decide if one is a permutation of the other. 
 *          Cracking the Coding Interview
 * ***************************************************************************************/
public class CheckPermutation {
	/*
	 * General method is convert the strings to character arrays and sort them and compare
	 */
	public static boolean isPermutation(String str1,String str2){
		if(str1 ==null || str2 == null) 
			return false;
		char[] strArray1 = str1.toCharArray();
		char[] strArray2 = str2.toCharArray();
		if(strArray1.length != strArray2.length) 
			return false;
		Arrays.sort(strArray1);
		Arrays.sort(strArray2);
		int i=0;
		while(i< strArray1.length){
			if(strArray1[i]!=strArray2[i])
				return false;
			i++;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String 1: ");
		String str1 = scan.nextLine();
		System.out.println("Enter String 2: ");
		String str2 = scan.nextLine();
		System.out.println(str1 +" is a Permutation of "+ str2 +": "+ isPermutation(str1, str2));
	}

}
