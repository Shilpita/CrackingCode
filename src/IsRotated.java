/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : May27,2016
 * Problem: Is the given string S2 is rotation of S1
 *          Cracking the Coding Interview
 * ***************************************************************************************/
import java.util.Scanner;

public class IsRotated {

	public static boolean isRotated(String s1 , String s2){
		if(s1.length()!=s2.length() && (s1.length() == 0))
		 return false;
		String s2s2 = s2+s2;
		if(s2s2.contains(s1))
			return true;
		else
			return false;
				
	}
	public static void main(String[] args) {
		Scanner input_String = new Scanner(System.in);
		System.out.println("Enter the String :");
		String s1= input_String.nextLine();
		
		System.out.println("Enter the String :");
		String s2= input_String.nextLine();
		
		System.out.println("Str :" +s1);
		System.out.println("Str :" +s2);
		
		System.out.println(s1 +" is rotation of " +s2 +": "+isRotated(s1,s2));

	}

}
