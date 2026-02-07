package patternsearch;

import java.util.Arrays;

/*search for given pattern in string
 * txt ="abcdddde"
 * patt = "dde" 
 * 
 * */

public class KMPPatternSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String txt = "abcddddabc";
		String patt =  "dd";
		String replace = "X";
		
		
		patternSerchingKMP(txt, patt, lpsPopulate("dda"));
	}
	/*O(M*N)
	 * without KMP
	 * */
	public static void findPattern(String txt , String patt) {
		
		int lt = txt.length();
		int lp = patt.length();
		
		int i = 0;
		int j = 0;
		while(lt > i) {
			if(txt.charAt(i) == patt.charAt(j)) {
				i++;
				j++;
			}else {
				i++;
			}
			if(j == lp) {
				System.out.println("pattern found at" +  (i- lp));
				j=0;
			}
			
		}
	}

public static boolean patternSerchingKMP(String txt , String patt , int[] lsp) {
	
	int i = 0;
	int j =0;
	
	while(i < txt.length()) {
	
	if(txt.charAt(i) == patt.charAt(j)) {
		i++;
		j++;
	}
	
	if(j==patt.length()) {
		System.out.println("pattern found at" +  (i- j));	
		j = lsp[j-1];
	}else if(i< txt.length() && txt.charAt(i) != patt.charAt(j) ) {
		if(j!=0)
		{
			j = lsp[j-1];
			
		}else i++;
		
	}
		
		
		
	}
return false;
	
	
}	
	
/*  ABBCDABB
 *  001
 * 
 * 
 * */	
	
public static int[] lpsPopulate(String patt) {
	
	int[] lsp = new int[patt.length()];
	
	int i = 1;
	int j = 0;
	
	lsp[0] = 0;
	while(i < patt.length()) {
	if(patt.charAt(i) == patt.charAt(j)) {
		lsp[i] = j +1;
		j++;
		i++;
	}else {
		
		if(j!=0) {
		j = lsp[j-1];
		}
		else{
			lsp[i] = 0;
		i++;
		}
		
	}}
	return lsp;
}


}
