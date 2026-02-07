package array_string;

import java.util.Arrays;

/*
Problem
=======
Find index of all anagrams of text in a String 
==============
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

=============
Example
============
Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

==============
Solution
============
Brute force
Time Complexity : 
Space complexity :
===============
========
Better
Time Complexity : 
Space complexity :
=================
=====
Optimal
Time Complexity : 
Space complexity :
*/

public class FindAnagram {
	
	
		public static void main(String args[]) { 
			permutation("123"); 
			
			
			} 
		/* * A method exposed to client to calculate permutation of String in Java. */ 
		public static void permutation(String input){ 
			permutation("", input);
		} 
		/* * Recursive method which actually prints all permutations * of given String, 
		 * but since we are passing an empty String * as current permutation to start with, 
		 * I have made this method private and didn't exposed it to client. */
		private static void permutation(String perm, String word) { 
			if (word.isEmpty()) { 
				//System.out.println(perm + word); 
			} 
			else {
				for (int i = 0; i < word.length(); i++) { 
					System.out.println(perm + word.charAt(i) + " == "+word.substring(0, i) + word.substring(i + 1, word.length()));
					
					permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); 
			} 
			} 
		} 
		

	}
