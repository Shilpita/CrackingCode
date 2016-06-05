/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : May29,2016
 * Problem: Compress a given string for eg : aaBBB = a2B3 
 *          Cracking the Coding Interview
 * ***************************************************************************************/


import java.util.Scanner;

public class CompressString {
	public static String isCompressed(String str){
		if(str==null || str.length() <=1)
			return str;
		
		StringBuilder newStr = new StringBuilder();
		boolean flag = false;
		char c = str.charAt(0);
		int count =1;
		
		for(int i = 1 ; i< str.length(); i++){
			if(c==str.charAt(i)){
				count++;
				flag= true;
			}else{
				//newStr = newStr+c+count;
				newStr.append(c);
				newStr.append(count);
				c= str.charAt(i);
				count=1;
			}
		}
		//newStr = newStr+c+count;
		newStr.append(c);
		newStr.append(count);
		
		 if(flag == true)
			 return newStr.toString();
		 else
			 return str;
			
	}

	public static void main(String[] args) {
		Scanner input_String = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str= input_String.nextLine();
		System.out.println("Str :" +str);
        System.out.println("Compressed String :"+ isCompressed(str));
	}

}
