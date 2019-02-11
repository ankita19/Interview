package array_string;

import java.util.HashMap;
import java.util.Map;

public class IfPermutation {
	
	
	public static boolean checkPermutationXOR(String str1,String str2) {
		
		int checker = 0;
		
		if(str1.length() != str2.length()) return false;
		
		for(int i =0 ; i <  str1.length() ; i++) {
			checker ^= str1.charAt(i);
		}
		
		for(int i =0 ; i <  str2.length() ; i++) {
			checker ^= str2.charAt(i);
		}
		
		return (checker == 0 )?true : false;
	}
	
	public static boolean checkPermutation(String str1,String str2) {
		int[] checker = new int[26];
		int count = 0;
		
        if(str1.length() != str2.length()) return false;
		
		for(int i =0 ; i <  str1.length() ; i++) {
			char c = str1.charAt(i);
			 checker[str1.charAt(i)]++;
		}
		
		for(int i =0 ; i <  str2.length() ; i++) {
			checker[str2.charAt(i)]--;
		}
		
		for(int i =0; i< 26 ; i++) {
			if(checker[i] > 0) return false;
		}
		
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkPermutationXOR("str","ryt"));
	}

}
