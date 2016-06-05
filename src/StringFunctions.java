
public class StringFunctions {

	public static void main(String[] args) {
		String str = new String("Hallo world");
		System.out.println("String : "+str);
		System.out.println("toCharArray  :");
		System.out.println(str.toCharArray() + " "+ str.charAt(1));
		System.out.println("chat at: "+ (int)(str.charAt(1)-'a'));
		
		Integer checker =new Integer(str.charAt(8)-'a');
		checker |= 1<<checker;
		System.out.println("\n " + Integer.toBinaryString(checker));
		char[] arr = str.toCharArray();
		
		System.out.println(arr.length + "  "+ str.length());
		
		String newStr = arr.toString();
		System.out.println(arr.length + "  "+ str.length()+ " " + newStr + newStr.length());
		
		
		
		
		int[][] arr1= {
		        {1,2,3,4},
		    //    {5,6,7,8},
		        {9,10,11,12}
			 };

		System.out.println("array length "+ arr1.length);
		System.out.println("array length "+ arr1[0].length);
		
	}

}
