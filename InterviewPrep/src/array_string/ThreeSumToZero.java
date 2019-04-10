package array_string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumToZero {

	public static void main(String[] args) {
		
		int[] num = {1,2,-3,6,8,-8};
		
		//sumToZero(num);
		
		sumToZeroSorting(new int[]{-1,-7,0,1,3,4});
		

	}

	//pass all test case    
	public List<List<Integer>> threeSum2(int[] num) {
        
	      Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	    public List<List<Integer>> threeSum(int[] nums) {
	        
	        if(nums ==null || nums.length == 0) return new ArrayList<>();
	              
	        List<List<Integer>> result = new ArrayList<>();
	        int arraySize = nums.length;
	       
	        Arrays.sort(nums);
	        
	        for(int i=0;i< arraySize - 2 ;i++){//--1
	            
	            if(i==0 || nums[i] > nums[i-1]){
	            	  int start =i+1 , end = arraySize -1;
	                       
	            while(start < end){
	                System.out.println(nums[i] +" "+ nums[start]+" "+nums[end]);
	                
	                if(nums[i] + nums[start]+nums[end] == 0){      
	                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
	                    while( start < end && nums[start] == nums[start+1]) start++;
	                    while( start < end && nums[end] == nums[end - 1]) end --;
	                    start++;end--;
	                }
	                else if(nums[i] + nums[start]+nums[end] < 0){
	                    start++;
	                }
	                else
	                    end--;     
	            }//-1 while
	                      
	        }//end of 1 for
	        
	        }
	        return result;
	        
	    }
	
	
	public static void sumToZero(int[] num) {
		
		HashSet<Integer> compNum = new HashSet<Integer>();
		
		for(int i = 0 ; i< num.length-1 ; i++) {
			for(int j = 1 ; i< num.length ; i++) {
				
				if(compNum.contains(-(num[i] + num[j])) ) {
					System.out.println(num[i] +" : "+ num[j] + " : " + -(num[i]+num[j]));
					}
				else
					compNum.add(num[i]);
				
			}
		}
		
	}
	
	public static void sumToZeroSorting(int[] num) {
		
	for(int i = 0;i < num.length;i++) {
		int r = num.length -1;
		int s = i+1;
		
			while(s<r) {
				if(num[i]+num[s]+num[r] == 0) {
					System.out.println(num[i]+ " , "+num[s]+" , "+num[r]);
					r--;
					s++;
				}else  if(num[i]+num[s]+num[r] < 0)
					s++;
				else
					r--;
			}
		} 
	}
}
