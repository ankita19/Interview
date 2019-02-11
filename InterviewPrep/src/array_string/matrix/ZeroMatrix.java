package array_string.matrix;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {
	
	public static void zeroMatrix(int[][] arr , int m , int n) {
		Set<Integer>colSet = new HashSet<>();
		Set<Integer>rowSet = new HashSet<>();
		for(int i= 0 ; i< m ; i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 0 && !rowSet.contains(i) && !colSet.contains(j)) {	
					rowSet.add(i);
					colSet.add(j);
					for(int k = 0 ; k < m ;k++) {
						 arr[k][j] =0;
					}
					for(int l = 0 ; l < n ;l++) {
						 arr[i][l] =0;
					}
				} 
			}
		}
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = {{1,2,3,4,5},
	 			{6,7,8,9,10},
	 			{11,2,3,4,15},
	 			{16,2,0,4,20},
	 			{21,2,3,4,25}
	 			};


System.out.println("befor rotate");
printArray(arr);
zeroMatrix(arr, 5, 5);
System.out.println("After rotate");
printArray(arr);
	}

}
