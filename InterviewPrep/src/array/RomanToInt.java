package array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

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
    
    
    int index = 0;
    int result =0,nextVal = 0;
    
    while(index < s.length()) {
    	result = valueMap.get(s.charAt(index));
    	nextVal = valueMap.get(s.charAt(index+1));
    	if( result <  nextVal){
    		result = result - nextVal;
    		}
    	else
    		result =  result+nextVal;
    	index += 2;
    }
		    
	return result;
}

}
