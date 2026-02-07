package array_string;

import java.util.Arrays;

public class StringCompression {


	//Space O(N) , Time O(N) 
	public static String stringComp(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		boolean change = false;
		for(int i =0 ; i < str.length() ; i++) {
			count++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i)).append(count);		
				if(count > 1) change = true;
				count = 0;
				
				
			}
		}
		
			return sb.length() < str.length() ? sb.toString() : str;
	//	return (change == true) ? sb.toString() : str;
	}
	
	
	//Time O(N) Space O(1)
	
	public static int spaceCompression(char[] str) {
		int read =0;
		int write =0;
		
		while(read <str.length && write < str.length) {	
			char currentChar = str[read];
			int count = 0;
			while(read < str.length && currentChar == str[read] ) {
				count++;
				read++;
			}
				
			str[write++] = currentChar;
			if(count>1)
			{
				System.out.println(count);
				char c = Integer.toString(count).toCharArray()[0];
			    str[write++] = c;
			}
			
			
		}
		
		
		System.out.println(Arrays.toString(str) + write + " "+str.toString());
		return write;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringComp("ssttmuuuu"));
		spaceCompression("srttt".toCharArray());
	}

}
