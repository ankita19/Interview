package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromString {
	//Print palindrom
	//T= n^n
	//S =n
	public void printPalindromString(String str) {
		
		if(str.length() == 0) return;	
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>();
		
		palindromHelper(str,0,"",result);
		String[] soln = new String[result.size()];
		System.out.println(Arrays.toString(result.toArray(soln)));
	}

	
	
	public  void palindromHelper(String str,int start,String substr,List<String> result) {
		int end = str.length();
		if(start == end)
		{
			result.add(substr.substring(1)); 
			return;
		}
		
		for(int i = start ; i < str.length() ; i++) {
			
			if(isPalindrom(str,start,i)) {
				palindromHelper(str,i+1, substr + "|" + str.substring(start, i+1),result);
			}
			
		}
		
		
	}
	
	public boolean isPalindrom(String str,int start,int end) {	
		
		
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end))
				return false;
			else {
				start++;
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromString obj = new PalindromString();
		obj.printPalindromString("abab");
		
	}

}
