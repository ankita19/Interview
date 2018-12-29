package linkList;

/*Delete a node from a singly-linked list,given only a variable pointing to that node.
 * In this approach last element can't be deleted
 * there could be a dangling pointer
 * O(1)
 * */

public class DeleteNode {
	
	public static class Node{
		Node next;
		int val;
		
		Node(int val){
			next = null;
			this.val = val;
		}
	}

	static void deleteNode(Node d) throws Exception{
		Node next_node = d.next;
		
		if(next_node == null) 
		   throw new Exception("Can't delete last element");
		else {		
	    d.val = next_node.val;
	    d.next = next_node.next;
		
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		try {
			deleteNode(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//to print
		Node cur = a;
		while(cur.next != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
		System.out.println(cur.val);
	}
	
}

