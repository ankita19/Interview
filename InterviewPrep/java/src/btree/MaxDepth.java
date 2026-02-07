package btree;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem
==============



=============
Example
============


==============
Solution
============
Brute force
Time Complexity : 
Space complexity :
Complexity analysis

Time complexity : \mathcal{O}(N)O(N).

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion 
call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be \mathcal{O}(N)O(N). 
But in the average case (the tree is balanced), the height of the tree would be \log(N)log(N).
 Therefore, the space complexity in this case would be \mathcal{O}(\log(N))O(log(N)).

===============
========
Better
Time Complexity : 
Space complexity :
=================
=====
Optimal
Time Complexity : 
Space complexity :
*/
public class MaxDepth {
	public class DepthPair{
		TreeNode node;
		int depth;
		
	  public DepthPair(TreeNode  node, int depth) {
		  this.node = node;
		  this.depth = depth;
	  }
	}
	
	
	
	public int maxDepthRecursive(TreeNode root) {
		if(root == null) return 0;
		
		return 1+ Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
	}
	
	
	public int maxDepthIterative(TreeNode root) {
		int curr_depth =0;
		
		Deque<DepthPair> stack = new ArrayDeque<>();
		if(root ==null) return 0;
		else stack.push(new DepthPair(root, 1));
		int depth =0;
		while(!stack.isEmpty()) {
			
			DepthPair node = stack.pop();
			TreeNode currNode = node.node;
			curr_depth = node.depth;
			
			if(currNode !=null) {
				depth = Math.max(depth, curr_depth);
				stack.push(new DepthPair(currNode.left, 1+curr_depth));
				stack.push(new DepthPair(currNode.right, 1+curr_depth));
			}
		}
		
		return depth;
	}

	public static void main(String[] args) {
		// TODO Auto-generate

	}

}
