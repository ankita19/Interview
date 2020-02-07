package btree;

import java.util.ArrayList;
import java.util.List;


public class BuildBSTUsingPre {
	

	public Node buildBST(int[] arr,int start,int end) {
		if(start > end) return null;
		
		if(start == end) return new Node(arr[start]);
		
		Node root = new Node(arr[start]);
		int mid = start+(end-start)/2;
		root.left = buildBST(arr,start+1,mid);
		root.right = buildBST(arr,mid+1,end);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		
		int[] preOrder = new int[] {20,10,3,11,30,22,40};
		
		BuildBSTUsingPre obj = new BuildBSTUsingPre();
		List<Integer> list = new ArrayList<>();
		
		
		BTree  tree = new BTree();
		
		tree.buildBSTTree();
		
		tree.inorder(obj.buildBST(preOrder, 0, preOrder.length -1), list);
		
		list.forEach(num -> System.out.println(num));

	}


	

}
