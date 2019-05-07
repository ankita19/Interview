package btree;

public class SecondLargestInTree {
	
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		public TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}
	
	public TreeNode secondLargest(TreeNode root) {
		
		if(root == null || root.left == null && root.right == null)  return root;
		TreeNode second = null;
		TreeNode curr = root;
	      while(curr != null) {	
			while(curr.right !=null) {
				second = curr;
				curr = curr.right;
			}
			
			if(curr.left!=null) {
				second = curr;
				curr = curr.left;
			}
			
			if(curr.left == null && curr.right ==null)
					return second;
	      }
	      
	      return second;
		}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
