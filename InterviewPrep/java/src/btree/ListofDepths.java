package btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListofDepths {

	ArrayList<ArrayList<TreeNode<Integer>>> listOfDepth = new ArrayList<>();
	
	public void createLists(TreeNode root) {
		
		if(root ==null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree2 <Integer>btree = new BinaryTree2<>();
		
		btree.insert(10);
		btree.insert(9);
		btree.insert(11);
		btree.insert(8);
		
	}

}
