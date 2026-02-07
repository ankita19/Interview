package linkList;

/*
 * 1) Iterative : for in place solution
 *time :  O(n)
 *Space : O(1)
 *2) recursive in place
 *
 *2) Additional memory (keep given link list unchanged)
 * */

public class ReverseLL {

	
	/**Inplace solution
	 * @param head
	 * @return
	 */
	public static Node reverseList(Node head) {
		if (head.next == null) {
			return head;
		}
		Node prev = null;
		Node curr = head;
		Node nextNode = null;
		
		while (curr.next != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		//to take care of last node
		curr.next = prev;
		return curr;
	}
	
//recursive solution
	public static Node reverseRecursive(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node curr =  head;
		Node rest = reverseRecursive(curr.next);
		curr.next.next = curr;
		curr.next = null;
		
		return rest;
	}
	
/*out place solution
	public static Node reverseNew(Node head) {
		
		Node curr = head;
		while(curr != null) {
			Node newNode = new Node(curr.val);
			curr = curr.next;
			
			
		}
		
	}
*/	
	
	

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
//		d.next = e;

		//Node new_head = reverseList(a);
		Node new_head = reverseRecursive(a);
		while (new_head != null) {
			System.out.println(new_head.val);
			new_head = new_head.next;
		}

	}// end of method

}
