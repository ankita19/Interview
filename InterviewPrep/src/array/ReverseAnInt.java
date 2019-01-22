package array;

public class ReverseAnInt {
	
	/**Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:

	Input: 123
	Output:  321
	Input : 1534236469
	Output: 0
	 * @param num
	 * @return Int
	 */

	public static int reverseInt(int x) {
	    int y = 0;

	    while(x != 0) {
	        int yy = y*10 + x%10;

	        if ((yy - x%10)/10 != y) return 0;
	        else y = yy;

	        x = x/10;   
	    }
	    return y;
	}
	
	public static int reverser2(int x) {		
		int y =0;
		while(x != 0) {	
			int tail = x%10;
			int tmpResult = y*10 + tail;
			//to check for overflow and underflow
			if((tmpResult - tail )/10 != y) return 0;
			 y = tmpResult;
			x = x/10;
		}
		return y;
	}

	public static void main(String args[]) {
		
		System.out.println(reverser2(2147483641));

	}
}
