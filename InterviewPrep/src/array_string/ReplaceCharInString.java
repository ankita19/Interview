package array_string;


/*Replace space with %20
 * */
public class ReplaceCharInString {
	
	public static String replaceInString(String str) {
		char[] charStr = str.toCharArray();
		
	    int spaceCount = 1;
	    
	  
		
		for(int i = str.length()-1 ; i >= 0 ; i--) {
		if (charStr[i] == ' ') {	
				
				charStr[i-3] = '0';
				charStr[i-2] = '2';
				charStr[i-1] = '%';
				
				i = 1-3;;
		
		}	
	}
		return charStr.toString();
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(replaceInString("the book"));
		
	}

}
