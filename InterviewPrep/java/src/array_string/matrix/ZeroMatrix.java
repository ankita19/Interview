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

	
	public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int column = 0;
        for(int row = 0 ; row < matrix.length;  row++){
        	
        	System.out.print("Row--"+ row);
        	
            for(int col = column ; col < matrix[row].length ; col++){
                
            	System.out.print("Row--col--"+ row +" "+col);
            	
                if(matrix[row][col] == 0) {
                            for(int i = 0; i < matrix[row].length ; i++){
                                matrix[row][i] =0;
                            }
                    
                     for(int i = 0; i < matrix.length ; i++){
                                matrix[i][col] =0;
                            }
                    
                    row = row+1;
                    column = col+1;
                }
            }
            
        }
        
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr1 = {{1,2,3,4,5},
	 			{6,7,8,9,10},
	 			{11,2,3,4,15},
	 			{16,2,0,4,20},
	 			{21,2,3,4,25}
	 			};
		
		
		int [][] arr =  {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

/*
System.out.println("befor rotate");
printArray(arr);
zeroMatrix(arr, 5, 5);
System.out.println("After rotate");
printArray(arr); */
		
		setZeroes(arr);
		
	}

}
