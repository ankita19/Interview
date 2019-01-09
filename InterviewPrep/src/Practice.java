

public class Practice {

	private static Node h3;
	private static class Node{
		int value;
		Node next;
		Node(int val){
			value = val;
			next = null;
		}
	}//end of node
	
	private static Node reverse(Node head) {	
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while(curr.next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		curr.next = prev;
		
		return curr;
	}
	
	private static void printList(Node head) {
		while(head != null) {
			System.out.println(head.value);
			head= head.next;
		}
	}
	
	private static void addAtLast(Node node) {
		if(h3 == null)
			h3 = node;
		else 
		{
			Node curr = h3;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
			
		}
		
	}
	
	private static void addList(Node h1,Node h2) {
		int carry = 0;
		int valueToAdd = 0;
		int sum =0;
		while(h1 != null || h2!=null) {
			sum = carry;
			if(h1 != null){
				sum = sum+h1.value;
				h1 = h1.next;
			}
            if(h2 != null){		
				sum = sum+h2.value;
				h2 = h2.next;
			}
            
            System.out.println("sum" + sum);
			carry = sum/10;
			valueToAdd = sum%10;
			
			System.out.println("value" + valueToAdd);
			addAtLast(new Node(valueToAdd));
		}
		
		if(carry != 0) {
			System.out.println("carry"+carry);
			addAtLast(new Node(carry));
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.next = b;
		b.next = c;
		
		d.next = e;
		
		Node h1 = reverse(a);
		printList(h1);
		
		Node h2 = reverse(d);
		printList(h2);
		
		addList(h1, h2);
		
		printList(h3);
		Node h4 = reverse(h3);
		printList(h4);
		
}

}
