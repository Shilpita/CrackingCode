package Ex1;
/**************************************************************************************
 * Author : Shilpita Roy
 * Date   : June5,2016
 * Problem: Replace 0-> Replace the row and column with 0 in a Matrix M*N
 *          Cracking the Coding Interview
 * ***************************************************************************************/
public class MatrixReplace0 {
	
	
	public static void printMatrix(int[][] arr){
		for(int i =0 ; i< arr.length ; i++){
			System.out.println("\n");
			for(int j =0 ; j< arr[0].length;j++)
				System.out.print(arr[i][j] +"\t");
		}
	}
	
	public static void replace0(int[][] arr){
		boolean[] row = new boolean[arr.length];
		boolean[] col = new boolean[arr[0].length];
		for(int i =0 ; i< arr.length ; i++){
			for(int j =0 ; j< arr[0].length;j++)
				if(arr[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
		}
		
		for(int i =0 ; i< arr.length ; i++){
			for(int j =0 ; j< arr[0].length;j++){
				if(row[i] == true || col[j] == true)
					arr[i][j] = 0;
			}
		}
		
	}

	public static void main(String[] args) {
		int[][] arr= {
		        {1,2,3,4},
		        {5,0,7,8},
		        {13,14,1,0}
			 };

		printMatrix(arr);
		replace0(arr);
		System.out.println("\n\n");
		printMatrix(arr);
	}

}
