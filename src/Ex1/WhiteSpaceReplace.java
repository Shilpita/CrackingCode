package Ex1;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : May22,2016
 * Problem: Replace the whitespace in the string with '%20' 
 *          Cracking the Coding Interview
 * ***************************************************************************************/
import java.util.Scanner;

public class WhiteSpaceReplace {
    public static String replaceWhiteSpace(String str){
    	if(str == null)
    		return null;
    	String newStr ="";
    	//str= str.replace(" ", "%20");
    	for(int i = 0 ; i< str.length();i++){
    		if(str.charAt(i)== ' ')
    			newStr+= "%20";
    		else
    			newStr+= str.charAt(i);
    	}
    	
		return newStr;	
    }
    
    public static String replaceCharArr(String str){
    	if(str == null)
    		return null;
    	String newStr ="";
    	//char[] arr = str.toCharArray();
    	int newLength =0;
    	for (int i =0 ;i< str.length();i++){
    		if(str.charAt(i)==' ')
    			newLength++;
    	}
    	newLength = 2*newLength +str.length();
    	char[] newArr = new char[newLength];
    	//newArr[newLength] = '\0';
    	for(int i = str.length()-1; i>=0 ; i--){
    		if(str.charAt(i)==' '){
    			newArr[newLength-1]= '0';
    			newArr[newLength-2]='2';
    			newArr[newLength-3]='%';
    			newLength = newLength -3;
    		}
    		else{
    			newArr[newLength-1]= str.charAt(i);
    			newLength = newLength -1;
    		}
    	}
    	for(int i =0 ; i<newArr.length ; i++){
    		newStr = newStr + newArr[i];
    	}
		return newStr;
    	
    }
    
	public static void main(String[] args) {
		Scanner input_String = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str= input_String.nextLine();
		System.out.println("Str :" +str);
		System.out.println("Str with replacement:" +replaceWhiteSpace(str));
		System.out.println("Str with replacement:" +replaceCharArr(str));
	}

}
