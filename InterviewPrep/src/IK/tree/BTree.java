package IK.tree;

import java.util.List;

import btree.TreeNode;

public class BTree {
	
	 
	 public Node buildTree() {
		 Node root = new Node(5);
		 
		 root.left  = new Node(1);
		 root.right = new Node(1);
		 
		 root.left.left = new Node(2);
		 root.left.right = new Node(2);
		 
		 root.right.right = new Node(3);
		 return root;
	 }
	 
	 public Node insertBST(Node root ,int value) {
		 Node curr = root;
		 Node prev = root;
		 while(curr != null) {
			 if( value < curr.val) {
				 prev= curr;
				 curr = curr.left;
			 }else {
				 prev=curr;
				 curr = curr.right;
			 }
		 }
		 
		 if(value < prev.val)
			 prev.left= new Node(value);
		 else
			 prev.right = new Node(value);
		 
		 return root;
	 }
	 
	 public Node buildBSTTree() {
		 Node root = new Node(20);
		 
		 insertBST(root, 10);
		 insertBST(root, 3);
		 insertBST(root, 11);
		 insertBST(root, 30);
		 insertBST(root, 22);
		 insertBST(root, 40);
		 insertBST(root, 45);
		 insertBST(root, 55);
		 insertBST(root, 12);
		 return root;
	 }
	 
	 public void inorder(Node root,List<Integer> path){
		 if(root == null) return;
		 
		 inorder(root.left,path);
		 path.add(root.val);
		 inorder(root.right, path);
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
