package IK.tree;

public class DiameterOfTree {
	
	public class Result{
		int h;
		Integer d;
		
		public Result(int h,Integer d) {
			this.h = h;
			this.d = d;
		}
	}
	
	public int findDiameter(Node root) {
		
		return helperDiameter(root).d;
		
	}

	public Result helperDiameter(Node root) {
		if(root == null) return new Result(0,0);

		
		Result left = helperDiameter(root.left);
		Result right = helperDiameter(root.right);
		
		int height = Math.max(left.h, right.h)+1;
		
		Integer diameter = Math.max(left.d ,Math.max(right.d , left.h+right.h+1)) ;
		
		return new Result(height,diameter);			 
	}
	
	public int findMax(int a,int b,int c) {
		if(a> b && a>c)
				return a;
		else if(b>a && b>c)
				return b;
		else return c;
						
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DiameterOfTree dt = new DiameterOfTree();
		System.out.println(dt.findDiameter(new BTree().buildBSTTree()));
	}

}
