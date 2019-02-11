package array_string;

public class IntIsPalind {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println(isPalindrome1(101101));
	
	}

	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 * @param x
	 * @return boolean
	 * 121
	 * 
	 * num mod quo
	 * 121 1   12
	 * 12  2   1 
	 */  
	

			 
			 
	public static boolean isPalindrome1(int x) {
		
		if(x< 0 || (x%10 == 0 && x!=0))
			return false;
		int y=0;
		while(y < x) {
		   y = y*10 + x%10; 
		x = x/10;
		}	
		return (x==y) || (x==y/10) ? true:false;
	}



public static boolean isPalindrome(int x) {
		
	    int num = x;
		if(x< 0 || (x%10 == 0 && x!=0))
			return false;
		int y=0;
		while(x!=0) {
		   y = y*10 + x%10; 
		x = x/10;
		}	
		
		return (num==y) ? true : false;
	}


	
}
