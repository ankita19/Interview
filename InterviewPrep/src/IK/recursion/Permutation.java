package IK.recursion;

import java.util.Arrays;

public class Permutation {

	public static void findPermutation(int[] a) {
		
		helper(a,0);
	}
	
	public static void helper(int[] a, int j) {
		
		if(j==a.length-1) {
			System.out.println(Arrays.toString(a));
			return;
		}
		
		for(int curr = j ; curr < a.length;curr++) {
		
			swap(a,curr,j);
			helper(a,j+1);
			swap(a,curr,j);
			
		}
	}
	
	public static void swap(int[] a, int i ,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			findPermutation(new int[] {1,2,3});
	}

}
