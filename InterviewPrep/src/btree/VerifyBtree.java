package btree;

import java.util.Stack;

public class VerifyBtree {

	
	/**
	 * @param root
	 * @return
	 */
	public static boolean isBtreeRecursive(Node root) {
		
		return isBtree(root , null , null );
	}
	
	public static boolean isBtree(Node root ,Integer min , Integer max) {
		if(root == null) return true;
		
		if(min != null && root.val < min) return false; 
		if(max != null && root.val > max) return false;
		return isBtree(root.left , min , root.val) && isBtree(root.right , root.val,max ); 
	}
	
	
	public static boolean isValidBSTRecursive(Node root) {
	    if (root == null) return true;
	    Integer inOrder = null;
	    Stack < Node > stack = new Stack < > ();
	    Node curr = root;
	    
	    while (!stack.isEmpty() || curr != null) {
	        while (curr != null) {
	            stack.push(curr);
	            curr = curr.left;
	        }
	        curr = stack.pop();
	        if (inOrder != null && curr.val <= inOrder) return false;

	        inOrder = curr.val;
	        curr = curr.right;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 BinaryTree bt = new BinaryTree();
	    	bt.buildTree(bt);
	    	System.out.println(isBtreeRecursive(bt.root));
	    	
	    	System.out.println(isValidBSTRecursive(bt.root));
		
	}

}
