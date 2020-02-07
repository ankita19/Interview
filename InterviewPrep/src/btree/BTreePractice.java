package btree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BTreePractice {
	
	
	public static void inOrderTraversal(Node root) {
		
		if(root == null) return;
		
		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}
	
	public static void inOrderDFs(Node root) {
		if(root == null) return;
		
		Node curr = root;
		Stack<Node> stack = new Stack<>();
		
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			
			System.out.println(curr.val);
			curr = curr.right;
		}
		
	}
	
	
	public static void treeBFSTemplate(Node root) {
		if(root == null) return;
		
		Deque<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node curr = queue.pop();
			
			if(curr.left != null)
				queue.add(curr.left);
			if(curr.right != null)
				queue.add(curr.right);
		}
}
	
	/*Print each level elements in sapreate list
	 * 
	 * */
	
	
	public static List<List> treeBFSLevelList(Node root) {
		if(root == null) return null;
		List<List> result = new ArrayList<>();
		Deque<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int numNode = queue.size();
			List<Integer> nodes = new ArrayList<>();
			for(int i = 0 ; i < numNode; i++) {	
			Node curr = queue.pop();
			nodes.add(curr.val);
			
			if(curr.left != null)
				queue.add(curr.left);
			if(curr.right != null)
				queue.add(curr.right);
			}
			
			result.add(nodes);
		}
		return result;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTree tree = new BTree();
		Node root = tree.buildBSTTree();
		
		inOrderTraversal(root);
		System.out.println();
		inOrderDFs(root);
	}

}
