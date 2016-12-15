package Ex1;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : May21,2016
 * Problem: Determine if input String has Unique characters 
 *          Cracking the Coding Interview
 * ***************************************************************************************/

import java.util.HashMap;
import java.util.Scanner;

public class UniqueCharString {
	
	//The following method checks unique character by O(n) without extra data structure
    public static boolean isUnique(String str){
    	if(str.toLowerCase().length() > 256)
			return false;
    	int checker = 0;
    	for (int i=0 ; i< str.toLowerCase().length() ; i++){
    		int val = str.toLowerCase().charAt(i)- 'a';
    		//System.out.println(Integer.toBinaryString(checker)+ "   " +Integer.toBinaryString((1<<val)));
    		if((checker & (1<<val)) > 0)
    			return false;
    		checker |= (1<<val);
    		//System.out.println("\n "+ Integer.toBinaryString(1<<val)+" "+ (1<<val));
    		System.out.println("\n"+Integer.toBinaryString(checker));
    	}
    	
		return true;	
    }
    
    //The following method checks for unique character by O(n) with extra space data structure
    public static boolean isUniqueHash(String str){
    	HashMap<Character,Integer> h = new HashMap();
    	for (int i=0 ; i< str.toLowerCase().length() ; i++){
    		if(h.containsKey(str.toLowerCase().charAt(i))) 
    			return false;
    		else
    			h.put(str.toLowerCase().charAt(i), 0);
    	}
    	return true;
    }
    

	public static void main(String[] args) {
		Scanner input_String = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str= input_String.nextLine();
		System.out.println("Str :" +str);
		System.out.println("\nThe String input "+str +" has unique character :"+ isUnique(str));	
		System.out.println("\nThe String input "+str +" has unique character :"+ isUniqueHash(str));	

	}

}
