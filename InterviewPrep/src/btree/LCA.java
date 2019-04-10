package btree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Problem
==============

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.When parent pointer is not given

=============
Example
============


==============
Solution
============
Brute force - Iterative
Time Complexity : O(N)
Space complexity : O(N)

store path of node and find intersection
HashMap can be used by storing parent pointer

Approach :
1) Start from the root node and traverse the tree.
2) Until we find p and q both, keep storing the parent pointers in a dictionary.
3) Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
4) Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p,
 this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.

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

public class LCA {
	/*Iterative with HashMap and parent pointer
	 * Time - O(n)
	 * Space - O(n)
	 * */
	public TreeNode LCAWithMap(TreeNode root,TreeNode p,TreeNode q) {
		if(root == null || root.value == p.value || root.value == q.value) return root;
		
		Map<TreeNode,TreeNode> parent = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		//add root to parent map and on path
		parent.put(root, null);
		stack.push(root);
		
		while(!stack.isEmpty() && (!parent.containsKey(p) || !parent.containsKey(q))) {
			 
			TreeNode current = stack.pop();
			
			if(current.left !=null) {
				stack.push(current.left);
				parent.put(current.left, current);
			}
			

			if(current.right !=null) {
				stack.push(current.right);
				parent.put(current.right, current);
			}
		}
		
		
		 // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
