package btree;



public class TreeNode<E> {
	E value;
	TreeNode<E> left;
	TreeNode<E> right;
	
	TreeNode(E val){
		this.value = val;
		this.left =null;
		this.right = null;
		
	}
	
	
	public TreeNode<E> addLeftChild(E val) {
		this.left = new TreeNode<E>(val);
		return this.left;
	}
	public TreeNode<E> addRightChild(E val) {
		this.right = new TreeNode<E>(val);
		return this.right;
	}
	public TreeNode<E> getRight() {
		return this.right;
	}
	
	public TreeNode<E> getLeft() {
		return this.left;
	}

}

