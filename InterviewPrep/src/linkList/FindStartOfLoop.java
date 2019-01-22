package linkList;

import linkList.DetectCycle.Node;

/*		
 * find start of loop in singly link list
 * 
 *why moving slow pointer to start works : 
 * 
Distance travelled by slowPointer= A+B
Distance travelled by fastPointer= (A+B+C) + B =A+2B+C
Let speed of slow pointer be X , so speed of fast pointer will be 2*X
As per simple distance speed, time relation:
(A+B)/X=A+2B+C/2*X
2*(A+B)=A+2B+C
2A+2B=A+2B+C
A=C
Hence if we set slowPointer to head and move both slowPointer and fastpointer by one node, 
they will meet at start node of loop.
 * */

public class FindStartOfLoop {

	public static class Node{
		
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public static Node detect_start_cycle(Node head) {
	
		if(head == null) return null;		
		Node slow = head;
		Node fast =  head;

		while(fast !=null && fast.next != null && fast.next.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;			
			if(slow == fast) {
			
				slow = head;
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast;
			}
		}
		
		return null;
		
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
		e.next = c;
		
		System.out.println(detect_start_cycle(a).val);

	}

}
