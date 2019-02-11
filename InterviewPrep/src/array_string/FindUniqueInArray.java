package array_string;

public class FindUniqueInArray {

	public static char unique_str(String str) {
		int carry = 0;
		
		for(char c : str.toCharArray()) {
			
			carry ^=c;
		}
		
		return (char)carry;
	}
	
	public static int unique_int(int[] num) {
		int carry = 0;
		int carry2 =0;
		for(int i=0;i<num.length ; i++) {
			
			carry ^=num[i];
			carry2 |= (1 << num[i]);
			System.out.println(carry + " "+ carry2);
		}
		return carry;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(unique_str("qqqqq"));
		System.out.println(unique_int(new int[]{1,2,2,3,3,8,8,1,3}));
	}

}
