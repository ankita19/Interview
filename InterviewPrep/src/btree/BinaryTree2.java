package btree;

import java.util.Comparator;

//O(T) O(logn)

public class BinaryTree2<E extends Comparable<? super E>>{
	
	TreeNode<E> root = null;
	 
	 Integer pred = null;
	 
	 void buildBinaryTree(TreeNode<Integer> root){
		 
		 root.addLeftChild(3);
		 root.addRightChild(16);
		 
		 root.left.addLeftChild(2);
		 root.left.addRightChild(4);
			
			
		 
	 }
	 
	 TreeNode<E> findNode(E num, TreeNode<E> root) {
		 TreeNode<E> curr = root;
		 
		 if(root == null) return null;
		 
		 while(curr !=null) {
		 if(num.compareTo(curr.value) > 0)
			 curr = curr.right;
		 else if(num.compareTo(curr.value) < 0)
			 curr = curr.left;
		 else if(num.compareTo(curr.value) == 0) {
			  return curr;
		 }
		 }
		 
		 return null;
	 }
	 
	 
	 E findMin(TreeNode<E> curr){
		 
		 if(curr.left == null) 
			 return curr.value;
		 findMin(curr.left);
		return null;
		}
	 
	 public TreeNode getMinIter() {
		 TreeNode curr = root;
		 if(curr == null) return curr;
		 
		 while(curr.left !=null) {
			 curr = curr.left;
		 }
		 
		 return curr;
	 }
	 
	 boolean searchIter(TreeNode<E> root, int num) {
		 
		 if(root == null) return false;
		 
		 while(root !=null) {
		 if(num == (int) root.value) {
			 return true;
		 }else if(num < (int) root.value) {
			 root = root.getLeft();
		 }else if(num > (int)root.value) {
			 root = root.getRight();
		 }
		 }
		 
		 return false;
	 }
	 
	 boolean searchRecursive(TreeNode root, int num) {
		 
		 if(root == null) return false;
		 
		 TreeNode curr = root;
		 
		
		 if(num == (int) curr.value) {
			 System.out.println("in");
			 return true;
		 }else if(num < (int) curr.value) {
			 return searchRecursive(curr.getLeft(),num);
		 }else if(num > (int)curr.value) {
			 
			  return searchRecursive(curr.getRight(),num);
		 }
		return false;
	 } 
	 
	 public boolean insert(E data) {
		 TreeNode<E> newNode = new TreeNode<E>(data); 
		 if(root == null)
			 root = newNode;
		 else {
			 TreeNode<E>tmpNode = root;
			 int comp = data.compareTo(tmpNode.value);
			 while(comp < 0 && tmpNode.left != null || comp > 0 && tmpNode.right != null) {
			
			 if(comp > 0) {	 
				  tmpNode = tmpNode.right;
				}else if(comp < 0) {
					  tmpNode = tmpNode.left;
			  }
			 comp = data.compareTo(tmpNode.value);
		}
			 if(comp > 0)
				 tmpNode.right = newNode;
			 else if(comp < 0)
				 tmpNode.left = newNode;
			 
			 else return false;
			 
			 
	  }
		return true;
	 }
	 
	 
	 public void inorderTraversal(TreeNode<E> root) {
		 TreeNode<E> curr =root;
		 
		 if(curr == null) return;
		 
			 inorderTraversal(curr.left);
			 System.out.print(curr.value + " ");
			 inorderTraversal(curr.right);
		 
	 }
	 
	 
	 
	 
	 public void findSuccesor(TreeNode<E> root,int toCom,Integer suc) {
		 TreeNode<E> curr =root;
		 
		if(curr == null) return;
		 
		findSuccesor(curr.left,toCom,suc);
		
		
	//	System.out.print(curr.value + " ");
			 
		 if(pred !=null && pred == toCom) { 	 
			 suc = (Integer) curr.value;
			// System.out.print("Succ : " + " " + suc);
			
			 }
		 else {
			 pred = (Integer) curr.value;
		 } 
	findSuccesor(curr.right,toCom,suc);
	}
	 
	 public void deleteNode(E data,TreeNode<E> root ) {
		
		 TreeNode<E> curr = root;
		 if(root == null) return;
		 	 
		 //case 1
		 TreeNode<E> tmp = findNode(data,curr);
		// System.out.println(tmp.value);
		 //leaf node
		 if(tmp.right == null && tmp.left == null)
			 tmp = null;
		 else if(tmp.right == null ) //one child
		 {
		 deleteNode(data,tmp.left);
			 
		 }if(tmp.left == null) {
			
			deleteNode(data,tmp.right) ;
		 } else {
			 //TreeNode<E> minNode = findMin(tmp.right);
			 tmp.value = findMin(tmp.right);
			deleteNode(data,tmp.right);
		 }
	 }
	 
	public static void main(String[] args) {
		
		BinaryTree2 btree = new BinaryTree2();
		
		btree.root = new TreeNode(10);
		
		//btree.buildBinaryTree(btree.root);
		
		System.out.println("insert : "+btree.insert(6));
		System.out.println("insert : "+btree.insert(5));
		System.out.println("insert : "+btree.insert(8));
		System.out.println("insert : "+btree.insert(17));
		System.out.println("insert : "+btree.insert(11));
		System.out.println("insert : "+btree.insert(25));
		System.out.println("insert : "+btree.insert(16));
		System.out.println("insert : "+btree.insert(22));
		System.out.println("insert : "+btree.insert(19));
		System.out.println("insert : "+btree.insert(27));
		
	//	System.out.println(btree.searchRecursive(btree.root, 28));
		
		btree.inorderTraversal(btree.root);
		
	//	btree.deleteNode(27,btree.root);

		System.out.println();
	//	btree.inorderTraversal(btree.root);
		Integer suc = null;
		btree.findSuccesor(btree.root, 10,suc);
		if(suc!=null)
			System.out.println(suc);
		
		
	}

	

	

	
}
