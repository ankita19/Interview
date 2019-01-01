package linkList;

/*detect cycle in singly link list
 
 * --------
 * Solution 1 - by maintaining hash set and check if node is already there
 * HashSet<Node> h = new HashSet<Node>();
 * h.contains(new_node);
 *  TC : O(n)
 * SC : O(n)
 * -------------
 * TC : O(n)
 * SC : O(1)
 * Solution : by maintaining two runners slow and fast.
 * Additional:
a. How would you detect the first node in the cycle? 
   Define the first node of the cycle as the one closest to the head of the list.
b. Would the program always work if the fast runner moves three steps every time the slow runner moves one step?
c. What if instead of a simple linked list, you had a structure where each node could have several "next" nodes? 
This data structure is called a "directed graph." How would you test if your directed graph had a cycle?
 
 Why this algorithm works
 https://stackoverflow.com/questions/2936213/explain-how-finding-cycle-start-node-in-cycle-linked-list-work 
 * 
 * */


public class DetectCycle {

	static class Node{
		Node next;
		int val;
		Node(int i){
			next = null;
			val = i;
		}
		
	}
	
	static boolean contains_cycle(Node head) {
		
		 Node slow = head;
	     Node fast = head;
	        
	        while( fast != null && fast.next!= null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	            if(slow == fast) 
	                return true;
	}
	        return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		//Node e = new Node(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = null;
		
		System.out.println(contains_cycle(a));
	
	}
	
	
	

}
