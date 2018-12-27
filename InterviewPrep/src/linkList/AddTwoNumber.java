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
	
	
	
	 public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
		    LinkNode dummyHead = new LinkNode(0);
		    LinkNode p = l1, q = l2, curr = dummyHead;
		    int carry = 0;
		    while (p != null || q != null) {
		        int x = (p != null) ? p.value : 0;
		        int y = (q != null) ? q.value : 0;
		        int sum = carry + x + y;
		        carry = sum / 10;
		        curr.next = new LinkNode(sum % 10);
		        curr = curr.next;
		        if (p != null) p = p.next;
		        if (q != null) q = q.next;
		    }
		    if (carry > 0) {
		        curr.next = new LinkNode(carry);
		    }
		    return dummyHead.next;
		}	 
	 
	 
	 
	 /**
	  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
	  * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static AddTwoNumber addTwoNum(AddTwoNumber l1, AddTwoNumber l2) {
		 LinkNode c1 = l1.head;
		 LinkNode c2 = l2.head;
		 AddTwoNumber l3 = new AddTwoNumber();
		 //LinkNode c3Head = l3.head;
		 LinkNode c3Current = null;
		 
		 int carrige = 0;
		 
		 if(c1 == null) return l2;
		 if(c2 == null) return l1;
		 
		 
		 while(c1!=null || c2 !=null) {
			 int num1=0;
			 int num2=0;
			 int sum = 0;
			// System.out.println( "In loop : " + c1.value +":" +  c2.value );
			 
			 if(c1!=null) 
				 {
				 num1 = c1.value;
				 c1 = c1.next;
				 }
			 else num1 = 0;
			 
			 
			 if(c2!=null) {
				 num2 = c2.value;
				 c2 = c2.next;
			 }else num2 =0;
			 
			 sum = num1+num2 + carrige;
			// carrige=0;
			 
			 System.out.println( "In loop sum: " + sum );
			 
			 int valueToAdd;
			/* if(sum < 10)
				 valueToAdd = sum;
	    	 else if(sum %10 ==0) {
	    		 valueToAdd = 0;
		    	  carrige = sum/10;
	    	 }
	    	 else*/
	    	  {valueToAdd = sum%10;
	    	  carrige = sum/10;
	    	  }
			 
			 
		    	if(l3.head== null)
		    	{
		    		l3.head = new LinkNode(valueToAdd);
		    		System.out.println( "In loop c3Head: " + l3.head.value );
		    	 
		    		c3Current = l3.head;
		    	}else {
		    		c3Current.next = new LinkNode(valueToAdd);
		    		System.out.println( "In loop c3Current: " + c3Current.value );
		    		c3Current = c3Current.next;
		    		
		    	}
		    	 
			 
			 
		 }
		 
		 
		 if(carrige > 0)
			 c3Current.next = new LinkNode(carrige);
		 return l3;
		 
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
		
		AddTwoNumber l3 = new AddTwoNumber();
		LinkNode l3Head = addTwoNumbers(lList.head , l2.head);
		l3.head = l3Head;
		l3.printLinkList(l3.head);
		
		AddTwoNumber l4 = addTwoNum(lList , l2);
		l4.printLinkList(l4.head);
		
	}
	
	
	
	
	
	
	
	

}
