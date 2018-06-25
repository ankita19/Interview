package trieTree;

import java.util.HashMap;
import java.util.Map;



public class LCPrefixTries {
	
	
	 public static void main(String[] args) {		 
			insert("teest");
			insert("teeee");
			insert("r");
			System.out.println(LCPUsingTrie());
		}
	

	public static class TrieNode{
		
		Map<Character , TrieNode> child;
		boolean endOfWord;
	
	
	public TrieNode() {
		child = new HashMap<>();
	    endOfWord = false;	
	}
	
}
	
	static TrieNode root = new TrieNode();
	
	static String LCPUsingTrie() {
		
		TrieNode current = root;
		
		StringBuilder prefix = new StringBuilder();
		prefix.append("");
		
		System.out.println(" child size" + current.child.size());
		
		if(current.child.size() != 1) return prefix.toString();
		
		while(current.child.size() == 1) {
			char ch = (char) current.child.keySet().toArray()[0];
			current = current.child.get(ch);
			prefix.append(ch);
			}  
		
		return prefix.toString();
}
	
	
 static  void insert(String word) {
	 TrieNode current = root;
	 
	 for(int i=0 ; i < word.length() ; i++ ) {
		char ch = word.charAt(i);
		TrieNode node = current.child.get(ch);
		 //node
		if(node == null) {
			node = new TrieNode();
			current.child.put(ch, node);
		}
		current = node;
	 }
	 
	//mark endOfWord to true
	 current.endOfWord = true;
 }
 


 
}
