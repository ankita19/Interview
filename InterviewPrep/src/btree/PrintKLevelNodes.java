package btree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PrintKLevelNodes {
	
	public class LevelNode{
		Node node;
		int level;
		
		LevelNode(Node node,int level){
			this.node=node;
			this.level=level;
		}
	}
	
	public void dfsPrintKLevel(Node root,int k) {
	if (root == null) return;
		
	List<Integer> list = new ArrayList<>();
	Stack<LevelNode> s= new Stack<>();
	
	s.push(new LevelNode(root,1));
	
	while(!s.isEmpty()) {
		LevelNode tmp = s.pop();
		
		if(tmp.level == k) {
			list.add(tmp.node.val);
		}
		
		if(tmp.node.left !=null) {
			s.push(new LevelNode(tmp.node.left, tmp.level+1));
		}
		if(tmp.node.right !=null) {
			s.push(new LevelNode(tmp.node.right, tmp.level+1));
		}
	}
	
	printLevel(list);
		
		
	}

	public void printLevelBfs(Node root,int k) {
		
		if(root == null) return;
		
		Queue<LevelNode> q = new ArrayDeque<>();
		q.offer(new LevelNode(root, 1));
		
		while(!q.isEmpty()) {
			LevelNode tmp = q.poll();
			if(tmp.level == k)
			{
				System.out.println(tmp.node.val);
			}
			
			if(tmp.node.left !=null) {
				q.offer(new LevelNode(tmp.node.left, tmp.level+1));
			}
			if(tmp.node.right !=null) {
				q.offer
				(new LevelNode(tmp.node.right, tmp.level+1));
			}
		}
		
		
	}
	
	public void printLevel(List<Integer> list) {
		if(list.size() == 0) { 
			System.out.println("No vaues for given level"); 
			return;}
		else
		list.forEach(x-> System.out.println(x));
	}
	
	
	
	public void recursivePrintLevel(Node root,int k) {
		if(root == null) return;
		if(k==1) {System.out.println(root.val); return;}
		
		recursivePrintLevel(root.left,k-1);
		recursivePrintLevel(root.right, k-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			BTree tree = new BTree();
			PrintKLevelNodes pn = new PrintKLevelNodes();
			pn.dfsPrintKLevel(tree.buildTree(),2);
			System.out.println("BFS output-");
			pn.printLevelBfs(tree.buildTree(),2);
			System.out.println("recursive-");
			pn.recursivePrintLevel(tree.buildTree(),2);
	}

}
