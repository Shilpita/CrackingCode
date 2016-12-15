package Ex1;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : June3,2016
 * Problem: Rotate given N*N marix by 90
 *          Cracking the Coding Interview
 * ***************************************************************************************/
public class RotateMatrix90 {
	
	public static void rotate90left(int[][] arr){
		int rowLimit = arr.length -1;
		//int colLimit = arr[0].length -1;
		
		for(int i =0 ; i< arr.length/2 ; i++){
			for(int j =i ; j< rowLimit-i;j++){
				int temp  = arr[i][j];
				arr[i][j] = arr[j][rowLimit -i];
				arr[j][rowLimit -i]= arr[rowLimit -i][rowLimit -j];
				arr[rowLimit -i][rowLimit -j]= arr[rowLimit-j][i];
				arr[rowLimit-j][i] = temp;
			}
		}		

	}
	
	public static void rotate90right(int[][] arr){
		int rowLimit = arr.length -1;
		//int colLimit = arr[0].length -1;
		
		for(int i =0 ; i< arr.length/2 ; i++){
			for(int j =i ; j< rowLimit-i;j++){
				int temp  = arr[i][j];
				arr[i][j] = arr[rowLimit-j][i];
				arr[rowLimit-j][i]= arr[rowLimit -i][rowLimit -j];
				arr[rowLimit -i][rowLimit -j]= arr[j][rowLimit -i];
				arr[j][rowLimit -i] = temp;
			}
		}		
	
	}

	public static void main(String[] args) {
		int[][] arr= {
				        {1,2,3,4},
				        {5,6,7,8},
				        {9,10,11,12},
				        {13,14,15,16}
					 };
		
		for(int i =0 ; i< arr.length ; i++){
			System.out.println("\n");
			for(int j =0 ; j< arr[0].length;j++)
				System.out.print(arr[i][j] +"\t");
		}
        System.out.println("\n\n");
		rotate90left(arr);
		for(int i =0 ; i< arr.length ; i++){
			System.out.println("\n");
			for(int j =0 ; j< arr[0].length;j++)
				System.out.print(arr[i][j] +"\t");
		}
        System.out.println("\n\n");
		rotate90right(arr);
		for(int i =0 ; i< arr.length ; i++){
			System.out.println("\n");
			for(int j =0 ; j< arr[0].length;j++)
				System.out.print(arr[i][j] +"\t");
		}
		
		 System.out.println("\n\n");
			rotate90right(arr);
			for(int i =0 ; i< arr.length ; i++){
				System.out.println("\n");
				for(int j =0 ; j< arr[0].length;j++)
					System.out.print(arr[i][j] +"\t");
			}
		
	}

}
