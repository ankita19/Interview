package string;

public class ValidateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(validate_number("12ee3"));
		
		
	}

	
	public static boolean validate_number(String s) {
		int i =0;
		int l = s.length();
		
		if(s.length() == 0)
			return false;
		
		while(i < l && s.charAt(i) == ' ')
			i++;
		
		if(i< l && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			i++;
		
		boolean validNum = false;
		
		while(i < l && Character.isDigit(s.charAt(i))) {
			i++;
			validNum = true;
		}
		
		if(i < l && s.charAt(i) == '.') {
			i++;	
		while(i < l && Character.isDigit(s.charAt(i))) {
			i++;
			validNum = true;
		}
		}
		
		if(validNum && i < l && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
			i++;
			validNum=false;
			while(i < l && Character.isDigit(s.charAt(i))) {
				i++;
				validNum = true;
			}
			
			
		}
		
		while(i < l && s.charAt(i) == ' ')
			i++;
		
		
		return validNum && i == l;
		
	}
	
}
