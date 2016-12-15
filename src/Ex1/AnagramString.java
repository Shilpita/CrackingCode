package Ex1;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : May21,2016
 * Problem: Given string is permutation or anagram the other String 
 *          Cracking the Coding Interview
 * ***************************************************************************************/

import java.util.HashMap;
import java.util.Scanner;

public class AnagramString {
    public static boolean isAnagram(String str1,String str2){
		if(str1.length() != str2.length())	
    	   return false;
		HashMap<Character,Integer> h = new HashMap();
		for(int i =0 ; i< str1.length() ; i++){
		   if(!h.containsKey(str1.charAt(i)))
			   h.put(str1.charAt(i), 1);
		   else
			   h.replace(str1.charAt(i), h.get(str1.charAt(i)), h.get(str1.charAt(i))+1);
		}
		for(int i=0 ; i<str2.length();i++){
			if(h.containsKey(str2.charAt(i))){
				h.replace(str2.charAt(i), h.get(str2.charAt(i)), h.get(str2.charAt(i))-1);
				if(h.get(str2.charAt(i)) <= 0)
					h.remove(str2.charAt(i));
			}
		}
        if(h.isEmpty())
        	return true;
       return false;		
    }
    
	public static void main(String[] args) {
		Scanner input_String = new Scanner(System.in);
		System.out.println("Enter the String1 :");
		String str1= input_String.nextLine();
		System.out.println("Enter the String2 :");
		String str2= input_String.nextLine();
		System.out.println("Str :" +str1 +" length :"+str1.length());
		System.out.println("Str :" +str2 +" length :"+str2.length());
        System.out.println("The string "+ str1 +" and "+str2 +" is anagram :"+ isAnagram(str1,str2));
	}

}
