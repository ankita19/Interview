package array_string;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	/*Time Complexity: O(n)
	 *Space Complexity: O(n)
	 *Auxiliary Space: O(1)
	 */
	public static int[]  productWithSpace(int[] nums) throws Exception {
		
		if(nums.length == 0) throw new Exception("Empty array");
		int length = nums.length;
		int[] output = new int[length];
		int left  = 1;
		
		
		for(int i= 0 ;i<length;i++) {	
			output[i] = left; 
			left = left * nums[i];
			
		}
		
		int right =1;
		for(int i= length-1;i>=0;i--) {
		output[i] = output[i] * right;
		right = right*nums[i];
		}	
		return output;
	}
	
	// epsilon value to maintain precision 
	/*Time Complexity: O(n)
	 *Space Complexity: O(1)
	 *
	 */
    static final double EPS = 1e-9; 
  
    static void productPuzzle(int a[], int n) 
    { 
        // to hold sum of all values 
        double sum = 0;  
        for (int i = 0; i < n; i++) 
            sum += Math.log10(a[i]); 
  
        // output product for each index 
        // anti log to find original product value 
        for (int i = 0; i < n; i++) 
            System.out.print((int)(EPS + Math.pow(10.00, 
                          sum - Math.log10(a[i]))) + " ");  
    } 
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
System.out.println(Arrays.toString(productWithSpace(new int[]{1,2,3,4})));
	}

}
