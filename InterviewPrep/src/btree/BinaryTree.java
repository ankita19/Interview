package btree;

import java.util.Stack;

class Node{
	
	int data;
	Node left;
	Node right;
	
	public Node(int item) {
		data = item;
		left = right = null;
	}
	}

public class BinaryTree {
	
	 Node root;
	
	private BinaryTree() {
		root = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	BinaryTree tree = new BinaryTree();
	tree.root= new Node(1);
	tree.root.left = new Node(2);
	tree.root.right = new Node(3);
	
	//DFSRecursive_In_Order(root);
	//tree.DFS_non_Recursive_In_Order();	
	tree.In_Order_Morrise();
	
	}
	
//traversal
	//DFS
	
public void DFSRecursive_In_Order(Node root) {
	Node node = root;
	
if(node == null) return;
	DFSRecursive_In_Order(node.left);
	System.out.println(node.data);
	DFSRecursive_In_Order(node.right);
}	

//using stack
public void DFS_non_Recursive_In_Order() {
	
	if(root == null)
		return;
	Node curr = root;
	Stack<Node> s = new Stack<Node>();
	while(curr !=null || s.size() > 0) {	
		while(curr != null) {
			s.push(curr);
			curr = curr.left;
		   } 
			curr = s.pop();
			System.out.println(curr.data);
			curr = curr.right;
			}
}
	
//In constant space
public void In_Order_Morrise(){
	
	if(root == null)
		return;

	Node curr = root;
	
	while(curr != null){
		
	if(curr.left == null) {
		System.out.println(curr.data);
		curr = curr.right;
	}
	else {
		Node pred = curr.left;
		
		while( pred.right != null && pred.right != curr) {
			pred = pred.right;
		}
		if(pred.right == null) {
			pred.right = curr;
			curr = curr.left;
		}
		else {
			pred.right = null;
			System.out.println(curr.data);
			curr = curr.right;
		}
	}
	
	}


}
}
