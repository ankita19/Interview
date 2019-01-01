package linkList;

/*
 * 1) for in place solution
 *time :  O(n)
 *Space : O(1)
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
		
		while (curr != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		
		return prev;
	}
	
//	public static Node reverseOutplace(Node head) {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node a = new Node(1);
		Node b = new Node(2);
		//Node c = new Node(3);
		//Node d = new Node(4);
		//Node e = new Node(5);

		a.next = b;
/*		b.next = c;
		c.next = d;
		d.next = e;
*/
		Node curr = reverseList(a);
		while (curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}

	}// end of method

}
