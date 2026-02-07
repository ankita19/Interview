package array_string;
import java.util.HashSet;
import java.util.Set;

/*1) count occurrence
 *2) Only 1 char have odd count rest should have even count
 * 
 * */

public class PermutationIsPalindrom {
	
	
     public static boolean hasPalindromPermutation(String theString) {
    		Set<Character> oddChar = new HashSet<>();
    		
    		for(char c : theString.toCharArray()) {	
    			if(oddChar.contains(c))
    				oddChar.remove(c);
    			else 
    				oddChar.add(c);
    			}
    		
			return oddChar.size() <= 1 ? true : false;
    	 
	}

	public static void main(String[] args) {
		System.out.println(hasPalindromPermutation("annaaa"));
	}

}
