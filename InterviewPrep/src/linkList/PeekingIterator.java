package linkList;

import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {

	    private final Iterator<Integer> iter;
	    private Integer next;
	    private boolean hasPeeked;  
	
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		 this.iter = iterator;
		 }
		
	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			if(!hasPeeked) {
				 next = iter.next();
				 hasPeeked = true;
				 }
			 
			 return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
	       if(!hasPeeked) {
	    	   return iter.next();
	       }
			Integer result = next;
			next = null;
			hasPeeked = false;
		 
			return result;
		}

		@Override
		public boolean hasNext() {
		 
	        return hasPeeked || iter.hasNext();
	        
		}
		
		
		public static void main(String args[]) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			Iterator iter = list.iterator();
			PeekingIterator peekIter = new PeekingIterator(iter); 
			  
	        list.add(1); 
	        list.add(2); 
	        list.add(3); 
	        list.add(4); 
	        list.add(5); 

	      
		
			
			
			
			
			
		}
	}