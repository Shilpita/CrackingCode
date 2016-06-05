/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : May21,2016
 * Problem: Reverse the String 
 *          Cracking the Coding Interview
 * ***************************************************************************************/
import java.util.Scanner;

public class ReverseString {
	public static String reverseString(String str){
        int end = str.length()-1;
        int start =0;
        char[] tempArray = str.toCharArray();
        while(start < end) {
        	char temp 			= tempArray[start] ;        
        	tempArray[start]	= tempArray[end];
        	tempArray[end]	= temp;
        	start++;
        	end--;
        	//System.out.println(str);
        }
        str ="";
        for(char c :tempArray){
        	str= str+c;
        }
        	
       System.out.println(str);
		return str;
		
	}

	public static void main(String[] args) {
		Scanner input_String = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str= input_String.nextLine();
		System.out.println("Str :" +str +"length :"+str.length());
		System.out.println("reverse string :"+ reverseString(str)+"length :"+reverseString(str).length());
	}

}
