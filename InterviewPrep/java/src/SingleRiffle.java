
public class SingleRiffle {
	
	/*2 halfs of one deck 
	 * 1) reduce one card from one deck and proceed
	 * 2) match decks card with one of first card
	 * data structure
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] deck = {"1","2","3","4"};
		String[] half1 = {"1","2"};
		String[] half2 = {"3","6"};
		System.out.println(""+checkDeck(deck , half1,half2,0,0,0));
}

	//recursive solution
	//Base condition : if deck size == 0  return true
	//if deck[i] == half1[j] Or deck[i] == half2[k] return true
	public static boolean checkDeckRecursive(String[] deck , String[] half1,String[] half2,
			int d,int h1,int h2) {
		//base case
		if(deck.length == d) 
			return true;
		 if(h1 < half1.length && deck[d] == half1[h1])  	
	    		h1++;
	    else if (h2 < half2.length && deck[d] == half2[h2])  	
	    	h2++;
	    else  
	    return false;

	    d++;
		return checkDeck(deck , half1,half2 , d,h1,h2);
	}
	
	public static boolean checkDeck(String[] deck , String[] half1,String[] half2,
			int d,int h1,int h2) {
		//base case
		for(String item : deck) {
		if(deck.length == d) 
			return true;
		 if(h1 < half1.length && item == half1[h1])  	
	    		h1++;
	    else if (h2 < half2.length && item == half2[h2])  	
	    	h2++;
	    else  
	    return false;

	    d++;
	}
		return true;
	}
}
