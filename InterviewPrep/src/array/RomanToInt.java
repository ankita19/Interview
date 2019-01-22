package array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

/**
 * Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
 * @param s
 * @return
 */
public static int romanToInt(String s) {
    
    Map<Character,Integer> valueMap = new HashMap<Character,Integer>();
    valueMap.put('I', 1);
    valueMap.put('V',5);
    valueMap.put('X', 10);
    valueMap.put('L',50);
    valueMap.put('C', 100);
    valueMap.put('D',500);
    valueMap.put('M', 1000);
    
    

    int result =0,nextVal = 0;
    
    for(int index = 0; index < s.length()-1;index++) {
    	
    	if( valueMap.get(s.charAt(index)) < valueMap.get(s.charAt(index+1)))
    		result -= valueMap.get(s.charAt(index));
    	else
    		result +=  valueMap.get(s.charAt(index));
    	
    }
		 
    result += valueMap.get(s.charAt(s.length() -1));
	return result;
}



public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(romanToInt("VII"));
}
}
