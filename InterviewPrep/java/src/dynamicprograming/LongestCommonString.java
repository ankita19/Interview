package dynamicprograming;

public class LongestCommonString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "ABC";
		String s2 = "C";
		int l1 = s1.length();
		int l2 = s2.length();
		lcSubstring(s1, s2, l1, l2);

	}

	
	public static void lcSubstring(String s1 ,String s2 , int l1, int l2) {
		
		int[][] lcs = new int[l1+1][l2+1];
		int result = 0;
		for(int i=0 ; i <= l1 ; i++ ) {
			for(int j =0 ; j <= l2 ; j++)
			{
			
				if(i==0 || j==0) {
					lcs[i][j] = 0;
				}else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs[i][j] = 1 + lcs[i-1][j-1];
					result = Math.max(result,lcs[i][j]);
					
			    // System.out.println(s1.charAt(i-1));
				}else
					lcs[i][j] = 0;
		}}

		System.out.println(result);
	
	StringBuilder sb = new StringBuilder();
	
	int i = l1 ;
	int j = l2;
	
	while(i > 0 && j > 0) {
		
		if (s1.charAt(i-1) == s2.charAt(j-1)) {
			System.out.println(s1.charAt(i-1));
		}
		
		i--;
		j--;
		
	}
	
	
	
	
	
		
	}
	
	
	
	
	
}
