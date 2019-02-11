package array_string.matrix;

public class Rotate90 {

	public static boolean rotate90Clock_inPlace(int[][] a){

		int n = a.length;
		if(n==0) return false;
		for(int i =0 ; i< n/2 ;i++) {
			for(int j=i;  j<= n-2-i ; j++) {
				int tmp = a[i][j];
				a[i][j] = a[n-1-j][i];
				a[n-1-j][i] = a[n-1-i][n-1-j];
				a[n-1-i][n-1-j] = a[j][n-1-i];
				a[j][n-1-i] = tmp;
				
			} 
			
		}
		return false;
		
	}
	
	public static void printArray(int[][] arr) {
		for(int i = 0 ; i< arr.length ; i++)
		{
			for(int j=0 ; j <arr.length ; j++) {
			
				System.out.print(arr[i][j] + "  ");
				
			}
			System.out.println();
		}
	}
	
	public static void print90Clock(int[][] arr) {
		for(int i = 0 ; i< arr.length ; i++)
		{
			for(int j=0 ; j <arr.length ; j++) {
			
				System.out.print(arr[j][i] + "  ");
				
			}
			System.out.println();
		}
	}
	
	public static void print90AntiClock(int[][] arr) {
		for(int i = arr.length -1 ; i >=0 ; i--)
		{
			for(int j= arr.length -1 ; j>=0 ; j--) {
			
				System.out.print(arr[j][i] + "  ");
				
			}
			System.out.println();
		}
	}
	
	public static void printTest(int[][] arr) {
		for(int i = arr.length -1 ; i >=0 ; i--)
		{
			for(int j=0 ; j < arr.length ; j++) {
			
				System.out.print(arr[j][i] + "  ");
				
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] arr = {{1,2,3,4,5},
			 			{6,7,8,9,10},
			 			{11,2,3,4,15},
			 			{16,2,3,4,20},
			 			{21,2,3,4,25}
			 			
			 			};
		
		
		System.out.println("befor rotate");
		printArray(arr);
	/*System.out.println("print rotated clock");
		print90Clock(arr);*/
		System.out.println("print rotated anti clock");
		print90AntiClock(arr);
		
		/*rotate90Clock_inPlace(arr);

		System.out.println("after rotate");
		printArray(arr); */
		System.out.println("print test clock");
		printTest(arr);
		}
		
	

}
