package array_string;

import java.util.Arrays;
import java.util.HashSet;

import java.util.Set;

/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
 * 
 * precaution :index =  num[i] -1 
 * 
 * */


public class FindDuplicate {
	
	public static Set<Integer> findDuplicate(int[] num) {
		Set<Integer> dups = new HashSet<Integer>();
		
		if(num.length ==0) return dups;
		
		for(int i= 0 ; i< num.length ;  i++) {
			int index = Math.abs(num[i]) -1;
			
			if(num[index] < 0 ) {
			dups.add(num[index]);	
			}else
				num[index] = -(num[index]);
			
		}
		
		return dups;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(findDuplicate(new int[]{4,3,2,7,8,2,3,1}).toArray()));
	}

}
