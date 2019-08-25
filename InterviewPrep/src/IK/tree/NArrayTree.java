package IK.tree;

import java.util.ArrayList;
import java.util.List;

public class NArrayTree {
	
	public class NArrayNode{
		int val;
		List<NArrayNode> childern;
		
		public NArrayNode(int v,List<NArrayNode> childern){
			this.val = v;
			this.childern = childern;
		}
		
	}

	public NArrayNode buildNATree() {
		
		/*			       10
		 * 		[1 	    2	     3		4]
		 * [11 12]	  [13]    [14 15]
		 * 		
		 * 
		 * 
		 * */
		
		NArrayNode root = new NArrayNode(10, new ArrayList<NArrayNode>());
		
		root.childern.add(new NArrayNode(1,new ArrayList<NArrayNode>()));
		root.childern.add(new NArrayNode(2,new ArrayList<NArrayNode>()));
		root.childern.add(new NArrayNode(3,new ArrayList<NArrayNode>()));
		root.childern.add(new NArrayNode(4,new ArrayList<NArrayNode>()));
		
		
		root.childern.get(0).childern.add(new NArrayNode(11,new ArrayList<NArrayNode>()));
		root.childern.get(0).childern.add(new NArrayNode(12,new ArrayList<NArrayNode>()));
		
		root.childern.get(1).childern.add(new NArrayNode(13,new ArrayList<NArrayNode>()));
		root.childern.get(2).childern.add(new NArrayNode(14,new ArrayList<NArrayNode>()));
		root.childern.get(2).childern.add(new NArrayNode(15,new ArrayList<NArrayNode>()));
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
