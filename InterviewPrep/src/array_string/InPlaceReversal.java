package array_string;

public class InPlaceReversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] str={'t','e','s','r'};
		reverse(str);
       System.out.println(str);
	}
	
	
	static void reverse(char[] array) {
		int start = 0;
		int last = array.length-1;
		char value;
		
		while (start < last) {	
			value = array[start];
			array[start]= array[last];
			array[last] = value;
			
			System.out.println(start + " === "+last);
			
			start = start+1;
			last = last -1;
		}
		
	}
	
}
