package array;

import java.util.Arrays;

public class MaxSubArray {
	
	//Positive numbers
	public static int findMaxSum(int[] num) {
		if(num.length ==0) return 0;
		int max_sum = 0;
		int max_curr = 0;
		int start = 0 ,end = 0;
		 for(int i=0; i< num.length ; i++) {
			 max_curr = Math.max(num[i], max_curr+num[i]);
			 
			 if(max_curr < 0) {
				 start = i+1;
				 max_curr =0;
			 }
			 
			 if(max_sum < max_curr) {
				 max_sum = max_curr;
				 end =i;
			 }
		 }
		 System.out.println(Arrays.toString(Arrays.copyOfRange(num,start,end+1)));
		 return max_sum;
	}
	
	//Positive numbers
		public static int findMaxSumNeg(int[] num) {
			if(num.length ==0) return 0;
			int max_sum = num[0];
			int max_curr = num[0];
			int start = 0 ,end = 0;
			
			 for(int i=1; i< num.length ; i++) {
				 max_curr = Math.max(num[i], max_curr+num[i]);
				 
				/* 
				 if(max_curr < 0) {
					 start = i+1;
					 max_curr =0;
				 }
				 
				 if(max_sum < max_curr) {
					 max_sum = max_curr;
					 start=end =i;
				 } */
				max_sum = Math.max(max_sum,max_curr );
			 }
			// System.out.println(Arrays.toString(Arrays.copyOfRange(num,start,end+1)));
			 return max_sum;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(findMaxSum(new int[] {-2,-3,4,-1,-2,1,5,}));
		
		System.out.println(findMaxSumNeg(new int[] {-2,-3,-4,-1,-5,}));
	}

}
