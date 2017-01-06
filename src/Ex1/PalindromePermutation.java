package Ex1;

import java.util.HashMap;
import java.util.Scanner;

/**********************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Jan5,2017
 * Problem: PalindromePermutation-> Given a string, write a function to check if it is a permutation of a palindrome. 
 *          Cracking the Coding Interview
 * ***********************************************************************************************************************/
public class PalindromePermutation {
	public static boolean isPalindromePermutation(String str){
		if(str == null || str.length() <=1)
			return false;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char[] c = str.toCharArray();
		for(int i =0 ; i< c.length;i++){
			if(!Character.isLetter((Character)c[i]))
				continue;
			if(map.containsKey(Character.toLowerCase(c[i])))
				map.put(Character.toLowerCase(c[i]), map.get(Character.toLowerCase(c[i]))+1);
			else
				map.put(Character.toLowerCase(c[i]),1);
		}
		int oddOccurences =0;
		for(Character ch: map.keySet()){
			if(map.get(ch)%2 > 0)
				oddOccurences++;
		}
		if(oddOccurences > 1)
			return false;
		return true;	
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String:");
		String str = scan.nextLine();
		System.out.println(str +" is a palindrome permutation : "+ isPalindromePermutation(str));
	}

}
