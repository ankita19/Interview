package IK.recursion;

public class RegularExpression {
	
	/*  - abbcdef
	 *  - ab*cdef* 
	 * */
	
	public static boolean regularExpression(String word , String exp ,int i,int j)
	{
			if(j == exp.length()) return i==word.length();
			if(i > word.length()) return false;
		
			if(i < word.length() && word.charAt(i) == exp.charAt(j)) {
				return regularExpression(word,exp,i+1,j+1);
			}
				
			if(exp.charAt(j) =='*') {
				return regularExpression(word,exp,i,j+1)
				|| regularExpression(word,exp,i+1,j);
			} 
			
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(regularExpression("abciott" , "abc*u" , 0 , 0));
	}

}
