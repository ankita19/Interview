package string;

import java.util.Arrays;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] A = {1,2,3};
     
     perm(A,0,3);
		
	}
/*
 * O(n*n!) Note that there are n! permutations and 
 * it requires O(n) time to print a a permutation.
 * */
	public static void perm(int A[],int k, int n) {
		
		if(k==n)
         System.out.println(Arrays.toString(A));
		else {
			for(int i = k ; i<n;i++) {
				int t ;
				System.out.println("inside loop "+k + ":" + i+A[k] + ":" +A[i]); 
				t = A[k];
				 
				A[k] = A[i];
				A[i] = t;
				perm(A,k+1,n);
				System.out.println(k + ":" + i + ":"+ t);
				 t = A[k];
				 System.out.println("value - "+A[k] + ":" +A[i] + ":"+ t);
				 
				A[k] = A[i];
				A[i] = t;
				System.out.println("End loop : "+Arrays.toString(A));
			}
		}
	}
	
}
