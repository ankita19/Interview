package dynamicprograming;

import java.util.HashSet;
import java.util.Set;

public class LSubStringNonRepeating {
	
	public static void main(String args[]) {
		
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		
	}
	
	static int LSubString(String str){
		
		int maxLen = 0;
		int currLen = 0;
		Set<Character> strSet = new HashSet<Character>();
		
		if(str.length() == 1)
			return 1;
		
		for(int i = 0 ; i < str.length() ; i++) {
			
			if(strSet.contains(str.charAt(i))) {
				i++;
			if(maxLen < currLen) 
				maxLen = currLen;
			else currLen=0;		
				
			}else {
				strSet.add(str.charAt(i));
				currLen++;
			}
			
		}
		
		return (maxLen > currLen) ? maxLen : currLen;
		
	}

	public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i =0,j=0;
        int ans =0 ;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(arr[j])){
                set.add(arr[j++]);
                ans = Math.max(ans,j-i);
            }else{
                set.remove(arr[i++]);
            }
   }
        
        return ans;
        
    }

}
