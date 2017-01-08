package Ex1;

import java.util.Scanner;

/********************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan7,2017
 * Problem: OneEdit-> Given two strings, write a function to check if they are one edit (or zero edits) away. 
 *          Cracking the Coding Interview
 * *********************************************************************************************************************/
public class OneEdit {
	public static boolean isOneEdit(String str1 , String str2){
		if(str1== null || str2 == null)
			return false;
		int l1 = str1.length();
		int l2 = str2.length();
		int diff = Math.abs(l1-l2);
		int edits = 0;
		if(diff > 1)
			return false;
		else{
			if(l1 < l2){
				edits = oneReplace(str2,str1);
			}else if(l2 < l1){
				edits = oneReplace(str1,str2);
			}else
				edits = oneReplace(str1,str2);
			
			if(edits > 1)
				return false;
		}	
		return true;
	}
	
	public static int oneReplace(String big , String small){
		int edits =0;
		int j =0;
		for(int i = 0 ; i< big.length();i++){
			if(big.charAt(i)!=small.charAt(j)){
				edits++;
				if(big.length()==small.length())
					j++;
			}else{
				if(j < small.length()-1)
					j++;
			}
		}
		return edits;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter string 1: ");
		//String str1  = scan.nextLine();
		//System.out.println("Enter string 2: ");
		//String str2  = scan.nextLine();
	    System.out.println(isOneEdit("pales",  "ple"));//? "true" : "false"); 
	    System.out.println(isOneEdit("pales", "pale")); // ? "true" : "false"); 
	    System.out.println(isOneEdit("pale",  "bale"));// ? "true" : "false"); 
	    System.out.println(isOneEdit("ale",   "bale")); // ? "true" : "false"); 
	    System.out.println(isOneEdit("xale",  "xal"));// ? "true" : "false"); 
	    System.out.println(isOneEdit("pale",  "bake"));// ? "true" : "false"); 
	}

}
