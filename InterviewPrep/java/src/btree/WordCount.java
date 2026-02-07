package btree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * "this is a sample"
 * 1) split " "
 * 2) string[]
 * 3) hash map do count
 * 4) word->frq
 * 5) sort based value -> dec
 * 6) k words -> output[]
 * 
 * 
 * 
 * 
 * */

//this is a book book
/*
 * 
 * */

public class WordCount {

	public  static String[] findFreqentWord(String str, int k) {
		
		if(k < 1) return new String[0];
		if(str == null ||str.length() == 0) return new String[0];
		
		String[] input = str.split(" ");
		String[] output = new String[k];
		
		Map<String,Integer> map = new HashMap<>();
		
		for(String s : input) {
			int incr = map.getOrDefault(s, 0);
			map.put(s, incr+1);
		}
		
		PriorityQueue<String> queue = new PriorityQueue<>(k , (a,b)-> map.get(b)-map.get(a));
		//1
		// a b
		//
		
		//queue.addAll(map.keySet());
		
		/*
		for(Map.Entry entry : map) {
			
			queue.add(entry.getKey());
			if(queue.size() > 3)
				queue.poll();
			
			
		}
		*/
		int count =0;
		while(!queue.isEmpty() && count < k){
			output[count] = queue.poll(); 
			count++;
		}
		
		return output;
		
}
	
	
	public static void main(String[] args) {
		
		
	
		String[] outputTest = findFreqentWord("this is a a a a a book book", 2);
		
		for(String s : outputTest) {
			System.out.println(s);
		}

	}

}
