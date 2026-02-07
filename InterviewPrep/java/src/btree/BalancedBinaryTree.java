package btree;

/*		  8
 * 		 /	\
 * 		6	 9
 * 	  /  \
 *   5   7
 *  / 
 * 4   
 * */
public class BalancedBinaryTree {

	public static int isBalancedTree(Node root){
		if(root == null)
			return 0;
		
		int leftHeight = isBalancedTree(root.left);
		if(leftHeight == -1)
			return -1;
		
		int rightHeight = isBalancedTree(root.right);
		if(rightHeight == -1)
			return -1;
		
		return (Math.abs(leftHeight - rightHeight) > 1) ? -1 
				: (1+Math.max(leftHeight , rightHeight));
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
