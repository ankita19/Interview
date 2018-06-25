package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NonRepeatatedChar {

	static NonRepeatatedChar nb = new NonRepeatatedChar();
	static int  resultIndex = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
	String s = "loveleetcode";		
    char [] input = s.toCharArray();
    
   // System.out.println(nonRepeatedCharWithMap(input));
    
    System.out.println(s.charAt(firstUniqChar(s)));
	}

	
/*
 * Complexity space o(n)
 * time o(n)  + o(n) 
 * */		
	public static char nonRepeatedCharWithMap(char[] input) throws Exception {

		Map<Character, Integer> inputMap = new HashMap<Character,Integer>();
		inputMap.put(input[0], 1);
		
		for(int i = 1 ; i< input.length ; i++) {
			char c = input[i];
			if(inputMap.get(c) != null) {
				inputMap.put(c, inputMap.get(c)+1);
			}
			else
			inputMap.put(c , 1);
		}
		
		for(char c : input) {
			
			if(inputMap.get(c) == 1) {
				return c;
			}
		}		
		 throw new Exception("No unique char is present");
	}

/**
 * Approach 2
 * O(n)
 * */	
	
	static Map<Character,IndexCount> charMap = new HashMap<Character,IndexCount>(); 
	
	class IndexCount{
        int index = 0;
        int count =1;

    IndexCount(int i){
    	   index = i;
    	   count =1;
    }    
        
    void incCount(){
         count++;
    }    
	}
    
    public static void countChar(String s){
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(charMap.get(c) !=null){
                charMap.get(c).incCount();
            }else{
                charMap.put(c,nb.new IndexCount(i));
            }
        }   
    }
    
    public static int firstUniqChar(String s) {
        countChar(s);
        charMap.forEach( (k,v) -> {
        	if( (v.count == 1) && resultIndex > v.index ) {
        		resultIndex = v.index;
        	}
        });  
        return resultIndex != Integer.MAX_VALUE ? resultIndex : -1;
    }
	
}
