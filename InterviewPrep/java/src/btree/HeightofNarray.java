package btree;

import java.util.ArrayList;

import btree.NArrayTree.NArrayNode;

public class HeightofNarray {
	
	public int narrayHeight(NArrayNode root) {
		
		if(root.childern.size() ==0) return 1;
		int heightSoFar = 0;
		for(NArrayNode child : root.childern) {
			heightSoFar =	Math.max(heightSoFar,narrayHeight(child));
		}
	return heightSoFar+1;	
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NArrayTree  ntree = new NArrayTree();
		
		HeightofNarray obj = new HeightofNarray();
		//System.out.println(obj.narrayHeight(ntree.buildNATree()));
		
		NArrayNode root = ntree.new NArrayNode(10, new ArrayList<NArrayNode>());
		
		System.out.println(obj.narrayHeight(root));
		
		
		
	}

}
