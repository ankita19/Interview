package array_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	
	 public static String mostCommonWord(String paragraph, String[] banned) {
	        
	        String[] listWords = paragraph.split("[^a-zA-Z]");
	        Set<String>bannedSet = new HashSet<>(Arrays.asList(banned)); 
	        int currCount=0;
	        String freqWord="";
	        int max =0;
	        Map<String,Integer>words = new HashMap<>();
	        
	        for(String word  : listWords) { 
	        	System.out.println(word);
	        	
	        	if(!bannedSet.contains(word) && word.trim().length() > 0) {
	        		
	        		currCount = words.getOrDefault(word, 0)+1;
	        		words.put(word, currCount);
	        		
	        		if(currCount > max) {
	        			max = currCount;
	        			freqWord = word;
	        		}
	        		}
	        }
	       
	        return freqWord;
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(mostCommonWord("ant}}} asd",new String[] {"hit","bob"}));
		
	}

}
