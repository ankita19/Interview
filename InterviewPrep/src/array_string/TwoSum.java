package array_string;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		int[] arr = {1,2,3,4};
		System.out.println(twoSum(10, arr));
		
	}

	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	 *Complexity O(n2)
	 * 
	 */	
//1. Naive
	public static int[] twoSum(int[] nums, int target) {      
        for(int i = 0 ; i < nums.length ; i++){
           for(int j = i+1 ; j < nums.length ; j++){
             if(nums[i] + nums[j] == target){
               return new int[]{i,j};      
             }
           } 
        }
		return new int[1];
	}
	// 2. Hash table
public static int[] twoSumHash(int[] nums, int target) {      
	Map<Integer,Integer> numMap = new HashMap();
	for(int i = 0 ; i < nums.length ; i++){
      int complement = target - nums[i];

      if(numMap.containsKey(complement))
    	  return new int[] {
    			  numMap.get(complement),i};
    	  
      numMap.put(nums[i], i);
      }
    
	throw new IllegalArgumentException("No value found");
}

//3. Sorting
public static boolean twoSum(int target,int[] nums) {
	int f=0,r= nums.length-1;
	
	while(f  < r) {
		if(nums[f] + nums[r] - target == 0)
			return true;
		if(nums[f] + nums[r] - target > 0)
			r--;
		if(nums[f] + nums[r] - target  < 0)
			f++;
	}
	return false;
	
}
//4. three sum
public static boolean threeSum(int target,int[] nums) {
	int f=0,r= nums.length-1;
	
	while(f  < r) {
		if(nums[f] + nums[r] - target == 0)
			return true;
		if(nums[f] + nums[r] - target > 0)
			r--;
		if(nums[f] + nums[r] - target  < 0)
			f++;
	}
	return false;
	
}
	
}
