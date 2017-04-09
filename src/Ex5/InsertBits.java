package Ex5;
/**************************************************************************************************************************
 * author : Shilpita Roy
 * date   : April 8,2017
 * purpose: Isertion: Given 32bit m and n values and position j and i, insert m in n from position j to i. 
 * 			Cracking the Coding Interview
 * ************************************************************************************************************************/
public class InsertBits{
	private static int insertBitsPosition(int a, int b, int j, int i) {
		if(a == 0)
			return b;
		
		int allones = ~0; // all 32 bits set as 1 will be created
//		String str = String.format("%16s", Integer.toBinaryString(allones)).replace(" ", "0");
//		System.out.println(str);
		
		// set all the bits after j+1 bits is set to 0. 
		//Note: j+1 position because least significant bit (leftmost bit) is 0th position
		int leftmostbits = allones <<(j+1); // set all 8th position afterwards 0
//		str = String.format("%16s", Integer.toBinaryString(leftmostbits)).replace(" ", "0");
//		System.out.println(str);
		
		//set all bits from ith position to 0 as 1
		int rightmostbits = (1<<i)-1; 
//		str = String.format("%16s", Integer.toBinaryString(rightmostbits)).replace(" ", "0");
//		System.out.println(str);
		
		//Create mask with all j to 1 position set to 0 and rest as 1
		int mask = leftmostbits | rightmostbits;
//		str = String.format("%16s", Integer.toBinaryString(mask)).replace(" ", "0");
//		System.out.println(str);
		
		int a_cleared = a & mask; //clears all j to i position of a as 0
//		str = String.format("%16s", Integer.toBinaryString(a)).replace(" ", "0");
//		System.out.println(str);
//		str = String.format("%16s", Integer.toBinaryString(a_cleared)).replace(" ", "0");
//		System.out.println(str);
		
		int b_cleared = b << i ; // all significant bits of b sifted to i position
//		str = String.format("%16s", Integer.toBinaryString(b)).replace(" ", "0");
//		System.out.println(str);
//		str = String.format("%16s", Integer.toBinaryString(b_cleared)).replace(" ", "0");
//		System.out.println(str);
		
		return a_cleared | b_cleared;
	}
	
	
	
	public static void main(String[] args) {
		int a = (1<<12);
		int b = 19;
		String str1 = String.format("%16s", Integer.toBinaryString(a)).replace(" ", "0");
    	String str2 = String.format("%16s", Integer.toBinaryString(b)).replace(" ", "0");
    	System.out.println("a = " +str1);
    	System.out.println("b = " +str2);
    	int result = insertBitsPosition(a,b,7,3);
    	String str3 = String.format("%16s", Integer.toBinaryString(result)).replace(" ", "0");
    	System.out.println("Result after b inserted in a from 7 to 3 position : " +str3);
    	
	}
}
