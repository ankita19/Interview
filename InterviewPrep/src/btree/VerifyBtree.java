package btree;

public class VerifyBtree {

	
	public static boolean isBtree(Node root) {
		
		return isBtree(root , Integer.MIN_VALUE , Integer.MAX_VALUE );
	}
	
	public static boolean isBtree(Node root , int min , int max ) {
		if(root == null) return true;
		
		if(root.data < min || root.data > max) return false;
		return isBtree(root.left , min , root.data) && isBtree(root.right , root.data,max ); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 BinaryTree bt = new BinaryTree();
	    	bt.buildTree(bt);
	    	System.out.println(isBtree(bt.root));
		
	}

}
