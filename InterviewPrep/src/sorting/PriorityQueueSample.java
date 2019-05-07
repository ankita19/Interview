package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class PriorityQueueSample {
	
	public static class ExampleComparator  implements Comparator<String> {
		@Override  
		public int compare(String obj1, String obj2) {
		    return obj1.toLowerCase().compareToIgnoreCase(obj2.toLowerCase());
		  }

		}

	public static void sortString() {
		
		PriorityQueue<String>queue = new PriorityQueue<String>((String s1, String s2)->s2.compareTo(s1));
		
		Map<String,PriorityQueue>  keyValueStore = new HashMap<>();
		keyValueStore.put("key1", new PriorityQueue<String>((String s1, String s2)->s1.compareToIgnoreCase(s2)));
		keyValueStore.get("key1").add("Ankita");
		keyValueStore.get("key1").add("Anjali");
		keyValueStore.get("key1").add("Baby");
		keyValueStore.get("key1").add("aaaa");
		
		keyValueStore.put("key2", new PriorityQueue<String>((String s1, String s2)->s1.compareTo(s2)));
		keyValueStore.get("key2").add("bob");
		keyValueStore.get("key2").add("Ankita");
		
		Iterator<String> it = queue.iterator();
	    
		
		for(Entry entry : keyValueStore.entrySet()) {
			System.out.println(entry.getKey() +", "+ keyValueStore.get(entry.getKey()).size() + " , " + keyValueStore.get(entry.getKey()).poll());
			
		}
		
	}

	public static void main(String[] args) {
		sortString();
		
		

	}

}
