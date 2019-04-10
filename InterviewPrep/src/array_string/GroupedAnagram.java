package array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupedAnagram {
	
	/*
Problem
==============
Given an array of strings, group anagrams together.

Note:
All inputs will be in lowercase.
The order of your output does not matter
=============
Example
============
Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
==============
Solution
============
Brute force
------------------
Time Complexity : O(mnlogn)
Space complexity : O(mn)
Time Complexity: O(NKlog K)O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs. 
The outer loop has complexity O(N)O(N) as we iterate through each string. 
Then, we sort each string in O(KlogK)O(KlogK) time.
Space Complexity: O(NK)O(NK), the total information content stored in ans
->->
1) Sort words
2) add in HashMap <String ,List<String>>
3) return list
========


Better (No Sorting - use count array and use as key)
--------------
Time Complexity : O(mn)
Space complexity :O(mn)
=================

1) fill count array for each char by c-'a'
2) add count array as key
3) return values
=====
Optimal
Time Complexity : 
Space complexity :
*/
//by sorting words
	public static List<List<String>> groupAnagram(String[] words){
		if(words.length == 0) return new ArrayList<>();
	List<List<String>> output = new ArrayList<>();
		
		Map<String , List<String>> anagramMap = new HashMap<>();
		for(String str : words) {
			char[] charStr = str.toCharArray();
			Arrays.sort(charStr);
			String sorted = new String(charStr);
			if(!anagramMap.containsKey(sorted)) {
				
				anagramMap.put(sorted, new ArrayList<>());
			}
			anagramMap.get(sorted).add(str);
		}
		
		output.addAll(anagramMap.values());
		return output;
	}
	
//by maintaining count array	
	public static List<List<String>> groupAnagramCountArray(String[] words){
		if(words.length == 0) return new ArrayList<>();
	List<List<String>> output = new ArrayList<>();
		
		Map<int[] , List<String>> anagramMap = new HashMap<>();
		
		for(String str : words) {
		
			int count[] = new int[26];
			Arrays.fill(count ,0);
			
			for(char c: str.toCharArray()) count[c-'a']++;
	
			if(!anagramMap.containsKey(count)) {
				
				anagramMap.put(count, new ArrayList<>());
			}
			anagramMap.get(count).add(str);
		}
		
		output.addAll(anagramMap.values());
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
