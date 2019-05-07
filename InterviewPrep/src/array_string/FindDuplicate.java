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

Example
============
Example:
Input: [1, 2, 2, 3]
Output: 2

Input: [3, 4, 1, 4, 1]
Output: 4 or 1

==============
Solution
============
Brute force : Use two loops and compare a[i]==a[j]
Complexity : O(n2)/O(1)
===============
========
1.Maintain a set/array and track count
Complexity : O(n)/O(n)
=================
=====
2. Marking :- Change index sign. If already negative then return true
 Complexity : O(n)/O(1) 
 ================
 ==================
 3. Sort array and compare
 Complexity : O(nLogn)
 =======================
 =====================
 4. Runner : Floyd warshall's algorithm
 Complexity : O(n)/O(1)

 
*/


public class FindDuplicate {
	
	//1. find if set already contains number
	public static boolean setApproach(int[] arr) {
		if(arr ==null ||arr.length == 0 || arr.length ==1) return false;
		Set<Integer> tracker = new HashSet<>();
		
		for(int num : arr) {
			if(tracker.contains(num)) {
				return true;
			}
			
			tracker.add(num);
		}
		
		return false;
	}
	
//2.change sign of number at arr[arr[i]-1] if negative return true	
public static boolean signApproach(int[] arr) {
	if(arr ==null ||arr.length == 0 || arr.length ==1) return false;
	
	for(int i =0 ;i< arr.length -1;i++) {
	int index = arr[i]-1;
	
	if(arr[index] < 0) return true;
	else
		arr[index] = -1 * arr[index];
	}	
	return false;
} 	
	
//4. Runner approach
public static Integer findStartOfCycle(int[] arr) {
	if(arr ==null ||arr.length == 0 || arr.length ==1) return null;
	
	int slow = arr[arr[0]];
	int fast = arr[arr[arr[0]]];
	
	while(slow!=fast) {
		slow = arr[slow];
		fast = arr[arr[arr[fast]]];
	}
	
	System.out.println(slow == fast);
	slow = 0;
	while(slow != fast) {
		slow = arr[slow];
		fast = arr[fast];
	}
	
	return slow;
}
	
	//find all duplicate numbers
	public static Set<Integer> findDuplicateAll(int[] num) {
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
		//System.out.println(Arrays.toString(findDuplicateAll(new int[]{4,3,2,7,8,2,3,1}).toArray()));
		
		System.out.println(findStartOfCycle(new int[]{4,3,5,1,7,2,3,1}));
	}

}
