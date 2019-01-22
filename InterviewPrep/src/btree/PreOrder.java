package btree;

public class PreOrder {

	
	public static void preOrderTraversal(Node root) {
		if(root == null) return;
		
	    if(root != null) {
	         System.out.println(root.data);
	         preOrderTraversal(root.left);
	         preOrderTraversal(root.right);
	    }
	}
	
	public static void preOrder_iter(Node root) {
		
		if(root ==null) return;
		
		while(root.left != null) {
			if(root.left == null) {
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();
		
		BinaryTree.buildTree(tree);
	}

}
