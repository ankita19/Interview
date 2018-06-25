package dynamicprograming;

public class LCSubsequence {

	 static int[][] lcs;
	 static StringBuilder lcsString = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "ABC";
		String s2 = "BBC";
		int l1 = s1.length();
		int l2 = s2.length();
		lcs = new int[l1+1][l2+1];
		
		System.out.println(lcsLength(s1, s2, l1, l2));
		
		lcsPrint(l1 ,l2,s1,s2);
		
	}	
	
	
  public static int lcsLength(String s1,String s2 , int l1 , int l2) {  
	  for(int i=0 ; i <= l1; i++) {
		  for(int j = 0 ; j <= l2 ; j++ ) {
			  
			  if(i==0 || j== 0) {
				  lcs[i][j] = 0;
			  }
			  else if(s1.charAt(i-1) == s2.charAt(j-1)) {
				lcs[i][j] = 1+ lcs[i-1][j-1];
				//System.out.println(s1.charAt(i-1));
			  }else {
				  lcs[i][j] = Math.max(lcs[i][j-1] , lcs[i-1][j]);
			  }
		  }
	  } 
return lcs[l1][l2];
	
  }	

  public static void lcsPrint(int l1 , int l2, String s1,String s2) {
	  char[] lcsArray = new char[lcs[l1][l2]];
	  int i = l1;
	  int j = l2;
	  int index = lcs[l1][l2];
	  lcsArray[index] = '\0';
	while(i> 0 && j >0)	 { 
			  if(s1.charAt(i-1) == s2.charAt(j-1)) {
				  System.out.println(s1.charAt(i-1));
				  lcsString.append(s1.charAt(i-1));
				 i--;
				 j--;
				  
			  }else {
				  if(lcs[i][j-1] >  lcs[i-1][j]) {
					  j--;
				  }else {
					  i--;
				  }
			  }
			  
		  } 
		  
		  
	  
	  
	  System.out.println(lcsString.toString());
	  
  }
  
}
