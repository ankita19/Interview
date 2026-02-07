package linkList;

 class AddTwoNumber {
	 
	 static class LinkNode{
			int value;
			LinkNode next;
			
			LinkNode(int val){
				this.value = val;
				this.next = null;
			}
		}

	 LinkNode head;
	 
	 
	 // leetcode clean	 
	    public LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
	        LinkNode dummyHead = new LinkNode(0);
	        int carry = 0;
	        LinkNode curr = dummyHead;
	        while(l1 != null || l2 !=null){
	            int sum =0;
	            int quo = 0;
	            int val1=0,val2=0;
	           
	            if(l1 !=null){
	                val1 = l1.value;
	                l1= l1.next;
	            }
	            
	            if(l2!=null){
	                val2 = l2.value;
	                l2=l2.next;
	            }            
	            sum = val1 + val2 + carry;
	            carry = sum/10;
	            quo = sum%10;
	            
	            curr.next = new LinkNode(quo);
	            curr = curr.next;
	       }
	        
	        if(carry !=0)
	            curr.next = new LinkNode(carry);
	        
	        return dummyHead.next;
	    }
	 
	 
	 public void printLinkList(LinkNode  head) {
			LinkNode current = head;
			
			while(current != null) {
				System.out.println(current.value);
				current = current.next;
			}
		}
	 
	 public void insertInto(int num , int after) {
		 
		 LinkNode newNode = new LinkNode(num);
		 LinkNode current = head; 
		 while(current.value != after) {
			 current = current.next;
		 }
		 LinkNode tmpNode = current.next;
		 current.next = newNode;
		 newNode.next = tmpNode;
	 }
	 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumber lList = new AddTwoNumber();
		
		lList.head = new LinkNode(1);
		LinkNode second = new LinkNode(1);
		LinkNode three = new LinkNode(1);
	
		lList.head.next = second;
		second.next = three;

		//lList.insertInto(7, 2);
		System.out.println("=========" + "first list");
		//lList.printLinkList();
		
		
AddTwoNumber l2 = new AddTwoNumber();
		
		l2.head = new LinkNode(1);
		LinkNode lsecond = new LinkNode(6);
		LinkNode lthree = new LinkNode(4);
	
		l2.head.next = lsecond;
		lsecond.next = lthree;
		System.out.println("=========" + "second list");
		//l2.printLinkList();
		
		System.out.println("=========" + "output list");

	}
	
	
	
	
	
	
	
	

}
