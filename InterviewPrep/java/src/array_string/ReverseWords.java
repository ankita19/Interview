package array_string;

public class ReverseWords {
	
	public static void main(String args[]) {
		
		char[] array = {'t','h','e',' ',' ','b','o','o','k',' ','p','l','a','y'};
		
		int start = 0;
		int end = array.length -1;
		array = reverse_char(array , start , end);
		
		System.out.println(array);
		
		for(int i = 0 ; i < array.length; i++) {
		
		if(array[i] == ' ') {
		array = reverse_char(array , start , i-1);
		start = i+1;
			}
	if(i == array.length -1) {
			array = reverse_char(array , start , i);
			start = i+1;
				} 
		}
		
		System.out.println(array);
	
	}
	
	public static char[] reverse_char(char[] array,int start , int end) {
	   
		char value;
		while(start < end) 
		{
		value = array[start];
		array[start] = array[end];
		array[end] = value;
		start = start+1;
		end = end -1;
		
		}	
		return array;
	}

}
