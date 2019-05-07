package linkList;

import java.util.ArrayDeque;
import java.util.Queue;

import btree.BinaryTree;


public class ConvertListToTree {
	
	public class BNode{
				int val;
				BNode left;
				BNode right;
				
				public BNode(int val) {
					this.val = val;
					this.left = null;
					this.right = null;
				}
	}
	
	public BNode getChild(Node curr) {	
		return (curr.next != null) ? new BNode(curr.next.val) : null ;
	} 
		
	public BNode convertListToTree(Node head) {
		
		if(head == null) return null;
	    Queue<BNode> queue = new ArrayDeque<>();	
	    BNode root = new BNode(head.val);
	    Node curr = head;
	    queue.offer(root);
	    
	    while(curr != null) {
	    	BNode parent = queue.poll();  
	    
	    		parent.left = getChild(curr);
	    		if(parent.left != null)
	    		{
	    			queue.offer(parent.left);
	    			curr = curr.next;
	    		}
	    	
	    	
	    		parent.right = getChild(curr);
	    		
	    		if(parent.right != null)
	    			queue.offer(parent.left);
	    	
	    	curr = curr.next;
	    	}
	   
		return root;
	}
	public static void inOrderPrint(BNode root) {
		
		if(root != null) {
			inOrderPrint(root.left);
			System.out.println(root.val);
			inOrderPrint(root.right);
		}
	}

	public static void main(String[] args) {
		
		ConvertListToTree tree = new ConvertListToTree();
		
		Node head = new Node(1);
		Node node = head;
		node.next = new Node(2);
        node = node.next;
        node.next = new Node(3);
        node = node.next;
        node.next = new Node(4);
        
        inOrderPrint(tree.convertListToTree(head));
    }

}
