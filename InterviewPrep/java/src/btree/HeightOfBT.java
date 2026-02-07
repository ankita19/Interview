package btree;

public class HeightOfBT {
	
	public int heightOfBSTRecursive(Node root) {
		if(root == null) return 0;
		
		return 1+ Math.max(heightOfBSTRecursive(root.left), heightOfBSTRecursive(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
