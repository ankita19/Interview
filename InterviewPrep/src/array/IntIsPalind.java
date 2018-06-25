package array;

public class IntIsPalind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 * @param x
	 * @return boolean
	 */
	public static boolean isPalindrome(int x) {
		
		if(x< 0 || (x%10 == 0 && x!=0))
			return false;
		int y=0;
		while(y < x) {
		   y = y*10 + x%10; 
		x = x/10;
		}	
		return (x==y) || (x==y/10) ? true:false;
	}






	
}
