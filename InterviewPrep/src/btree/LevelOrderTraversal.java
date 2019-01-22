package btree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public  static void levelOrder(Node root){
        if(root == null){
            System.out.println("Please enter a valid tree!");
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            root = queue.poll();
            System.out.print(root.data + " ");
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
    }

    public static void main(String args[]){
         
    	 BinaryTree bt = new BinaryTree();
    	bt.buildTree(bt);
    	levelOrder(bt.root);
        
    }
}