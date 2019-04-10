package trieTree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character , TrieNode> child = new HashMap<Character , TrieNode>();	
	boolean isWord;
	
	TrieNode(char c){
		this.child.put(c, new TrieNode());
		this.isWord = false;
	}

	public TrieNode() {
		// TODO Auto-generated constructor stub
	}
}
