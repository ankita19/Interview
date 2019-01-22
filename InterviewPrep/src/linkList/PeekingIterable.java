package linkList;

import java.util.ArrayList;
import java.util.Iterator;
public class PeekingIterable implements Iterable<Integer> {


		private ArrayList<Integer> number = new ArrayList<Integer>();

		public PeekingIterable(ArrayList num){
			this.number = number;
		}

		public ArrayList getNumber() {
			return number;
		}

		@Override
		public Iterator<Integer> iterator() {
			return new PeekingIterator(this.iterator());
		}
		
		public static void main(String args[]) {
			
			 ArrayList<Integer> numberList = new ArrayList<Integer>();
			numberList.add(1);
			numberList.add(2);
			PeekingIterable list = new PeekingIterable(numberList);
	
				System.out.println(list);
		
		}

	
}
