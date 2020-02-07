package trieTree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	public class TrieNode {
		
		Map<Character,TrieNode>child = new HashMap<>();
		boolean isWord;
		
		TrieNode(char c){
			this.child.put(c, new TrieNode());
			this.isWord = false;
		}

		public TrieNode() {
			// TODO Auto-generated constructor stub
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
