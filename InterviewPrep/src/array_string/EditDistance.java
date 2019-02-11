package array_string;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

	public static boolean bruteForce(String str1 ,String str2) {
		
	if(findDistance(str1,str2) == 2 || findDistance(str1,str2) == 1) 
		return true;
	else 
		return false;
	}
	
	public static int findDistance(String str1, String str2) {
		Map<Character , Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < str1.length() ; i++) {	    
			int count = (map.getOrDefault(str1.charAt(i), 0));
			map.put(str1.charAt(i),++count);
		}
			
		for(int i = 0 ; i < str2.length() ; i++) {	
		if(map.containsKey(str2.charAt(i))) {
				
			int count = map.get(str2.charAt(i));
			
			if(count == 1)
			 map.remove(str2.charAt(i));
			else
				map.put(str2.charAt(i),--count);	
		}
		else {	
			int count = (map.getOrDefault(str2.charAt(i), 0));
			map.put(str2.charAt(i), ++count);
			}
		}
		System.out.println(map.size());
		
		return map.size();
		
	}
	//delete str st
	//insert st  str
	
	public static boolean OneAwayLength(String str , String str2) {
		
		if(str.length() == str2.length())
			return stringDelete(str , str2,false);
		if(str.length() - str2.length() == 1 )
			return stringDelete(str ,str2, true);
		if(str2.length() - str.length() == 1)
			return stringDelete(str2,str,true);
		
		return false;
		
	} 
	
	private static boolean stringDelete(String str, String str2,boolean flag) {
		// TODO Auto-generated method stub
		//abc ac
		int l1 =0;
		int l2 = 0;
		int count = 0;
		boolean foundDiff = false;
		while(l1 < str.length() && l2 < str2.length()){		
			if(str.charAt(l1) != str2.charAt(l2)) {
				if(foundDiff)
					return false;
				foundDiff = true;
				if(flag)
				  {l1++;continue;}
		}
			
			l1++;l2++;
			
	}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(OneAwayLength("rtp", "stp"));
		System.out.println(OneAwayLength("rtp", "rs"));
		System.out.println(OneAwayLength("rt", "rtp"));
		
	}

}
