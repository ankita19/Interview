package array_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author anshuljain
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		 
		System.out.println(LCPH(new String[]{"thee","thhhhe","the"}));
		

	}


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @param str
 * @return
 */
public static String LCPH(String str[]) {
	
	if(str.length == 0 ) return "";
	String prefix = str[0];	  

	for(int strIndex = 1 ; strIndex < str.length ; strIndex++ ) {	
	      while(str[strIndex].indexOf(prefix) !=0) {	
	          	prefix = prefix.substring(0 , prefix.length()-1);
		        if(prefix.isEmpty()) return "";
	}
	}
	return prefix;
}




}