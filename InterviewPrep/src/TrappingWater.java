
public class TrappingWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
	
public static int trap(int[] height) {
   
	    int sum = 0;
	    int left = 0, right = height.length - 1;

	    int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
	    while(left < right) {
	        maxLeft = Math.max(maxLeft, height[left]);
	        maxRight = Math.max(maxRight, height[right]);
	        if(maxLeft < maxRight) {
	            sum += maxLeft - height[left++];
	            maxLeft = Math.max(maxLeft, height[left]);
	        } else {
	            sum += maxRight - height[right--];
	            maxRight = Math.max(maxRight, height[right]);
	        }
	    }

	    return sum;
	}

}
