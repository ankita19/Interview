package linkList;

import java.util.HashMap;
import java.util.Map;

public class RandomList {
	RandomListNode head;
	
	/**
	 * Definition for singly-linked list with a random pointer.
	 */
	
	class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  }
	
	
	public void addInList(int x) {
		
		RandomListNode new_node = new RandomListNode(x);
		
	
		if(head == null) {
			head = new RandomListNode(x);
			return;
		}
		new_node.next = null;
		RandomListNode curr = head;
			
				while(curr.next != null) 
					curr =curr.next;
		curr.next = new_node;
	}
	
	public void assignRandom() {
		RandomListNode curr = head;
		
		while(curr.next.next != null) {
			curr.random = curr.next.next;
			
			curr = curr.next;
		}
	}
	
	
	
	
 public void printList() {
	 RandomListNode curr = head;
	
	 

	 while(curr != null) {
		 System.out.print("Current : "+curr.label);
		 if(curr.random != null) {
		 System.out.println("Random : "+curr.random.label);
		 }
		 curr = curr.next;
		 
	 }
 }
	 
	
	    public RandomListNode copyRandomList(RandomListNode head) {
	    	
	        RandomListNode curr = head;
	        RandomListNode next = null;
	     
	        System.out.println(curr.label);
	        
	       //first pass to insert copy nodes
	        while(curr != null){
	            RandomListNode temp = new RandomListNode(curr.label);  
	            next = curr.next;
	            curr.next = temp;
	            temp.next = next;
	            curr = curr.next.next;
	        }
	        
	        
	        //second pass to assign random pointers
	        
	        curr = head;
	        while(curr != null){
	            if(curr.random !=null){
	                curr.next.random = curr.random.next;
	            }
	            
	            curr = curr.next.next;
	        }
	        
	        curr = head;
	        
	        RandomListNode dummyHead = new RandomListNode(0);
	        RandomListNode copy = null;
	        RandomListNode copyTail = dummyHead;
	   //1-1-2-2     
	        while(curr !=null) {
	        	
	        	next = curr.next.next; 
	        	copy = curr.next;
	        	
	        	copyTail.next = copy;
	        	copyTail = copyTail.next;
	        	
	        	curr.next = next; 	
	        	curr = curr.next;
	        }
	     
	        
	        return dummyHead.next;
	    }
	    
	    
	public RandomListNode createCopyLinearSpace(RandomListNode head) {
		
		if(head == null)
			return null;
		
		Map<RandomListNode , RandomListNode> copyMap = new HashMap<>();
		RandomListNode curr = head;
		
		while(curr != null) {
			copyMap.put(curr, new RandomListNode(curr.label));
			curr = curr.next;
		}
		
		
		curr = head;
		while(curr !=null) {
			copyMap.get(curr).next = copyMap.get(curr.next);
			
			if(curr.random !=null) {
				copyMap.get(curr).random = copyMap.get(curr.random);
			}
			
			curr = curr.next;
			
		}
		
		return copyMap.get(head);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomList list = new RandomList();
		
		list.addInList(1);
		list.addInList(2);
		list.addInList(3);
		list.addInList(4);
		list.addInList(5);
		list.addInList(6);
		list.addInList(7);
		list.assignRandom();
	
		//list.printList();
		RandomList list2 = new RandomList();
		
		//list2.head = list.createCopyLinearSpace(list.head);
		list2.head = list.copyRandomList(list.head);
		
		System.out.println("Printing list 2: " + list.head.label);
		list2.printList();
		
		
		
		
		
}

}
