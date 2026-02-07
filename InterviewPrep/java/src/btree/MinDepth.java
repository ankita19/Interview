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
Brute force: recursion DFS
Complexity analysis

Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node, 
the recursion call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be O(N). 
But in the best case (the tree is completely balanced), the height of the tree would be log(N).
 Therefore, the space complexity in this case would be O(log(N)).
===============
========
Optimal
The drawback of the DFS approach in this case is that all nodes should be visited to ensure that the minimum depth would be found.
Therefore, this results in a O(N) complexity. One way to optimize the complexity is to use the BFS strategy. 
We iterate the tree level by level, 
and the first leaf we reach corresponds to the minimum depth. As a result, we do not need to iterate all nodes.

Time Complexity : 
Space complexity :
=================

*/
public class MinDepth {
	public class DepthPair{
		TreeNode node;
		int depth;
		
	  public DepthPair(TreeNode  node, int depth) {
		  this.node = node;
		  this.depth = depth;
	  }
	}
	
    //DFS Recursive
	public int minDepthRecursive(TreeNode root) {
		
		if(root == null) return 0;	
		return minDepthHelper(root);
	}
	
	private int minDepthHelper(TreeNode root) {
		// Penalize node with one child 
		if(root == null) return Integer.MAX_VALUE;
		
		if(root.left ==null && root.right ==null) return 1;
		
		int l = minDepthHelper(root.left);
		int r = minDepthHelper(root.right);
		
		return 1+ Math.min(l, r);
	}
	
	//BFS iterative
	public int minDepthBfs(TreeNode root) {
		
		Deque<DepthPair>queue =  new ArrayDeque<>();
		int current_depth =0;
		
		if(root == null)
			return 0;
		else {
			queue.add(new DepthPair(root,1));
		}
		
		while(!queue.isEmpty()) {		
			DepthPair currentNode = queue.poll();
			current_depth = currentNode.depth;
			TreeNode node = currentNode.node;
			
			if(node.left == null && node.right == null) {
				return current_depth;
			}
			
			if(node.left != null) {
				queue.add(new DepthPair(node.left, 1+current_depth));
			}
			
			if(node.right != null) {	
				queue.add(new DepthPair(node.right,1+ current_depth));
			}
			
			
		}
		
	return current_depth;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
