package IK.tree;

import java.util.Stack;



public class FindMaxHeight {
	
	public class Pair{
		Node node;
		int h;
		
		public Pair(Node node,int h) {
			this.node = node;
			this.h=h;
		}
	}
	
	public static int findHeightRecursive(Node root) {
		if(root==null) return 0;
		
		return Math.max(findHeightRecursive(root.left),findHeightRecursive(root.right)) +1;
	}

	
	
	public int findHeightNonRecursive(Node root) {
		int maxHSofar =0;
		if(root == null) return 0;
		Stack<Pair> s = new Stack<>();
		
		s.push(new Pair(root,1));
		
		while(!s.isEmpty()) {
			Pair tmp = s.pop();
			
			if(tmp.node.left == null && tmp.node.right == null) {
				maxHSofar = Math.max(maxHSofar, tmp.h);
			}
			
			if(tmp.node.left != null) {
				s.push(new Pair(tmp.node.left,tmp.h+1));
			}
			if(tmp.node.right != null) {
				s.push(new Pair(tmp.node.right,tmp.h+1));
			}
		}
		
		return maxHSofar;
	}
	public static void main(String[] args) {
		FindMaxHeight obj = new FindMaxHeight();
		System.out.println(findHeightRecursive(new BTree().buildBSTTree()));
		System.out.println(obj.findHeightNonRecursive(new BTree().buildBSTTree()));
			
		
	}

}
