package IK.tree;

public class FindUnivalTree {

	public class Result{
		int count;
		boolean isUnival;
		
		public Result(int count , boolean uv) {
			this.count = count;
			this.isUnival = uv;
		}
	}
	
	
	public Result countUnivalBetter(Node root) {
		
		if(root == null) return new Result(0,true);
		
		Result leftR = countUnivalBetter(root.left);
		Result rightR = countUnivalBetter(root.right);
			
		boolean isUniTree = true;
		
		if(!leftR.isUnival || !rightR.isUnival)
			isUniTree = false;
		if(root.left != null && root.left.val != root.val)
			isUniTree = false;
		if(root.right != null && root.right.val != root.val)
			isUniTree = false;
		
		if(isUniTree)
				return new Result(leftR.count+rightR.count+1,true);
		else
			return new Result(leftR.count+rightR.count,false);
	}
	
	
	public int countUnival(Node root) {
	
		if(root == null) return 0;
		
		int leftCount = 0;
				if(root.left != null)
					leftCount = countUnival(root.left);
				
		int rightCount =0;
				if(root.right != null)
					rightCount = countUnival(root.right);
			
		int totalCount = leftCount+rightCount;
		
		if(isUniVal(root))
				totalCount = totalCount+1;
		return totalCount;
				
	}
	
	public boolean isUniVal(Node root) {
		if(root == null) return true;
		
		if(root.left != null && root.left.val != root.val) return false;
		if(root.right != null && root.right.val != root.val) return false;
		
		if(isUniVal(root.left) && isUniVal(root.right)) return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindUnivalTree obj = new FindUnivalTree();
		BTree tree = new BTree();
		System.out.println(obj.countUnival(tree.buildTree()));
		System.out.println(obj.countUnivalBetter(tree.buildTree()).count);
	}

}
