package patternsearch;

public class KMP2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(PMPSearch("ancddan", "cddan", buildLsp("cd")));
	}

	public static int[] buildLsp(String s) {
		int[] lsp = new int[s.length()];
		
		int j =0;
		int i=1;
		lsp[0] = 0;
		while(i< s.length()) {
			if(s.charAt(i) == s.charAt(j)) {
				lsp[i] = j+1;
				i++;
				j++;
			}else {
				if(j==0) {
					lsp[i] =0;
					i++;
				}else {
					j = lsp[j-1];
				}
			}
		}
		return lsp;
	}
	
	public static boolean PMPSearch(String text , String pattern , int[] lsp) {
		if(text.length() == 0 || pattern.length() == 0) return false;
		int i = 0;
		int j = 0;
		int lText = text.length();
		int lPattern = pattern.length();
		while(i < lText && j < lPattern) {
			
			if(text.charAt(i) == pattern.charAt(j)) {
				j++;
				i++;
			}else {
				if(j==0) {
					i++;
				}else {
					j = lsp[j-1];
				}
			}
			
		}
		
		if(j==lPattern) return true; else return false;
	}
}
