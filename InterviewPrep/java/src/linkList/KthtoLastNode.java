package linkList;


/*1) by 2 pass : calculating length
 * take care of calculating length-k
 * 2) by using 2 pointers
 * 
 * Both method complexity O(n)
 * 
 * */
public class KthtoLastNode {
	
	public static Node kth_node_by_length(Node head, int k) {
		Node curr = head;
		Node second = head;
		int length = 0;
		while(curr != null) {
			curr = curr.next;
			length++;
		}
		//take care of length-K
		for(int i= 0;i< (length-k);i++) {
			 second = second.next;
		}
		return second;
	}
	public static Node kth_node_by_two_pointer(Node head, int k) {
		Node first = head;
		Node second = head;
		int length = 0;
		
		for(int i= 0;i< k;i++) {
			 first = first.next;
		}
		while(first != null ) {
			first = first.next;
			second = second.next;
		}	
		return second;
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
		System.out.println(kth_node_by_length(a,2).val);
		System.out.println(kth_node_by_two_pointer(a,2).val);
	}

}
